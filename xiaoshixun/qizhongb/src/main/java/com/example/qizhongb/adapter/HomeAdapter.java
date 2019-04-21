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

public class HomeAdapter extends RecyclerView.Adapter {
    public ArrayList<Bean.DataBean.DatasBean> list;
    private Context context;

    public HomeAdapter(ArrayList<Bean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item1, null);
            ViewHolder1 viewHolder1 = new ViewHolder1(inflate);
            return viewHolder1;
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item2, null);
            ViewHolder2 viewHolder2 = new ViewHolder2(inflate);
            return viewHolder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            Glide.with(context).load(list.get(position).getEnvelopePic()).into(viewHolder1.iv);
            viewHolder1.tv.setText(list.get(position).getChapterName());
            viewHolder1.tv1.setText(list.get(position).getDesc());
            viewHolder1.tv2.setText(list.get(position).getNiceDate());
        } else {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            Glide.with(context).load(list.get(position).getEnvelopePic()).into(viewHolder2.iv);
            viewHolder2.tv.setText(list.get(position).getAuthor());
            viewHolder2.tv1.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getEnvelopePic()).into(viewHolder2.iv1);
            viewHolder2.tv2.setText(list.get(position).getNiceDate());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public void setAll(List<Bean.DataBean.DatasBean> datas) {
        list.addAll(datas);
        notifyDataSetChanged();
    }

    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv;
        public TextView tv;
        public TextView tv1;
        public TextView tv2;
        public ImageView iv1;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.tv1 = (TextView) rootView.findViewById(R.id.tv1);
            this.tv2 = (TextView) rootView.findViewById(R.id.tv2);
            this.iv1 = (ImageView) rootView.findViewById(R.id.iv1);
        }

    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv;
        public TextView tv;
        public TextView tv1;
        public ImageView iv1;
        public TextView tv2;
        public ImageView iv2;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.tv1 = (TextView) rootView.findViewById(R.id.tv1);
            this.iv1 = (ImageView) rootView.findViewById(R.id.iv1);
            this.tv2 = (TextView) rootView.findViewById(R.id.tv2);
            this.iv2 = (ImageView) rootView.findViewById(R.id.iv2);
        }

    }
}
