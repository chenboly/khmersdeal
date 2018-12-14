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
    public String updateStoreProvider(@Param("p_store") Store store){
        return new SQL(){{
            UPDATE("d_store");
            SET("name=#{p_store.name}",
                    "image_url=#{p_store.image_url}",
                    "contact=#{p_store.contact}",
                    "website=#{p_store.website}");
            WHERE("id = #{p_store.id}");
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


