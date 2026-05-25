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

    @Query("SELECT COUNT(*) FROM PRODUCTS")
    int getProductCount();

    @Query("SELECT COUNT(*) FROM PRODUCTS WHERE quantity = 0")
    int getNoStockCount();

    @Query("SELECT COUNT(*) FROM PRODUCTS WHERE quantity < 10")
    int getLowStockCount();

    @Query("SELECT SUM(quantity) FROM products")
    int getUnitStockCount();

    @Query("SELECT * FROM PRODUCTS WHERE :name = name")
    Product getProduct(String name);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}
