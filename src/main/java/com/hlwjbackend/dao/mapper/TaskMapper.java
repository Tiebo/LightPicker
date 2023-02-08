package com.hlwjbackend.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hlwjbackend.dao.pojo.Task;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper extends BaseMapper<Task> {
}
