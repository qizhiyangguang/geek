package com.example.qizhongb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qizhongb.R;
import com.example.qizhongb.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class CollectAdapter extends RecyclerView.Adapter {
    public ArrayList<Bean.DataBean.DatasBean> list;
    private Context context;

    public CollectAdapter(ArrayList<Bean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item3, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getEnvelopePic()).into(viewHolder.iv);
        viewHolder.tv.setText(list.get(position).getTitle());
        viewHolder.tv1.setText(list.get(position).getChapterName());
        viewHolder.tv2.setText(list.get(position).getDesc());
        Glide.with(context).load(list.get(position).getEnvelopePic()).into(viewHolder.iv1);
        viewHolder.tv3.setText(list.get(position).getNiceDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setAll(List<Bean.DataBean.DatasBean> datas) {
        list.addAll(datas);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv;
        public TextView tv;
        public TextView tv1;
        public TextView tv2;
        public ImageView iv1;
        public TextView tv3;
        public ImageView iv2;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.tv1 = (TextView) rootView.findViewById(R.id.tv1);
            this.tv2 = (TextView) rootView.findViewById(R.id.tv2);
            this.iv1 = (ImageView) rootView.findViewById(R.id.iv1);
            this.tv3 = (TextView) rootView.findViewById(R.id.tv3);
            this.iv2 = (ImageView) rootView.findViewById(R.id.iv2);
        }

    }
}
