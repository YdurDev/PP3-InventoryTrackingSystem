package com.zybooks.myassettracker.Database;


import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyCallback;

import com.zybooks.myassettracker.DAO.ActivityDAO;
import com.zybooks.myassettracker.DAO.ProductDAO;
import com.zybooks.myassettracker.Entities.Activity;
import com.zybooks.myassettracker.Entities.Product;
import com.zybooks.myassettracker.UTIL.ActivityType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kotlin.internal.ProgressionUtilKt;

public class Repository {
    //----------------------------Registering Repo Tools(DAO) and Storage buckets(Lists)----------------
    public ProductDAO mProductDAO;

    public ActivityDAO mActivityDAO;
    public List<Product> mProducts;


    //-------------------------Card Member Variables----------------------------------------
    public int mProductCount;
    public int mNoStockCount;
    public int mLowStockCount;
    public int mUnitStockCount;
    //--------------------------Recyclerview Member Variable-----------------------------------
    public List<Activity> mallActivities;

    //--------------------------Implementing Thread-Pool-----------------------------------

    public static int THREAD_POOL_SIZE = 5;

    ExecutorService databaseExecutor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    //---------------------------Constructor---------------------------

    public Repository(Application application) {
        DatabaseInitializer dbInstance = DatabaseInitializer.getInstance(application);
        mProductDAO = dbInstance.productDAO();
        mActivityDAO = dbInstance.activityDAO();
    }


    //---------------------------Product: Getter/Setters---------------------------

    public void insert(Product product){
        databaseExecutor.execute(()->{
            mProductDAO.insert(product);

            long timestamp = System.currentTimeMillis();
            Activity log = new Activity(0, ActivityType.ADD,product.getName(),100);
            mActivityDAO.insert(log);
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

    public int getProductCount(){
        databaseExecutor.execute(()->{
            mProductCount = mProductDAO.getProductCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        return mProductCount;
    }

    public int getNoStockCount(){
        databaseExecutor.execute(()->{
            mNoStockCount = mProductDAO.getNoStockCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        return mNoStockCount;
    }

    public int getmLowStockCount(){
        databaseExecutor.execute(()->{
            mLowStockCount = mProductDAO.getLowStockCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        return mLowStockCount;
    }

    public int getmUnitStockCount(){
        databaseExecutor.execute(()->{
            mUnitStockCount = mProductDAO.getUnitStockCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        return mUnitStockCount;
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

    //---------------------------Activity: Getter/Setters---------------------------

    public void insert(Activity activity){
        databaseExecutor.execute(()->{
            mActivityDAO.insert(activity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Activity> getMallActivities(){
        databaseExecutor.execute(()->{
            mallActivities = mActivityDAO.getAllActivities();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mallActivities;
    }

    public void update(Activity activity){
        databaseExecutor.execute(()->{
            mActivityDAO.update(activity);
        });
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Activity activity){
        databaseExecutor.execute(()->{
            mActivityDAO.delete(activity);
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}

