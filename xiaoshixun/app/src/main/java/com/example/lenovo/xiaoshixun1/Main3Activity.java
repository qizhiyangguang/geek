package com.example.lenovo.xiaoshixun1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;

import com.example.Main4Activity;
import com.example.lenovo.xiaoshixun1.adapter.DaoAdapter;
import com.example.lenovo.xiaoshixun1.bean.DaoBean;
import com.example.xts.greendaodemo.db.DaoBeanDao;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private XRecyclerView mXrlv;
    private DaoBeanDao daoBeanDao;
    private List<DaoBean> list = new ArrayList<>();
    private DaoAdapter daoAdapter;
    /**
     * 列表
     */
    private Button mBt1;
    /**
     * 收藏
     */
    private Button mBt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        daoBeanDao = BaseApp.getInstance().getDaoSession().getDaoBeanDao();
        initView();
    }

    private void initView() {
        list = daoBeanDao.queryBuilder().list();
        mXrlv = (XRecyclerView) findViewById(R.id.xrlv);
        mXrlv.setLayoutManager(new LinearLayoutManager(this));
        daoAdapter = new DaoAdapter(list, this);
        mXrlv.setAdapter(daoAdapter);
        daoAdapter.setList(new DaoAdapter.setOnClickListener() {
            @Override
            public void setClickListener(DaoBean bean, int porition) {
                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("u", list.get(porition).getImg());
                intent.putExtra("r", list.get(porition).getUrl());
                intent.putExtra("l", list.get(porition).getTitle());
                startActivity(intent);
            }
        });
        mBt1 = (Button) findViewById(R.id.bt1);
        mBt1.setOnClickListener(this);
        mBt2 = (Button) findViewById(R.id.bt2);
        mBt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt1:
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.bt2:
                Intent intent1 = new Intent(Main3Activity.this, Main3Activity.class);
                startActivity(intent1);
                break;
        }
    }
}
