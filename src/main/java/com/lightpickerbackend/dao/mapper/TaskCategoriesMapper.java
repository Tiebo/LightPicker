package com.lightpickerbackend.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lightpickerbackend.dao.pojo.TaskCategories;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskCategoriesMapper extends BaseMapper<TaskCategories> {
	@Select("select * from task_categories where c_name = #{name}")
	TaskCategories getCategoryByName(@Param("name") String name);
}
