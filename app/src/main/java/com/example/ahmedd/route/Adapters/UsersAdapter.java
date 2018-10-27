/*
package com.example.ahmedd.route.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmedd.route.MyDataBase.Model.Todo;
import com.example.ahmedd.route.R;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    List<Todo> todoList;
    onItemClickListener onCardClickListener;
    public static Todo todoItem;

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public UsersAdapter(List<Todo> todoList) {

        this.todoList = todoList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        TextView userGender;
        TextView userPhoneNumber;
        CardView cardView ;


        public ViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
            userGender = itemView.findViewById(R.id.user_gender);
            userPhoneNumber = itemView.findViewById(R.id.user_phoneNumber);
            cardView = itemView.findViewById(R.id.cardView_user);
        }
    }

    public void setOnCardClickListener(onItemClickListener onCardClickListener){
        this.onCardClickListener = onCardClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_user, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final  Todo todo = todoList.get(position);
        todoItem = todoList.get(position);

        holder.userName.setText(todo.getName());
        holder.userGender.setText(todo.getGender());
        holder.userPhoneNumber.setText(todo.getPhoneNumber());

        if (onCardClickListener != null){
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCardClickListener.onClick(position,todo);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public interface onItemClickListener{

        void onClick(int position , Todo todo);
    }

}

*/
