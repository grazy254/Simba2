package com.simba.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.model.MockProject;
import com.simba.model.UrlData;
import com.simba.service.ProjectService;
import com.simba.service.UrlDataService;

/**
 * 路由Controller
 *
 * @author caozhejun
 */
@RestController
@RequestMapping("/ut")
public class RouteController {

    private static final Log logger = LogFactory.getLog(RouteController.class);

    @Autowired
    private UrlDataService urlDataService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/{projectName}/{level1}")
    public String level1(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String data = dealUri(uri);
        return data;
    }

    @RequestMapping("/{projectName}/{level1}/{level2}")
    public String level2(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String data = dealUri(uri);
        return data;
    }

    @RequestMapping("/{projectName}/{level1}/{level2}/{level3}")
    public String level3(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String data = dealUri(uri);
        return data;
    }

    @RequestMapping("/{projectName}/{level1}/{level2}/{level3}/{level4}")
    public String level4(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String data = dealUri(uri);
        return data;
    }

    @RequestMapping("/{projectName}/{level1}/{level2}/{level3}/{level4}/{level5}")
    public String level5(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String data = dealUri(uri);
        return data;
    }

    @RequestMapping("/{projectName}/{level1}/{level2}/{level3}/{level4}/{level5}/{level6}")
    public String level6(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String data = dealUri(uri);
        return data;
    }

    private String dealUri(String uri) {
        logger.info("收到url请求:" + uri);
        String[] paths = uri.split("/");
        int projectIdx = 2;
        String project = paths[projectIdx];
        StringBuilder url = new StringBuilder();
        for (int i = projectIdx + 1; i < paths.length; i++) {
            url.append("/").append(paths[i]);
        }
        logger.info("项目:" + project + ",url:" + url);
        // 根据项目编号和url从数据库获取配置的对应的数据返回
        MockProject projectObj = projectService.getBy("code", project);
        int projectId = projectObj.getId();
        UrlData urlObj = urlDataService.getByAnd("url", url.toString(), "projectId", projectId);
        logger.info("返回数据:" + urlObj.getData());
        return urlObj.getData();
    }

}
