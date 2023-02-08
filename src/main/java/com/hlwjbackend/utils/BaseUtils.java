package com.hlwjbackend.utils;

import com.hlwjbackend.vo.SystemException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseUtils {
	public static Date StringToDate(String str) {
		System.out.println("str = " + str);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
