package com.simba;

import java.io.IOException;

import com.simba.codegenerate.CODETYPE;
import com.simba.codegenerate.CodeGenerateUtil;
import com.simba.codegenerate.PAGETYPE;
import com.simba.framework.util.file.PropertiesUtil;

import freemarker.template.TemplateException;

/**
 * 代码生成器入口
 * 
 * @author caozj
 *
 */
public class CodeGenerate {

	public static void main(String[] args) throws IOException, TemplateException {
		// 只需要将需要生成代码的class对象放入下面数组中，就可以自动生成代码
		Class<?>[] classes = new Class<?>[] {};
		// 将提前创建好的搜索用的Form类放入下面的数据组中
		// 如果没有搜索需求也要提供一个Form类，原因是如果做存在检查，会导致生成code的代码中要多处判断是否存该类相关变量
		Class<?>[] searchFormClasses = new Class<?>[] {};
		// 生成代码的dao层使用的方式，目前只支持枚举类型CODETYPE的类型
		CODETYPE codeType = CODETYPE.JDBC;
		// 生成代码的页面类型
		PAGETYPE pageType = PAGETYPE.TABLE;
		String path = CodeGenerate.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String projectName = PropertiesUtil.read("/application.properties").get("project.name");
		int index = path.indexOf("/target");
		String webPath = path.substring(0, index);
		// 下面的代码无需修改
		CodeGenerateUtil.getInstance().codeGenerate(classes, searchFormClasses, codeType, pageType, projectName, webPath);
		System.exit(0);
	}

}
