package com.lightpickerbackend.service.user;


import com.lightpickerbackend.vo.RespResult;

public interface LoginService {
    RespResult getToken(String account, String password);
}
