package com.lightpickerbackend.service.impl.user;

import com.alibaba.fastjson.JSONObject;
import com.lightpickerbackend.dao.pojo.User;
import com.lightpickerbackend.service.impl.utils.UserDetailsImpl;
import com.lightpickerbackend.service.user.GetUserInfoService;
import com.lightpickerbackend.utils.BaseUtils;
import com.lightpickerbackend.vo.RespResult;
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
        res.put("hobby", BaseUtils.getHobbyList(user.getInterest()));
        return RespResult.success(res);
    }
}
