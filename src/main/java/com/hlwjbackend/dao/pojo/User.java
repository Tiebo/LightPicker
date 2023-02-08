package com.hlwjbackend.dao.pojo;

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
	private String status;
	private String phone;
	private String email;
	private String photo;
	private String password;
	private String interest;
	private String description;

}
