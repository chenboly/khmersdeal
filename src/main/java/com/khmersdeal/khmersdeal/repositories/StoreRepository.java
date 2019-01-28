package com.khmersdeal.khmersdeal.repositories;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.repositories.providers.StoreProvider;
import com.khmersdeal.khmersdeal.utilities.Paginate;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository {


    @SelectProvider(type = StoreProvider.class, method = "getOneStoreByIdProvider")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "user_id", property = "id"),
            @Result(column = "user_id", property = "user", one = @One(select = "getUserById"))
    })
    Store getOneStoreById(Integer id);

    // without pagination
    @SelectProvider(type = StoreProvider.class, method = "getAllStoresProvider")
    //  mapping the different fields name from database field name and class field name (only different field name)
    @Results({
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "id", property = "id"),
            @Result(column = "user_id", property = "user.id"),
            @Result(column = "user_id", property = "user", one = @One(select = "getUserById"))

    })
    List<Store> getAllStores(String name);

    // with pagination
    @SelectProvider(type = StoreProvider.class, method = "getAllStoresPaginateProvider")
    //  mapping the different fields name from database field name and class field name (only different field name)
    @Results({
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "id", property = "id"),
            @Result(column = "user_id", property = "user.id"),
            @Result(column = "user_id", property = "user", one = @One(select = "getUserById"))

    })
    List<Store> getAllStoresPagination(@Param("name") String name, @Param("paginate") Paginate paginate);

    //count all row name of d_store for paginate
    @Select("SELECT count(*) FROM d_store WHERE name ilike '%' || #{name} || '%'")
    int count(String name);


    @Select("SELECT * FROM d_user WHERE id = #{user_id}")
    @Results({
            @Result(column = "created_at", property = "createdAt")
    })
    User getUserById(@Param("user_id") Integer id);

    @InsertProvider(type = StoreProvider.class, method = "saveStoreProvider")
    boolean save(Store store);

    @UpdateProvider(type = StoreProvider.class, method = "updateStoreProvider")
    int update(@Param("p_store") Store store);

    @DeleteProvider(type = StoreProvider.class, method = "deleteStoreProvider")
    int delete(@Param("id") Integer id);
}
