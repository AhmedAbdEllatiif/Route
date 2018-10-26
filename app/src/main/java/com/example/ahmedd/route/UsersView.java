package com.example.ahmedd.route;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.example.ahmedd.route.Adapters.UsersAdapter;
import com.example.ahmedd.route.MyDataBase.Model.Todo;
import com.example.ahmedd.route.MyDataBase.TodoDataBase;

import java.util.ArrayList;
import java.util.List;

public class UsersView extends AppCompatActivity {

    UsersAdapter adapter;
    List<Todo> items;
    RecyclerView recyclerViewAllUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_view);

        items = new ArrayList<>();

        recyclerViewAllUsers = (RecyclerView) findViewById(R.id.RecyclerView_allUsers);
        recyclerViewAllUsers.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new UsersAdapter(items);
        recyclerViewAllUsers.setAdapter(adapter);
        adapter.setOnCardClickListener(new UsersAdapter.onItemClickListener() {
            @Override
            public void onClick(int position, Todo todo) {

                Survey.next.setVisibility(View.GONE);
                Survey.btnUpdate.setVisibility(View.VISIBLE);

                Intent intent = new Intent(UsersView.this,Survey.class);
                startActivity(intent);
                finish();
            }
        });

        //to make the item swap
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {


                TodoDataBase.getInstance(getApplicationContext()).todoDAO().removeItem(UsersAdapter.todoItem);

            }
        }).attachToRecyclerView(recyclerViewAllUsers);


    }

    @Override
    public void onResume() {
        super.onResume();
        items = TodoDataBase.getInstance(getApplicationContext())
                .todoDAO().getAllTodo();

        adapter.setTodoList(items);
    }
}
