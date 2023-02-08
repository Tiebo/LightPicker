package com.hlwjbackend.service.impl.user;

import com.alibaba.fastjson.JSONObject;
import com.hlwjbackend.dao.pojo.User;
import com.hlwjbackend.service.impl.utils.UserDetailsImpl;
import com.hlwjbackend.service.user.GetUserInfoService;
import com.hlwjbackend.vo.RespResult;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetUserInfoImpl implements GetUserInfoService {
    @Override
    public RespResult getUserInfo() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = userDetails.getUser();

        user.setPassword("0");
        JSONObject res = new JSONObject();
        res.put("user", user);
        return RespResult.success(res);
    }
}
