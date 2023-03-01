package com.lightpickerbackend.service.task;

import com.lightpickerbackend.vo.RespResult;

import java.util.Map;

public interface InsertTaskService {
	 RespResult insertTask(Map<String, String> data);
}
