package com.example.lenovo.xiaoshixun1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lenovo.xiaoshixun1.View.MyView;
import com.example.lenovo.xiaoshixun1.adapter.MyAdapter;
import com.example.lenovo.xiaoshixun1.bean.Bean;
import com.example.lenovo.xiaoshixun1.bean.DaoBean;
import com.example.lenovo.xiaoshixun1.model.MyModels;
import com.example.lenovo.xiaoshixun1.presenter.MyPresenters;
import com.example.xts.greendaodemo.db.DaoBeanDao;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, MyView {

    private XRecyclerView mXrlv;
    /**
     * 列表
     */
    private Button mBt1;
    /**
     * 收藏
     */
    private Button mBt2;
    private MyPresenters myPresenters;
    private int page = 1;
    private MyAdapter myAdapter;
    private int mPosition;
    private ArrayList<Bean.ResultsBean> beans = new ArrayList<>();
    private DaoBeanDao daoBeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        daoBeanDao = BaseApp.getInstance().getDaoSession().getDaoBeanDao();
        myPresenters = new MyPresenters(new MyModels(), this);
        initData();
        initView();
    }

    private void initData() {
        myPresenters.getData(page);
    }

    private void initView() {
        mXrlv = (XRecyclerView) findViewById(R.id.xrlv);
        mBt1 = (Button) findViewById(R.id.bt1);
        mBt1.setOnClickListener(this);
        mBt2 = (Button) findViewById(R.id.bt2);
        mBt2.setOnClickListener(this);
        mXrlv.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(beans, this);
        mXrlv.setAdapter(myAdapter);
        mXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                myAdapter.list.clear();
                initData();
            }

            @Override
            public void onLoadMore() {
                page++;
                initData();
            }
        });
        myAdapter.setList(new MyAdapter.setOnClickListener() {
            @Override
            public void setClickListener(View v, int porition) {
                mPosition = porition;
                registerForContextMenu(mXrlv);
            }
        });
        final View inflate = LayoutInflater.from(this).inflate(R.layout.item, null);
        RadioGroup viewById = inflate.findViewById(R.id.cb);
        viewById.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                Intent intent = new Intent(Main2Activity.this, Main5Activity.class);
//                startActivity(intent);
                Toast.makeText(Main2Activity.this, "李元大傻子", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt1:
                Intent intent = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.bt2:
                Intent intent1 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onSuccess(Bean bean) {
        mXrlv.refreshComplete();
        mXrlv.loadMoreComplete();
        myAdapter.setAll(bean.getResults());
    }

    @Override
    public void onFail(String stirng) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(1, 1, 1, "收藏");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                DaoBean daoBean = new DaoBean();
                daoBean.setImg(beans.get(mPosition).getUrl());
                daoBean.setUrl(beans.get(mPosition).get_id());
                daoBean.setTitle(beans.get(mPosition).getCreatedAt());
                daoBeanDao.insertOrReplace(daoBean);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
