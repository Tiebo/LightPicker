package com.lightpickerbackend.controller.User;

import com.lightpickerbackend.service.user.GetUserInfoService;
import com.lightpickerbackend.vo.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserInfoController {
    @Autowired
    private GetUserInfoService getUserInfoService;

    @GetMapping("/api/user/account/info/")
    public RespResult getUserInfo() {
        return getUserInfoService.getUserInfo();
    }
}
