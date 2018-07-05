package com.simba.database.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据库Controller
 * @author caozhejun
 *
 */
@Controller
@RequestMapping("/db")
public class DBController {

	/**
	 * 将数据库表结构导出Word
	 * @param response
	 */
	@RequestMapping("/exportWord")
	public void exportWord(HttpServletResponse response){
		
	}
	
}
