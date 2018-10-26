package com.example.ahmedd.route.MyDataBase.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ahmedd.route.Adapters.UsersAdapter;
import com.example.ahmedd.route.MyDataBase.Model.Todo;

import java.util.List;

@Dao
public interface TodoDAO {

    @Query("SELECT * FROM Todo")
    public List<Todo> getAllTodo();

    @Insert
    public void addItemTodo(Todo todo);

    @Update
    public void updateItem(Todo todo);

    @Delete
    public void removeItem(Todo todo);


}
