package com.example.lian4demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.xts.greendaodemo.db.BeanDao;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private int mPosition;
    private XRecyclerView mXrlv;
    private MyAdapter myAdapter;
    private Bean bean;
    private List<Bean> list = new ArrayList<>();
    private String url = "/storage/emulated/legacy/png.jpg";
    private BeanDao beanDao;
    private List<Bean> list1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        beanDao = BaseApp.getInstance().getDaoSession().getBeanDao();
        initView();
initData();
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            bean = new Bean();
            bean.setImg(url);
            bean.setUrl("马畔畔" + i);
            bean.setTitle("小实训" + i);
            beanDao.insertOrReplace(bean);
        }
        list1 = beanDao.queryBuilder().list();
        myAdapter.setAll(list1);
    }

    private void initView() {
        mXrlv = (XRecyclerView) findViewById(R.id.xrlv);
        mXrlv.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(list, this);
        mXrlv.setAdapter(myAdapter);
        myAdapter.setList(new MyAdapter.setOnClickListener() {
            @Override
            public void setClickListener(Bean bean, int porition) {
                mPosition = porition;
//                beanDao.delete(bean);
//                list1.remove(porition);
//                myAdapter.setAll(list1);
                pop();
            }
        });

    }

    private void pop() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("请选择操作按钮");
        builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("修改", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("img", list.get(mPosition).getImg());
                intent.putExtra("url", list.get(mPosition).getUrl());
                intent.putExtra("url1", list.get(mPosition).getTitle());
                startActivityForResult(intent, 1);
            }
        });


        builder.setCancelable(false).create();
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            String img = data.getStringExtra("img");
            String url = data.getStringExtra("url");
            String url1 = data.getStringExtra("url1");
            Bean bean = new Bean();
            bean.setImg(img);
            bean.setUrl(url);
            bean.setTitle(url1);
        }
    }
}
