package com.lightpickerbackend.controller.task;

import com.alibaba.fastjson.JSONObject;
import com.lightpickerbackend.dao.mapper.TaskCategoriesMapper;
import com.lightpickerbackend.dao.pojo.TaskCategories;
import com.lightpickerbackend.vo.RespResult;
import com.lightpickerbackend.vo.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InsertCategoriesController {
	@Autowired
	private TaskCategoriesMapper taskCategoriesMapper;
	@PostMapping("/api/insert/task/categories/")
	public RespResult insertTaskCategories(@RequestParam Map<String, String> data) {
		String categoriesName = data.get("categories_name");
		TaskCategories categoryByName = taskCategoriesMapper.getCategoryByName(categoriesName);
		if (categoryByName != null) {
			System.out.println("已存在该分类");
			throw new SystemException(200, "已存在该分类");
		}
		JSONObject res = new JSONObject();
		res.put("err_message", "success");
		return RespResult.success(res);
	}
}
