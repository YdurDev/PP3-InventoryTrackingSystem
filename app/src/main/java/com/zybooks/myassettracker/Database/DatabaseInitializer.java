package com.zybooks.myassettracker.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.zybooks.myassettracker.DAO.ProductDAO;
import com.zybooks.myassettracker.Entities.Product;

@Database(entities = Product.class,version = 3,exportSchema = false)
public abstract class DatabaseInitializer extends RoomDatabase {
    public abstract ProductDAO productDAO();

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
