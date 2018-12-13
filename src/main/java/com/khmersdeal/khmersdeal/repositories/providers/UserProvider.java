package com.khmersdeal.khmersdeal.repositories.providers;
import com.khmersdeal.khmersdeal.models.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String getAllUsersProvider(){
        return new SQL(){{
            SELECT("*");
            FROM("d_user");
            WHERE("status IS TRUE");
            ORDER_BY("id");
        }}.toString();
    }

    public String saveUsersProvider(User user){
        return new SQL(){{
            INSERT_INTO("d_user");
            VALUES ("fullname", "#{fullname}");
            VALUES("username", "#{username}");
            VALUES("password", "md5(#{password})");
            VALUES("image_url", "#{image_url}");
            VALUES("phone", "#{phone}");
            VALUES("email", "#{email}");
        }}.toString();
    }


    public String updateUsersProvider(@Param("p_user") User user){
        return new SQL(){{
            UPDATE("d_user");
            SET("fullname = #{p_user.fullname}",
                    "username = #{p_user.username}",
                    "password = md5(#{p_user.password})",
                    "image_url = #{p_user.image_url}",
                    "phone = #{p_user.phone}",
                    "email = #{p_user.email}");
            WHERE("id = #{p_user.id}");
        }}.toString();
    }

    public String deleteUsersProvider(@Param("id") Integer id){
        return new SQL(){{
            UPDATE("d_user");
            SET("status = FALSE");
            WHERE("id = #{id}");
        }}.toString();
    }
}

