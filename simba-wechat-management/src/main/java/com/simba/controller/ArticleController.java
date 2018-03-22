package com.simba.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.Article;
import com.simba.model.ForeverMedia;
import com.simba.model.TempMedia;
import com.simba.model.UploadNews;
import com.simba.model.enums.ArticleType;
import com.simba.model.form.ArticleSearchForm;
import com.simba.service.ArticleService;
import com.simba.service.ForeverMediaService;
import com.simba.service.TempMediaService;
import com.simba.service.UploadNewsService;

/**
 * 图文内容控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ForeverMediaService foreverMediaService;

	@Autowired
	private UploadNewsService uploadNewsService;

	@Autowired
	private TempMediaService tempMediaService;

	/**
	 * 获取图文集合
	 * 
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getArticles")
	public JsonResult getArticles(String[] ids) {
		List<Map<String, Object>> list = new ArrayList<>(ids.length);
		for (String id : ids) {
			if (StringUtils.isEmpty(id)) {
				continue;
			}
			Article article = articleService.get(NumberUtils.toLong(id));
			Map<String, Object> map = new HashMap<>(2);
			map.put("id", article.getId());
			map.put("title", article.getTitle());
			list.add(map);
		}
		return new JsonResult(list);
	}

	/**
	 * 查看内容
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/showContent")
	public String showContent(long id, ModelMap model) {
		Article article = articleService.get(id);
		model.put("article", article);
		return "article/showContent";
	}

	/**
	 * 选择图文内容
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectArticle")
	public String selectArticle(ModelMap model, int type) {
		model.put("type", type);
		return "article/selectArticle";
	}

	/**
	 * 查看图文内容
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/showArticleForNews")
	public String showArticleForNews(long id, ModelMap model) {
		UploadNews news = uploadNewsService.get(id);
		String articles = news.getArticles();
		String[] articleIds = articles.split(",");
		List<Article> list = new ArrayList<>(articleIds.length);
		for (String articleId : articleIds) {
			if (StringUtils.isEmpty(articleId)) {
				continue;
			}
			Article article = articleService.get(NumberUtils.toLong(articleId));
			String mediaId = article.getThumbMediaId();
			article.setImageUrl(getImageUrl(mediaId, article.getType()));
			list.add(article);
		}
		model.put("list", list);
		return "article/showArticle";
	}

	/**
	 * 查看图文内容
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/showArticle")
	public String showArticle(long id, ModelMap model) {
		ForeverMedia media = foreverMediaService.get(id);
		String articles = media.getArticles();
		String[] articleIds = articles.split(",");
		List<Article> list = new ArrayList<>(articleIds.length);
		for (String articleId : articleIds) {
			if (StringUtils.isEmpty(articleId)) {
				continue;
			}
			Article article = articleService.get(NumberUtils.toLong(articleId));
			String mediaId = article.getThumbMediaId();
			article.setImageUrl(getImageUrl(mediaId, article.getType()));
			list.add(article);
		}
		model.put("list", list);
		return "article/showArticle";
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("types", ArticleType.values());
		return "article/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ArticleSearchForm searchForm, ModelMap model) {
		List<Article> list = articleService.page(pager, searchForm);
		list.forEach((article) -> {
			String mediaId = article.getThumbMediaId();
			article.setImageUrl(getImageUrl(mediaId, article.getType()));
		});
		model.put("list", list);
		return "article/table";
	}

	private String getImageUrl(String mediaId, Integer type) {
		String imageUrl = StringUtils.EMPTY;
		if (ArticleType.TEMP.getId() == type) {
			List<TempMedia> list = tempMediaService.listBy("mediaId", mediaId);
			if (list.size() > 0) {
				imageUrl = list.get(0).getFileUrl();
			}
		} else if (ArticleType.FOREVER.getId() == type) {
			List<ForeverMedia> list = foreverMediaService.listBy("mediaId", mediaId);
			if (list.size() > 0) {
				imageUrl = list.get(0).getFileUrl();
			}
		}
		return imageUrl;
	}

	@RequestMapping("/getSelectList")
	public String getSelectList(Pager pager, ArticleSearchForm searchForm, ModelMap model) {
		List<Article> list = articleService.page(pager, searchForm);
		list.forEach((article) -> {
			String mediaId = article.getThumbMediaId();
			article.setImageUrl(getImageUrl(mediaId, article.getType()));
		});
		model.put("list", list);
		return "article/selectTable";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(ArticleSearchForm searchForm) {
		int count = articleService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		model.put("types", ArticleType.values());
		return "article/add";
	}

	@RequestMapping("/add")
	public String add(Article article, MultipartFile file) throws IOException, FastdfsException {
		articleService.add(article, file);
		return "redirect:/article/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		Article article = articleService.get(id);
		String mediaId = article.getThumbMediaId();
		article.setImageUrl(getImageUrl(mediaId, article.getType()));
		model.put("article", article);
		model.put("types", ArticleType.values());
		return "article/update";
	}

	@RequestMapping("/update")
	public String update(Article article, MultipartFile file) throws IOException, FastdfsException {
		articleService.update(article, file);
		return "redirect:/article/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		articleService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		articleService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
