/**
 * CoordinatorLayout需结合AppBarLayout或CollapsingToolbarLayout使用才能表现出其效果。
 * 在使用时，一定需要设置
 * app:layout_scrollFlags="scroll|enterAlways"  设置给AppBarLayout或CollapsingToolbarLayout中需要执行相关操作的View
 * app:layout_behavior="@string/appbar_scrolling_view_behavior"   提供给滑动的View，如RecyclerView或NestedScrollView
 * 2个属性
 */

package com.welthy.materialdesigndemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_layout);

        initDatas();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyAdapter());
    }

    private void initDatas(){
        datas = new ArrayList<>();
        for (int i = 0; i<30; i++){
            datas.add(i+"");
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(CoordinatorActivity.this).inflate(R.layout.recycler_item_layout,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.tv.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.recycler_item_tv);
        }
    }
}
