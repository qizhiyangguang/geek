package com.example.lenovo.xiaoshixun1.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiaoshixun1.R;
import com.example.lenovo.xiaoshixun1.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    public ArrayList<Bean.ResultsBean> list;
    private Context context;
    public setOnClickListener sc;

    public MyAdapter(ArrayList<Bean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getUrl()).into(viewHolder.iv);
        viewHolder.tv1.setText(list.get(position).get_id());
        viewHolder.tv2.setText(list.get(position).getCreatedAt());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                sc.setClickListener(v, position);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setAll(List<Bean.ResultsBean> results) {
        list.addAll(results);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv;
        public TextView tv1;
        public TextView tv2;
        public LinearLayout ll;
        public RadioGroup cb;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv1 = (TextView) rootView.findViewById(R.id.tv1);
            this.tv2 = (TextView) rootView.findViewById(R.id.tv2);
            this.ll = (LinearLayout) rootView.findViewById(R.id.ll);
            this.cb = (RadioGroup) rootView.findViewById(R.id.cb);
//            cb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                }
//            });
        }

    }

    public interface setOnClickListener {
        void setClickListener(View v, int porition);
    }

    public void setList(setOnClickListener sc) {
        this.sc = sc;
    }
}
