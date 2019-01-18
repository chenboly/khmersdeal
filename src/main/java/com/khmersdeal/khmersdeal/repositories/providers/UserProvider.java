package com.khmersdeal.khmersdeal.repositories.providers;
import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.utilities.Paginate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String getAllUsersProvider(String username){
        return new SQL(){{
            SELECT("*");
            FROM("d_user du");
            if (username != null && !username.isEmpty()){
                System.out.println("ok check");
                WHERE("du.username ilike '%' || #{username} || '%' ");
            }

            WHERE("du.status IS TRUE");
            ORDER_BY("du.id");
        }}.toString();
    }

    public String getAllUsersPaginateProvider(@Param("username") String username, @Param("paginate") Paginate paginate){
        return new SQL(){{
            SELECT("*");
            FROM("d_user du");
            if (username != null && !username.isEmpty()){
                WHERE("du.username ilike '%' || #{username} || '%' ");
            }
            WHERE("du.status IS TRUE");
            ORDER_BY("du.id desc LIMIT #{paginate.limit} OFFSET #{paginate.offset}");
        }}.toString();
    }

    public String getOneUserByIdProvider(Integer id){
        return new SQL(){{
            SELECT("*");
            FROM("d_user");
            WHERE("id = #{id}");

        }}.toString();
    }


    public String saveUsersProvider(@Param("p_user") User user){
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


    public String updateUsersProvider(User user){
        return new SQL(){{
            UPDATE("d_user");
            SET("fullname = #{fullname}");
            SET("phone = #{phone}");
            SET("email = #{email}");
            SET("active_status = #{activeStatus}");
            WHERE("id = #{id}");
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

