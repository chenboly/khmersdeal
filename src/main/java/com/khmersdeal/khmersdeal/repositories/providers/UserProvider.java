package com.khmersdeal.khmersdeal.repositories.providers;
import com.khmersdeal.khmersdeal.models.User;
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
}
