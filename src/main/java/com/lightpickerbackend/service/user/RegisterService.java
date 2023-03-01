package com.lightpickerbackend.service.user;


import com.lightpickerbackend.vo.RespResult;

public interface RegisterService {
    RespResult register(String account, String password, String confirmPassword);
}
