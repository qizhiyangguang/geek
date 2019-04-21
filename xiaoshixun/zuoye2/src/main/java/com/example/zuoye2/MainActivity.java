package com.example.zuoye2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.zuoye2.build.Computer;
import com.example.zuoye2.build.MacBookBuilder;
import com.example.zuoye2.factory.NbFactory;
import com.example.zuoye2.factory.TaiDiDog;
import com.example.zuoye2.factory.TuDog;
import com.example.zuoye2.obser.DuZhe;
import com.example.zuoye2.obser.LittleStudent;
import com.example.zuoye2.single.SingleTon4;

//马畔畔-1808D-19.31
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 单例
     */
    private Button mBtn;
    /**
     * 建造者
     */
    private Button mBtn2;
    /**
     * 工厂方法
     */
    private Button mBtn3;
    /**
     * 观察者模式
     */
    private Button mBtn4;
    private DuZhe duZhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        duZhe = new DuZhe();
        LittleStudent doudan = new LittleStudent("狗蛋");
        LittleStudent erya = new LittleStudent("二丫");
        LittleStudent tiezhu = new LittleStudent("铁柱");
        duZhe.addObserver(doudan);
        duZhe.addObserver(erya);
        duZhe.addObserver(tiezhu);
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
        mBtn4 = (Button) findViewById(R.id.btn4);
        mBtn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                single();
                break;
            case R.id.btn2:
                build();
                break;
            case R.id.btn3:
                factroy();
                break;
            case R.id.btn4:
                obser();
                break;
        }
    }

    private void obser() {
        duZhe.postNews("给你们点作业，省的你们浪哈哈哈");
    }

    private void factroy() {
   /*Dog dog = new TuDogFactory().createDog();
        dog.eat();
        Dog dog1 = new TaidiFactory().createDog();
        dog1.eat();*/

        //new NbFactory().createDog(狗的类型);
        //new Intent(this,)

        NbFactory nbFactory = new NbFactory();
        TuDog tu = nbFactory.createDog(TuDog.class);
        tu.eat();
        TaiDiDog dog = nbFactory.createDog(TaiDiDog.class);
        dog.eat();
    }

    private void build() {
        Computer build = new MacBookBuilder()
                .buildBoard("二手主板")
                .buildDisplay("Retina显示器")
                .buildOs()
                .build();
        Log.d("tag", "build: " + build.toString());

    }

    private void single() {
        //SingleTon instance = SingleTon.getInstance();
        //SingleTon2 instance = SingleTon2.getInstance();
        //SingleTon3 instance = SingleTon3.getInstance();
        SingleTon4 instance = SingleTon4.getInstance();
        Log.d("tag", "single: " + instance.toString());

    }
}
