package com.hlwjbackend.controller.task;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hlwjbackend.dao.mapper.TaskMapper;
import com.hlwjbackend.dao.pojo.Task;
import com.hlwjbackend.vo.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class getTaskController {

	@Autowired
	private TaskMapper taskMapper;

	@GetMapping("/api/get/task/info/{id}/")
	public RespResult getTaskInfoById(@PathVariable String id) {
		Integer one = Integer.valueOf(id);
		Task task = taskMapper.selectById(one);
		JSONObject res = new JSONObject();
		res.put("task", task);
		return RespResult.success(res);
	}

	@GetMapping("/api/get/task/user/{userid}/")
	public RespResult getTaskInfoByUserId(@PathVariable String userid) {
		Integer id = Integer.valueOf(userid);
		LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(Task::getUserId, id).orderByAsc(Task::getId);
		List<Task> tasks = taskMapper.selectList(queryWrapper);
		JSONObject res = new JSONObject();
		res.put("task", tasks);
		return RespResult.success(res);
	}

	@GetMapping("/api/get/task/info/list/")
	public RespResult getTaskInfoList() {
		LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.orderByAsc(Task::getId);
		List<Task> tasks = taskMapper.selectList(queryWrapper);
		JSONObject res = new JSONObject();
		res.put("tasks", tasks);
		return RespResult.success(res);
	}
}
