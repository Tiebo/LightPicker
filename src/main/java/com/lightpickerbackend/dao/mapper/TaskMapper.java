package com.lightpickerbackend.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lightpickerbackend.dao.pojo.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskMapper extends BaseMapper<Task> {
	@Select("select * from task where name = #{name}")
	Task getTaskByName(@Param("name") String name);
}
