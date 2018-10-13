package com.simba.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.framework.util.office.ExcelUtilFor2007;
import com.simba.model.MockProject;
import com.simba.model.UrlData;
import com.simba.service.ProjectService;
import com.simba.service.UrlDataService;

/**
 * 控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/urlData")
public class UrlDataController {

	@Autowired
	private UrlDataService urlDataService;

	@Autowired
	private ProjectService projectService;

	@RequestMapping("/list")
	public String list(int projectId, HttpServletRequest request) {
		request.getSession().setAttribute("projectId", projectId);
		return "urlData/list";
	}

	@RequestMapping("/backList")
	public String backList() {
		return "urlData/list";
	}

	@RequestMapping("/getList")
	public String getList(HttpServletRequest request, Pager pager, ModelMap model) {
		List<UrlData> urlDataList = urlDataService.pageBy("projectId", request.getSession().getAttribute("projectId"), pager);
		model.put("list", urlDataList);
		return "urlData/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(Integer projectId) {
		int count = urlDataService.count(projectId);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "urlData/add";
	}

	@RequestMapping("/add")
	public String add(UrlData urlData) {
		urlDataService.add(urlData);
		return "redirect:/urlData/backList";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(int id, ModelMap model) {
		UrlData urlData = urlDataService.get(id);
		model.put("urlData", urlData);
		return "urlData/update";
	}

	@RequestMapping("/update")
	public String update(UrlData urlData) {
		urlDataService.update(urlData);
		return "redirect:/urlData/backList";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(int id, ModelMap model) {
		urlDataService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		urlDataService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	@RequestMapping("/getExcel")
	@ResponseBody
	public ResponseEntity<byte[]> getExportExcel(HttpServletRequest req) throws Exception {
		Object projectId = req.getSession().getAttribute("projectId");
		List<UrlData> urlDataList = urlDataService.listBy("projectId", projectId);
		ResponseEntity<byte[]> responseEntity = null;
		if (null != urlDataList && !urlDataList.isEmpty()) {
			OutputStream out = new ByteArrayOutputStream();
			MockProject project = projectService.get(NumberUtils.toInt(Objects.toString(projectId)));
			List<List<String>> rows = new ArrayList<>();
			// add excel header
			List<String> header = new ArrayList<>();
			header.add("路径");
			header.add("数据");
			header.add("描述");
			rows.add(header);
			for (UrlData urlData : urlDataList) {
				List<String> record = new ArrayList<>();
				record.add(urlData.getUrl());
				record.add(urlData.getData());
				record.add(urlData.getDescription());
				rows.add(record);
			}

			List<Integer> widthList = new ArrayList<>();
			widthList.add(10000);
			widthList.add(20000);
			widthList.add(20000);
			String fileName = new String((project.getName() + ".xlsx").getBytes());
			ExcelUtilFor2007.write(out, project.getName(), rows, widthList);
			byte[] body = ((ByteArrayOutputStream) out).toByteArray();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment", fileName, Charset.forName("UTF-8"));
			HttpStatus status = HttpStatus.OK;
			responseEntity = new ResponseEntity<>(body, headers, status);
		}
		return responseEntity;
	}

	@RequestMapping("/importExcel")
	public String importExcel(HttpServletRequest req, @RequestParam MultipartFile file,boolean isRewrite) throws IOException {
		Object projectIdObj = req.getSession().getAttribute("projectId");
		int projectId = NumberUtils.toInt(Objects.toString(projectIdObj));
		List<UrlData> list = urlDataService.listBy("projectId", projectId);
		List<List<String>> table = ExcelUtilFor2007.read(file.getInputStream());
		List<String> urlList = new ArrayList<>(list.size());
		list.forEach((data) -> {
			urlList.add(data.getUrl());
		});

		for (int i = 1; i < table.size(); i++) {
			List<String> record = table.get(i);
			String url = record.get(0);
			if (!urlList.contains(url)&&isRewrite) {
				UrlData urlData = new UrlData();
				urlData.setUrl(url);
				urlData.setData(record.get(1));
				urlData.setDescription(record.get(2));
				urlData.setProjectId(projectId);
				urlDataService.add(urlData);
			}
		}

		return "redirect:/urlData/list?projectId=" + projectIdObj;
	}

}
