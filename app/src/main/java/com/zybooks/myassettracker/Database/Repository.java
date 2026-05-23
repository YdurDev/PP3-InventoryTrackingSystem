package com.zybooks.myassettracker.Database;


import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyCallback;

import com.zybooks.myassettracker.DAO.ProductDAO;
import com.zybooks.myassettracker.Entities.Product;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kotlin.internal.ProgressionUtilKt;

public class Repository {
    //----------------------------Registering Repo Tools(DAO) and Storage buckets(Lists)----------------
    public ProductDAO mProductDAO;
    public List<Product> mProducts;

    //--------------------------Implementing Thread-Pool-----------------------------------

    public static int THREAD_POOL_SIZE = 5;

    ExecutorService databaseExecutor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    //---------------------------Constructor---------------------------

    public Repository(Application application) {
        DatabaseInitializer dbInstance = DatabaseInitializer.getInstance(application);
        mProductDAO = dbInstance.productDAO();
    }


    //---------------------------Product: Getter/Setters---------------------------

    public void insert(Product product){
        databaseExecutor.execute(()->{
            mProductDAO.insert(product);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getmProducts(){
        databaseExecutor.execute(()->{
            mProducts = mProductDAO.getAllProducts();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mProducts;
    }

    public void update(Product product){
        databaseExecutor.execute(()->{
            mProductDAO.update(product);
        });
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Product product){
        databaseExecutor.execute(()->{
            mProductDAO.delete(product);
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}

