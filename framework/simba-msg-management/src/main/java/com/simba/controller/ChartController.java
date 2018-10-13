package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.controller.form.MsgAmountChartForm;
import com.simba.echarts.model.Chart;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.model.DayAmount;
import com.simba.model.TotalDayAmountBean;
import com.simba.service.DayAmountService;
import com.simba.service.MsgProjectService;

/**
 * Created by linshuo on 2017/12/12.
 */
@Controller
@RequestMapping("/chart")
public class ChartController {

	@Autowired
	private DayAmountService dayAmountService;

	@Autowired
	private MsgProjectService projectService;

	private static final int ALL_PROJECTS = -1;

	@RequestMapping("/eachDayAmount")
	@ResponseBody
	public String eachDayAmount(MsgAmountChartForm searchForm) {
		Date startTime = DateUtil.str2Date(searchForm.getStartTime(), DateUtil.DAY_FORMAT);
		Date endTime = DateUtil.str2Date(searchForm.getEndTime(), DateUtil.DAY_FORMAT);
		int projectId = searchForm.getProjectId();
		if (projectId == ALL_PROJECTS) {
			return getChartTotal(startTime, endTime);
		} else {
			return getChartByProjectId(startTime, endTime, projectId);
		}
	}

	private String getChartByProjectId(Date startTime, Date endTime, int projectId) {
		List<DayAmount> list = dayAmountService.getSendAmountEachDay(startTime, endTime, projectId);
		List<String> dateStrList = new ArrayList<>();
		list.forEach(bean -> dateStrList.add(DateUtil.date2String(bean.getDayDate(), DateUtil.DAY_FORMAT)));
		String projectName = projectService.get(projectId).getName();
		Chart chart = new Chart();
		List<List<Double>> bigList = new ArrayList<>();
		chart.setLegendList(Arrays.asList("用量"));
		chart.setSubtext("条/天");
		chart.setTitle(projectName + "短信用量");
		chart.setxAxisList(dateStrList);
		List<Double> tempList = new ArrayList<>();
		list.forEach(bean -> tempList.add((double) bean.getAmount()));
		bigList.add(tempList);
		chart.setValueList(bigList);
		return FastJsonUtil.toJson(chart);
	}

	private String getChartTotal(Date startTime, Date endTime) {
		List<TotalDayAmountBean> list = dayAmountService.getSendAmountEachDay(startTime, endTime);
		List<String> dateStrList = new ArrayList<>();
		list.forEach(bean -> dateStrList.add(bean.getDayDate()));
		Chart chart = new Chart();
		List<List<Double>> bigList = new ArrayList<>();
		chart.setLegendList(Arrays.asList("用量"));
		chart.setSubtext("条/天");
		chart.setTitle("短信总用量");
		chart.setxAxisList(dateStrList);
		List<Double> tempList = new ArrayList<>();
		list.forEach(bean -> tempList.add((double) bean.getTotal()));
		bigList.add(tempList);
		chart.setValueList(bigList);
		return FastJsonUtil.toJson(chart);
	}
}
