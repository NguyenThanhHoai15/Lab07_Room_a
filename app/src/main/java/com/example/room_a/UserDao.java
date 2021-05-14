package com.example.room_a;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE id_ IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE user_Name LIKE :name LIMIT 1")
    User findByName(String name);

    @Insert
    void insertUser(User user);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
