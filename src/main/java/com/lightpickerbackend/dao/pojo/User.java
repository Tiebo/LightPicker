package com.lightpickerbackend.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String username;
	private Integer age;
	private String account;
	private String phone;
	private Integer gender; // 0-男, 1-女, 2-保密
	private String email;
	private String photo;
	private String password;
	private String interest;
	private String description;

}
