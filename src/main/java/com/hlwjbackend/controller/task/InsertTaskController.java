package com.hlwjbackend.controller.task;

import com.hlwjbackend.service.task.InsertTaskService;
import com.hlwjbackend.vo.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InsertTaskController {
	@Autowired
	private InsertTaskService insertTaskService;

	@PostMapping("/api/task/insert/")
	public RespResult insertTask(@RequestParam Map<String, String> data) {
		return insertTaskService.insertTask(data);
	}

}
