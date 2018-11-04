package com.tj.base.mapper;

import com.tj.base.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

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


    @Select("select * from user")
    @Results({
            @Result(column = "create_time" ,property = "createTime") //多个用逗号隔开
    })
    List<User> getAll();

    /**
     * 功能描述：根据ID查找对象
     * @param id
     * @return
     */
    @Select(" select * from user where id = #{id}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    User findById(long id);

    /**
     * 功能描述：更新对象
     * @param user
     */
    @Update(" update user set name=#{name} where id=#{id}")
    void update(User user);

    /**
     * 功能描述：根据ID删除用户
     * @param userId
     */
    @Delete("Delete from user where id=#{userId}")
    void delete(Long userId);
}
