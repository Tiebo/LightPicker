package com.hlwjbackend.service.user;


import com.hlwjbackend.vo.RespResult;

public interface LoginService {
    RespResult getToken(String username, String password);
}
