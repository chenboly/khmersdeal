package com.khmersdeal.khmersdeal.repositories;
import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.repositories.providers.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository {

//  @Select("SELECT * FROM d_user WHERE status IS TRUE ORDER BY id")
//  We can use provider for keep all SQL statements, that will make more dynamic
    @SelectProvider(type = UserProvider.class, method = "getAllUsersProvider")

//  mapping the different fields name from database field name and class field name (only different field name)
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "active_status", property = "activeStatus"),
            @Result(column = "id" , property = "stores", many = @Many(select = "getAllStoreByUserID"))
    })
    List<User> getAllUsers(String username);

//    get one user by id

    @SelectProvider(type = UserProvider.class, method = "getOneUserByIdProvider")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "active_status", property = "activeStatus")
    })
    User getOneUser(Integer id);

    //get all store by userID
    @Select("SELECT * FROM d_store WHERE user_id = #{id}")
//  mapping the different fields name between POJO class and database field name
    @Results({
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "active_status", property = "activeStatus")
    })
    List<Store> getAllStoreByUserID(Integer id);


//    @Insert("INSERT INTO d_user(fullname, username, password, image_url, phone, email)" +
//            "VALUES (#{fullname},#{username},md5(#{password}),#{image_url},#{phone},#{email})")
    @InsertProvider(type = UserProvider.class, method = "saveUsersProvider")
    boolean save(User user);

//    @Update("UPDATE d_user SET fullname = #{p_user.fullname}, username = #{p_user.username}, password = md5(#{p_user.password})," +
//            "image_url = #{p_user.image_url}, phone = #{p_user.phone}, email = #{p_user.email} WHERE id = #{p_user.id}")
    @UpdateProvider(type = UserProvider.class, method = "updateUsersProvider")
//    boolean update(@Param("p_user") User user);
    boolean update (User user);

//    @Delete("UPDATE d_user SET status = FALSE WHERE id=#{id}")
    @DeleteProvider(type = UserProvider.class, method = "deleteUsersProvider")
    int delete(@Param("id") Integer id);
}
