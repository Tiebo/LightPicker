package com.lightpickerbackend.utils;

import com.lightpickerbackend.dao.mapper.TaskCategoriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class BaseUtils {
	@Autowired
	private TaskCategoriesMapper taskCategoriesMapper;

	public static Date StringToDate(String str) {
		System.out.println("str = " + str);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			System.out.println("时间格式错误");
		}
		return date;
	}
	public static List<String> getHobbyList(String str) {
		if ("".equals(str) || str == null) {
			return new ArrayList<>();
		}
		String[] split = str.split(",");
		return new ArrayList<>(Arrays.asList(split));
	}

	public String getCategories(String str) {
		String[] split = str.split(",");
		StringBuilder res = new StringBuilder();
		for (int j = 0; j < split.length; j++) {
			String cName = taskCategoriesMapper.selectById(split[j]).getCName();
			if (j == 0)
				res.append(cName);
			else
				res.append(",").append(cName);
		}
		return res.toString();
	}
}
