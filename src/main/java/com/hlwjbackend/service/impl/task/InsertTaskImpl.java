package com.hlwjbackend.service.impl.task;

import com.hlwjbackend.dao.mapper.TaskMapper;
import com.hlwjbackend.dao.pojo.Task;
import com.hlwjbackend.service.task.InsertTaskService;
import com.hlwjbackend.utils.BaseUtils;
import com.hlwjbackend.vo.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InsertTaskImpl implements InsertTaskService {

	@Autowired
	private TaskMapper taskMapper;
	@Override
	public RespResult insertTask(Map<String, String> data) {
		Integer userId = Integer.valueOf(data.get("userId"));
		String name = data.get("name");
		Integer price = Integer.valueOf(data.get("price"));
		String phone = data.get("phone");
		String address = data.get("address");
		Integer sex = Integer.valueOf(data.get("sex"));
		String start_time = data.get("startTime");
		String end_time = data.get("endTime");


		taskMapper.insert(new Task(
				null,
				userId,
				name,
				price,
				phone,
				address,
				sex,
				BaseUtils.StringToDate(start_time),
				BaseUtils.StringToDate(end_time)
		));
		return RespResult.success(null);
	}
}
