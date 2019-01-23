package com.khmersdeal.khmersdeal.repositories;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.repositories.providers.StoreProvider;
import org.apache.ibatis.annotations.*;
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

    @InsertProvider(type = StoreProvider.class, method = "saveStoreProvider")
    boolean save(Store store);

    @UpdateProvider(type = StoreProvider.class, method = "updateStoreProvider")
    int update(@Param("p_store") Store store);

    @DeleteProvider(type = StoreProvider.class, method = "deleteStoreProvider")
    int delete(@Param("id") Integer id);
}
