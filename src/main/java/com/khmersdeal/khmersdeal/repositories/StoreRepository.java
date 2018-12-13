package com.khmersdeal.khmersdeal.repositories;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.repositories.providers.StoreProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository {

    @SelectProvider(type = StoreProvider.class, method = "getAllStoresProvider")
    @Results({
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "id", property = "id"),
            @Result(column = "user_id", property = "user.id")

    })
    List<Store> getAllStores();
}
