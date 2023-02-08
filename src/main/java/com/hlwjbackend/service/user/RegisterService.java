package com.hlwjbackend.service.user;


import com.hlwjbackend.vo.RespResult;

public interface RegisterService {
    RespResult register(String username, String password, String confirmPassword);
}
