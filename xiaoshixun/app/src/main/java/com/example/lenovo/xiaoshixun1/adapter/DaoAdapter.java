package com.example.lenovo.xiaoshixun1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiaoshixun1.R;
import com.example.lenovo.xiaoshixun1.bean.DaoBean;

import java.util.ArrayList;
import java.util.List;

public class DaoAdapter extends RecyclerView.Adapter {
    public List<DaoBean> list ;
    private Context context;

    public DaoAdapter(List<DaoBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private setOnClickListener sc;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item1, null);
       ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
     final DaoBean  daoBean = list.get(position);
   Glide.with(context).load(list.get(position).getImg()).into(viewHolder.iv);
   viewHolder.tv1.setText(daoBean.getUrl());
   viewHolder.tv2.setText(daoBean.getTitle());
   holder.itemView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           sc.setClickListener(daoBean,position);
       }
   });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv;
        public TextView tv1;
        public TextView tv2;


        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv1 = (TextView) rootView.findViewById(R.id.tv1);
            this.tv2 = (TextView) rootView.findViewById(R.id.tv2);

        }

    }


    public interface setOnClickListener {
        void setClickListener(DaoBean bean, int porition);
    }

    public void setList(setOnClickListener sc) {
        this.sc = sc;
    }
}
