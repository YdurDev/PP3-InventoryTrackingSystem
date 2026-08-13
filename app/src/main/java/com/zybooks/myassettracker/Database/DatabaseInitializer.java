package com.zybooks.myassettracker.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.zybooks.myassettracker.DAO.ActivityDAO;
import com.zybooks.myassettracker.DAO.ProductDAO;
import com.zybooks.myassettracker.Entities.Product;
import com.zybooks.myassettracker.Entities.Activity;

@Database(entities = {Product.class,Activity.class},version = 1,exportSchema = false)
public abstract class DatabaseInitializer extends RoomDatabase {
    public abstract ProductDAO productDAO();
    public abstract ActivityDAO activityDAO();

    private static volatile DatabaseInitializer INSTANCE;

    static DatabaseInitializer getInstance(Context context){
        //Check to see if DB exists already, if so do not create another,
        // if it doesn't exist, create one safely by synchronizing(locking/monitoring) so only one obj can access it at a time.
        if (INSTANCE==null) {
            synchronized (DatabaseInitializer.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseInitializer.class, "Database.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
