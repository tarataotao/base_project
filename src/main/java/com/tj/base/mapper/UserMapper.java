package com.tj.base.mapper;

import com.tj.base.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * 功能描述：访问数据库的接口
 */
public interface UserMapper {

    /**
     * 推荐使用#{}取值，不要${},因为存在注入风险
     * keyProperty java对象属性
     * keyColumn 数据库钟对应的列
     * @param user
     * @return
     */
    @Insert("INSERT INTO user(name,phone,create_time,age) values (#{name},#{phone},#{createTime},#{age})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(User user);


}
