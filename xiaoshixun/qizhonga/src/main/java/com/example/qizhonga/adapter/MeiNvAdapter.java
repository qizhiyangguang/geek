package com.example.qizhonga.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.qizhonga.R;
import com.example.qizhonga.bean.MeiNvBean;

import java.util.ArrayList;
import java.util.List;

public class MeiNvAdapter extends RecyclerView.Adapter {
    public ArrayList<MeiNvBean.ResultsBean> list;
    private Context context;

    public MeiNvAdapter(ArrayList<MeiNvBean.ResultsBean> list, Context context) {
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv1.setText(list.get(position).getCreatedAt());
        viewHolder.tv2.setText(list.get(position).getDesc());
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(context).load(list.get(position).getUrl()).apply(requestOptions).into(viewHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setAll(List<MeiNvBean.ResultsBean> results) {
        list.addAll(results);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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
}
