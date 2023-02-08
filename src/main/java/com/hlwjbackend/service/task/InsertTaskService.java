package com.hlwjbackend.service.task;

import com.hlwjbackend.vo.RespResult;

import java.util.Map;

public interface InsertTaskService {
	 RespResult insertTask(Map<String, String> data);
}
