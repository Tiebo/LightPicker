package com.lightpickerbackend.service.user;

import com.lightpickerbackend.vo.RespResult;

import java.util.Map;

public interface UpdateUserInfo {
	RespResult updateUserInfo(Map<String, String> data);
}
