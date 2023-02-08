package com.hlwjbackend.service.impl.user;

import com.alibaba.fastjson.JSONObject;
import com.hlwjbackend.dao.mapper.UserMapper;
import com.hlwjbackend.dao.pojo.User;
import com.hlwjbackend.service.impl.utils.UserDetailsImpl;
import com.hlwjbackend.service.user.LoginService;
import com.hlwjbackend.utils.JwtUtil;
import com.hlwjbackend.vo.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class LoginImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserMapper userMapper;
    @Override
    public RespResult getToken(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticate.getPrincipal();

        User user = userDetails.getUser();

        String jwt = JwtUtil.createJWT(user.getId().toString());
        JSONObject res = new JSONObject();

        res.put("token", jwt);
        return RespResult.success(res);
    }
}
