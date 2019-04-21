package com.example.qizhonga.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.qizhonga.Main2Activity;
import com.example.qizhonga.R;
import com.example.qizhonga.bean.BBean;

import java.util.ArrayList;
import java.util.List;

public class BAdapter extends RecyclerView.Adapter {
    public ArrayList<BBean.DataBean.DatasBean> list;
    private Context context;

    public BAdapter(ArrayList<BBean.DataBean.DatasBean> list, Context context) {
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
        viewHolder.tv1.setText(list.get(position).getNiceDate());
        viewHolder.tv2.setText(list.get(position).getDesc());
//加载一张原型图片
//        RequestOptions requestOptions = RequestOptions.centerCropTransform()
//                .placeholder(R.mipmap.ic_launcher)
//                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//                .skipMemoryCache(true);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(context).load(list.get(position).getEnvelopePic()).apply(requestOptions).into(viewHolder.iv);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("title1", list.get(position).getNiceDate());
                intent.putExtra("title2", list.get(position).getDesc());
                intent.putExtra("url",list.get(position).getEnvelopePic());
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setAll(List<BBean.DataBean.DatasBean> datas) {
        list.addAll(datas);
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
