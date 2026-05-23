package com.zybooks.myassettracker.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.zybooks.myassettracker.Entities.Product;

import java.util.List;

@Dao
public interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Product product);

    @Query("SELECT * FROM PRODUCTS")
    List<Product> getAllProducts();

    @Query("SELECT * FROM PRODUCTS WHERE :name = name")
    Product getProduct(String name);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}
