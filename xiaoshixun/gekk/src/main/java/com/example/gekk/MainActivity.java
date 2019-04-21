package com.example.gekk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gekk.base.BaseActivity;
import com.example.gekk.presenter.MainP;
import com.example.gekk.utils.ToastUtil;
import com.example.gekk.view.MainView;

import butterknife.BindView;
import butterknife.OnClick;

//马畔畔-1808D-19：30
public class MainActivity extends BaseActivity<MainView,MainP> implements MainView {



    @BindView(R.id.et1)
    EditText mEt1;
    @BindView(R.id.et2)
    EditText mEt2;
    @BindView(R.id.bt)
    Button mBt;
protected MainP initPresenter(){
    return new MainP();
}
protected int getLayoutId(){
    return R.layout.activity_main;
}
@OnClick({R.id.bt})
public void click(View view){
    //每次转换类型,麻烦
    //((MainP)mPresenter).getData();
    //mPresenter.getData();
    mPresenter.login();
}
    @Override
    public void setData(String data) {
        mBt.setText(data);
    }

    @Override
    public String getUserName() {
        return mEt1.getText().toString().trim();
    }

    @Override
    public String getPsd() {
        return mEt2.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showLong(msg);
    }
}
