package com.khmersdeal.khmersdeal.repositories.providers;

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
}

//select *
//        from d_store inner join d_user du on d_store.user_id = du.id;
