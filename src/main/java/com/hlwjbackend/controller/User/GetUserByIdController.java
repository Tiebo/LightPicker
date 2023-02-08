package com.hlwjbackend.controller.User;

import com.alibaba.fastjson.JSONObject;
import com.hlwjbackend.dao.mapper.UserMapper;
import com.hlwjbackend.dao.pojo.User;
import com.hlwjbackend.vo.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GetUserByIdController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/api/get/user/info/{id}/")
    RespResult getUserInfoById(@PathVariable String id) {
        User user = userMapper.selectById(id);
        JSONObject res = new JSONObject();
        res.put("username", user.getUsername());
        return RespResult.success(res);
    }
}
