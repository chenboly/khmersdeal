package com.khmersdeal.khmersdeal.repositories.providers;

import com.khmersdeal.khmersdeal.models.Store;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import javax.management.ObjectName;

public class StoreProvider {

    public String getAllStoresProvider(){
        return new SQL(){{
            SELECT("*");
            FROM("d_store ds");
            INNER_JOIN("d_user du ON ds.user_id = du.id");
            WHERE("ds.status IS TRUE");
            ORDER_BY("ds.id");
        }}.toString();
    }

    public String saveStoreProvider(Store store){
        return new SQL(){{
            INSERT_INTO("d_store");
            VALUES("name", "#{name}");
            VALUES("image_url", "#{image_url}");
            VALUES("contact","#{contact}");
            VALUES("website","#{website}");
        }}.toString();
    }
    public String updateStoreProvider(Store store){
        return new SQL(){{
            UPDATE("d_store");
            SET("name=#{name}",
                    "image_url=#{image_url}",
                    "contact=#{contact}",
                    "website=#{website}");
            WHERE("id = #{id}");
        }}.toString();
    }
    public String deleteStoreProvider(@Param("id") Integer id){
        return new SQL(){{
            UPDATE("d_store");
            SET("status = FALSE");
            WHERE("id = #{id}");
        }}.toString();

    }
}


