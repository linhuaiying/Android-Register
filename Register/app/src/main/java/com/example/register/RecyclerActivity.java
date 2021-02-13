package com.example.register;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerActivity extends AppCompatActivity {
    private String[] names={"第1章 Android基础入门","第2章 Android常见界面布局","第3章 Android常见界面布局","第4章 程序活动单元Activity"
    ,"第5章 数据存储","第6章 内容提供者","第7章 广播机制","第8章 服务","第9章 网络编程","第10章 综合项目"};
private int[] icons={R.drawable.exercises_bg_1,R.drawable.exercises_bg_2,R.drawable.exercises_bg_3,R.drawable.exercises_bg_4,
        R.drawable.exercises_bg_1,R.drawable.exercises_bg_2,R.drawable.exercises_bg_3,R.drawable.exercises_bg_4,
        R.drawable.exercises_bg_1,R.drawable.exercises_bg_2};
private  String[] introduces={"共计5题","共计5题","共计5题","共计5题","共计5题","共计5题","共计5题","共计5题","共计5题","共计5题"};
private  String[] numbers={"1","2","3","4","5","6","7","8","9","10"};
    RecyclerView mRecyclerView;
    HomeAdapter mAdapter;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);
         mRecyclerView = findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HomeAdapter();
        mRecyclerView.setAdapter(mAdapter);
        setTitle("                      移动开发设计习题");

    }
    public void myClick(View view)
    {
        int position = mRecyclerView.getChildAdapterPosition(view);
       Toast.makeText(RecyclerActivity.this,names[position],Toast.LENGTH_LONG).show();
    }
class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(RecyclerActivity.this).inflate(R.layout.recyler_item, parent, false));
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(names[position]);
        holder.iv.setImageResource(icons[position]);
        holder.indroduce.setText(introduces[position]);
        holder.number.setText(numbers[position]);
    }

    public int getItemCount() {
        return names.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView iv;
        TextView indroduce;
       TextView number;
        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            iv =  view.findViewById(R.id.iv);
            indroduce = view.findViewById(R.id.introduce);
            number=view.findViewById(R.id.number);

        }
    }
}

}
