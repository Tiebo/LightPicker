package com.lightpickerbackend.controller.User;

import com.alibaba.fastjson.JSONObject;
import com.lightpickerbackend.dao.mapper.UserMapper;
import com.lightpickerbackend.dao.pojo.User;
import com.lightpickerbackend.vo.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetUserByIdController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/api/get/user/info/{id}/")
    RespResult getUserInfoById(@PathVariable String id) {
        User user = userMapper.selectById(id);
        user.setPassword("0");
        JSONObject res = new JSONObject();
        res.put(user.getUsername(), user);
        return RespResult.success(res);
    }
}
