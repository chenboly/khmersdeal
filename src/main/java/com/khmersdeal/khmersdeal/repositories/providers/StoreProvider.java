package com.khmersdeal.khmersdeal.repositories.providers;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.utilities.Paginate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import javax.management.ObjectName;

public class StoreProvider {

    //sql query without pagination
    public String getAllStoresProvider(String name){
        return new SQL(){{
            SELECT("*");
            FROM("d_store ds");
            INNER_JOIN("d_user du ON ds.user_id = du.id");
            //start for search
            if (name != null && !name.isEmpty()){
                System.out.println("ok check");
                WHERE("ds.name ilike '%' || #{name} || '%' ");
            }
            //end for search
            WHERE("ds.status IS TRUE");
            ORDER_BY("ds.id");
        }}.toString();
    }

    //sql query with pagination
    public String getAllStoresPaginateProvider(@Param("name") String name,
                                               @Param("paginate") Paginate paginate){
        return new SQL(){{
            SELECT("*");
            FROM("d_store ds");
            INNER_JOIN("d_user du ON ds.user_id = du.id");
            if (name != null && !name.isEmpty()){
                System.out.println("ok check");
                WHERE("ds.name ilike '%' || #{name} || '%' ");
            }
            WHERE("ds.status IS TRUE");
            ORDER_BY("ds.id asc LIMIT #{paginate.limit} OFFSET #{paginate.offset}");
//            ORDER_BY("ds.id");
        }}.toString();
    }

    public String saveStoreProvider(Store store){
        return new SQL(){{
            INSERT_INTO("d_store");
            VALUES("name", "#{name}");
            VALUES("image_url", "#{image_url}");
            VALUES("phone", "#{phone}");
            VALUES("website","#{website}");
            VALUES("email","#{email}");
            VALUES("address", "#{address}");
            VALUES("user_id", "#{user.id}");
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


