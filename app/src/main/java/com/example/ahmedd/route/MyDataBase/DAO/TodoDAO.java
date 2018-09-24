package com.example.ahmedd.route.MyDataBase.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ahmedd.route.MyDataBase.Model.Todo;

import java.util.List;

@Dao
public interface TodoDAO {

    @Query("SELECT * FROM Todo")
    public List<Todo> getAllTodo();



}
