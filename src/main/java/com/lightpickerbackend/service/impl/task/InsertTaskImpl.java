package com.lightpickerbackend.service.impl.task;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lightpickerbackend.dao.mapper.TaskCategoriesMapper;
import com.lightpickerbackend.dao.mapper.TaskMapper;
import com.lightpickerbackend.dao.pojo.Task;
import com.lightpickerbackend.dao.pojo.TaskCategories;
import com.lightpickerbackend.service.task.InsertTaskService;
import com.lightpickerbackend.utils.BaseUtils;
import com.lightpickerbackend.vo.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InsertTaskImpl implements InsertTaskService {

	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private TaskCategoriesMapper taskCategoriesMapper;
	@Override
	public RespResult insertTask(Map<String, String> data) {

		Integer userId = Integer.valueOf(data.get("userId"));
		String name = data.get("name");
		Integer price = Integer.valueOf(data.get("price"));
		String phone = data.get("phone");
		String address = data.get("address");
		String start_time = data.get("startTime");
		String end_time = data.get("endTime");
		String cate = data.get("categories");
		String description = data.get("description");


		String[] cSplit = cate.split(",");
		StringBuilder categories = new StringBuilder();
		for (int i = 0; i < cSplit.length; i ++) {
			LambdaQueryWrapper<TaskCategories> lw = new LambdaQueryWrapper<>();
			lw.eq(TaskCategories::getId, cSplit[i]);
			TaskCategories taskCategories = taskCategoriesMapper.selectOne(lw);
			System.out.println(taskCategories);
			if (i == 0)
				categories.append(taskCategories.getId());
			else
				categories.append(",").append(taskCategories.getId());
		}
		taskMapper.insert(new Task(
				null,
				userId,
				name,
				price,
				phone,
				BaseUtils.StringToDate(start_time),
				BaseUtils.StringToDate(end_time),
				address,
				description,
				categories.toString()
		));
		JSONObject res = new JSONObject();
		res.put("error", "success");
		return RespResult.success(res);
	}
}
