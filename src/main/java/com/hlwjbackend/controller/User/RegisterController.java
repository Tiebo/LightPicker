package com.hlwjbackend.controller.User;

import com.hlwjbackend.service.user.RegisterService;
import com.hlwjbackend.vo.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/api/user/account/register/")
    public RespResult Register(@RequestParam Map<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");
        String confirmPassword = data.get("confirm_password");
        return registerService.register(username, password, confirmPassword);
    }

}
