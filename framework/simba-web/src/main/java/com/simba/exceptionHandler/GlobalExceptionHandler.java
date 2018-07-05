package com.simba.exceptionHandler;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.simba.exception.ErrorCodeException;
import com.simba.exception.ForbidException;
import com.simba.exception.LoginException;
import com.simba.framework.util.common.ExceptionUtil;
import com.simba.framework.util.common.SystemUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.registry.util.RegistryUtil;
import com.simba.util.EmailUtil;

@ControllerAdvice
class GlobalExceptionHandler {

	private static final Log logger = LogFactory.getLog(GlobalExceptionHandler.class);

	public static final String DEFAULT_ERROR_VIEW = "error";

	@Value("${page.login}")
	private String loginPage;

	@Value("${page.error}")
	private String errorPage;

	@Value("${page.forbid}")
	private String forbidPage;

	@Resource
	private TaskExecutor taskExecutor;

	@Autowired
	private EmailUtil emailUtil;

	@PostConstruct
	private void init() {
		loginPage = StringUtils.defaultIfEmpty(loginPage, "login");
		errorPage = StringUtils.defaultIfEmpty(errorPage, "error/error");
		forbidPage = StringUtils.defaultIfEmpty(forbidPage, "error/forbid");
	}

	@ExceptionHandler(value = Throwable.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.error("发生异常", e);
		dealExceptionAlarmAsync(e);
		ModelAndView model = new ModelAndView();
		if (isJsonException(req)) {
			model.setViewName("message");
			String message = null;
			if (e instanceof ErrorCodeException) {
				message = new JsonResult(e.getMessage(), ((ErrorCodeException) e).getCode()).toJson();
			} else {
				message = new JsonResult(e.getMessage(), 400).toJson();
			}
			String callback = req.getParameter("callback");
			if (StringUtils.isNotEmpty(callback)) {
				message = callback + "(" + message + ")";
			}
			model.addObject("message", message);
		} else if (e instanceof LoginException) {
			model.addObject("top", true);
			model.setViewName(loginPage);
		} else if (e instanceof ForbidException) {
			model.setViewName(forbidPage);
		} else {
			model.setViewName(errorPage);
			model.addObject("message", ExceptionUtil.getStackTrace(e));
		}
		return model;
	}

	/**
	 * 处理异常警报邮件
	 * 
	 * @param e
	 * @throws UnknownHostException
	 */
	private void dealExceptionAlarmAsync(Exception e) {
		taskExecutor.execute(() -> {
			try {
				dealExceptionAlarm(e);
			} catch (UnknownHostException e1) {
				logger.error("发送异常邮件发生异常", e1);
			}
		});
	}

	private void dealExceptionAlarm(Exception e) throws UnknownHostException {
		boolean alarmAnabled = true;
		if (!"true".equals(RegistryUtil.get("alarm.exception.email.enabled"))) {
			alarmAnabled = false;
		}
		if (!alarmAnabled) {
			return;
		}
		String alarmEmail = RegistryUtil.get("alarm.email");
		String includeExceptionClass = RegistryUtil.get("alarm.exception");
		String excludeExceptionClass = RegistryUtil.get("alarm.exclude.exception");
		List<String> includeExceptionClassList = null;
		List<String> excludeExceptionClassList = null;
		List<String> alarmEmailList = null;
		if (StringUtils.isEmpty(includeExceptionClass) || "all".equalsIgnoreCase(includeExceptionClass)) {
			includeExceptionClassList = new ArrayList<>(0);
		} else {
			String[] classes = includeExceptionClass.split(",");
			includeExceptionClassList = new ArrayList<>(classes.length);
			for (String className : classes) {
				if (StringUtils.isNotEmpty(className)) {
					includeExceptionClassList.add(className);
				}
			}
		}
		if (StringUtils.isEmpty(excludeExceptionClass) || "none".equalsIgnoreCase(excludeExceptionClass)) {
			excludeExceptionClassList = new ArrayList<>(0);
		} else {
			String[] classes = excludeExceptionClass.split(",");
			excludeExceptionClassList = new ArrayList<>(classes.length);
			for (String className : classes) {
				if (StringUtils.isNotEmpty(className)) {
					excludeExceptionClassList.add(className);
				}
			}
		}
		if (StringUtils.isEmpty(alarmEmail)) {
			alarmEmailList = new ArrayList<>(0);
		} else {
			String[] emails = alarmEmail.split(",");
			alarmEmailList = new ArrayList<>(emails.length);
			for (String email : emails) {
				if (StringUtils.isNotEmpty(email)) {
					alarmEmailList.add(email);
				}
			}
		}
		if (alarmAnabled && alarmEmailList.size() > 0) {
			String name = e.getClass().getName();
			if (includeExceptionClassList.size() == 0 || includeExceptionClassList.contains(name)) {
				if (excludeExceptionClassList.size() == 0 || !excludeExceptionClassList.contains(name)) {
					sendExceptionEmail(e, alarmEmailList);
				}
			}
		}
	}

	/**
	 * 发送异常邮件
	 * 
	 * @param e
	 * @throws UnknownHostException
	 */
	private void sendExceptionEmail(Exception e, List<String> alarmEmailList) throws UnknownHostException {
		String message = ExceptionUtil.getStackTrace(e);
		String projectName = RegistryUtil.get("spring.application.name");
		String machineName = SystemUtil.getMachineName();
		String ip = SystemUtil.getIpAddress();
		String title = "系统发生异常[项目编号:" + projectName + "][机器名:" + machineName + "][ip地址:" + ip + "][异常消息:" + e.getMessage() + "]";
		alarmEmailList.forEach((email) -> {
			emailUtil.send(email, title, message);
		});
	}

	/**
	 * 判断是否是json格式请求，如果是json格式请求，返回json格式错误信息
	 * 
	 * @param request
	 * @return
	 */
	private boolean isJsonException(HttpServletRequest request) {
		boolean isJson = false;
		if (request.getParameter("json") != null || request.getParameter("jsonp") != null || (request.getHeader("Accept") != null && request.getHeader("Accept").indexOf("json") > -1
				|| request.getRequestURI().endsWith(".json") || request.getRequestURI().endsWith(".jsonp"))) {
			isJson = true;
		}
		return isJson;
	}
}