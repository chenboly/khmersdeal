package com.khmersdeal.khmersdeal.repositories.providers;

import org.apache.ibatis.jdbc.SQL;

public class StoreProvider {

    public String getAllStoreProviders(){
        return new SQL(){{
            SELECT("*");
            FROM("d_store");
            WHERE("status IS TRUE");
            ORDER_BY("id");
        }}.toString();
    }
}
