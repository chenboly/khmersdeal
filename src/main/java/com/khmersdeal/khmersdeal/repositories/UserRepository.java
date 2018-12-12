package com.khmersdeal.khmersdeal.repositories;

import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.repositories.providers.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository {

//    @Select("SELECT * FROM d_user WHERE status IS TRUE ORDER BY id")
//    mapping the different fields name from database field name and class field name (only different field name)
    @Results({
            @Result(column = "created_at", property = "createdAt")
    })
    //We can use provider for keep all SQL statements, that will make more dynamic
    @SelectProvider(type = UserProvider.class, method = "getAllUsersProvider")
    List<User> getAllUsers();

    @Insert("INSERT INTO d_user(fullname, username, password, image_url, phone, email)" +
            "VALUES (#{fullname},#{username},md5(#{password}),#{image_url},#{phone},#{email})")
    @InsertProvider(type = UserProvider.class, method = "saveProvider")
    int save(User user);

    @Update("UPDATE d_user SET fullname = #{p_user.fullname}, username = #{p_user.username}, password = md5(#{p_user.password})," +
            "image_url = #{p_user.image_url}, phone = #{p_user.phone}, email = #{p_user.email} WHERE id = #{p_user.id}")
    int update(@Param("p_user") User user);

    @Delete("UPDATE d_user SET status = FALSE WHERE id=#{id}")
    int delete(Integer id);
}
