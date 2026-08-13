package com.zybooks.myassettracker.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.zybooks.myassettracker.Entities.Activity;

import java.util.List;

@Dao
public interface ActivityDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Activity activity);

    @Query("SELECT * FROM activities")
    List<Activity> getAllActivities();

    @Update
    void update(Activity activity);

    @Delete
    void delete(Activity activity);

}
