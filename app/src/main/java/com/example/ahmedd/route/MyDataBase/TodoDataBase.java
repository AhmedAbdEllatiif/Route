package com.example.ahmedd.route.MyDataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.ahmedd.route.MyDataBase.DAO.TodoDAO;
import com.example.ahmedd.route.MyDataBase.Model.Todo;

@Database(entities = {Todo.class},version = 1,exportSchema = false)
public abstract class TodoDataBase extends RoomDatabase {


    private static TodoDataBase myDataBase;

    public abstract TodoDAO todoDAO();

    public static TodoDataBase getInstance(Context context){

        if (myDataBase == null) {
            //initailize myDataBase
          myDataBase = Room.databaseBuilder(context.getApplicationContext(), TodoDataBase.class, "todo-database")
                    // allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .build();
        }

            return myDataBase;
    }
}
