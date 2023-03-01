package com.lightpickerbackend.controller.task;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lightpickerbackend.dao.mapper.TaskMapper;
import com.lightpickerbackend.dao.pojo.Task;
import com.lightpickerbackend.utils.BaseUtils;
import com.lightpickerbackend.vo.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class getTaskController {

	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private BaseUtils baseUtils;

	@GetMapping("/api/get/task/info/{id}/")
	public RespResult getTaskInfoById(@PathVariable String id) {
		Integer one = Integer.valueOf(id);
		Task task = taskMapper.selectById(one);
		String categories = baseUtils.getCategories(task.getTaskCategories());
		task.setTaskCategories(categories);
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
		for (Task task : tasks) {
			String categories = baseUtils.getCategories(task.getTaskCategories());
			task.setTaskCategories(categories);
		}
		JSONObject res = new JSONObject();
		res.put("task", tasks);
		return RespResult.success(res);
	}
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@GetMapping("/api/get/task/info/list/")
	public RespResult getTaskInfoList() {
		redisTemplate.opsForValue().set("k1", "v1");
		Object k1 = redisTemplate.opsForValue().get("k1");
		System.out.println("k1" + k1);

		LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.orderByAsc(Task::getId);
		List<Task> tasks = taskMapper.selectList(queryWrapper);
		for (Task task : tasks) {
			String categories = baseUtils.getCategories(task.getTaskCategories());
			task.setTaskCategories(categories);
		}
		JSONObject res = new JSONObject();
		res.put("tasks", tasks);
		return RespResult.success(res);
	}
	@PostMapping("/api/get/task/like/all/")
	public RespResult getTaskInfoLike(@RequestParam Map<String, String> data) {
		String taskName = data.get("task_name");
		LambdaQueryWrapper<Task> lqw = new LambdaQueryWrapper<>();
		lqw.like(Task::getName, taskName);
		List<Task> tasks = taskMapper.selectList(lqw);
		for (Task task : tasks) {
			String categories = baseUtils.getCategories(task.getTaskCategories());
			task.setTaskCategories(categories);
		}
		JSONObject res = new JSONObject();
		res.put("tasks", tasks);
		return RespResult.success(res);
	}
}
