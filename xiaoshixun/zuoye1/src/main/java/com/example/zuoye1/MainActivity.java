package com.example.zuoye1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

//马畔畔-1808B-2019.4.1-14.19
public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private Toolbar mToolBar;
    private XRecyclerView mXrlv;
    private ArrayList<Bean.ResultsBean> lis = new ArrayList<>();
    private MyAdapter myAdapter;
    private NotificationManager mManager;
    private DrawerLayout mDl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mDl = (DrawerLayout) findViewById(R.id.dl);
        mTv = (TextView) findViewById(R.id.tv);
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mXrlv = (XRecyclerView) findViewById(R.id.xrlv);
        mToolBar.setTitle("福利");
        setSupportActionBar(mToolBar);
        mXrlv.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(lis, this);
        mXrlv.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "发送通知");
        menu.add(1, 2, 1, "取消通知");
        menu.add(1, 3, 1, "popupWindow");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                //发送通知4步
                //1.获取通知管理器
                mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //2.适配Android 8.0
                String channelId = "shui";
                String chanelName = "李四";

                //通知消息渠道/管道
                //android.os.Build.VERSION.SDK_INT 获取当前手机的系统api版本
                //android.os.Build.VERSION_CODES.O 26的api,也就是Android 8.0
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(channelId, chanelName, NotificationManager.IMPORTANCE_DEFAULT);
                    mManager.createNotificationChannel(channel);
                }

                //3.构建Notification对象
                //获取一个含有开启页面的延时意图
                Intent intent = new Intent(this, Main2Activity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,
                        1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                //获取一个广播的延时意图
                //PendingIntent.getBroadcast()
                //获取一个开启服务的意图
                //PendingIntent.getService()
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                Notification build = new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)//小图标,必要
                        .setContentTitle("标题")//标题,必要
                        .setContentText("白菜打折了,99折")//内容,必要
                        .setContentIntent(pendingIntent)//设置延时意图
                        .setAutoCancel(true)//点击通知消失,必须和延时意图配合使用
                        .setDefaults(Notification.DEFAULT_ALL)//通知的效果
                        .setLargeIcon(bitmap)//设置大图标
                        .build();

                //4.发送通知
                mManager.notify(100, build);
                break;
            case 2:
                //代码取消一个发送过的通知
                mManager.cancel(100);
                //取消所有通知
                //mManager.cancelAll();
                break;
            case 3:
                pop();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void pop() {
        //1.创建PoP（必须包含：显示View、宽、高）
        final PopupWindow popupWindow = new PopupWindow(this);
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
        popupWindow.setContentView(inflate);//显示的View控件
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);//显示宽度
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);//显示高度
        popupWindow.setFocusable(true);//是否可以获取焦点

        PopupWindow popupWindow2 = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);

        //5.点击外部可以消失
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);

        //6.设置进出动画
        popupWindow.setAnimationStyle(R.style.popWindow);

        //2.显示
        //popupWindow.showAsDropDown(bB);//显示到相对某个控件的正下方
        //popupWindow.showAsDropDown(bB,-100,-200);//显示到某个控件正下方，同时与X/Y的偏移值
        popupWindow.showAtLocation(mDl, Gravity.NO_GRAVITY | Gravity.BOTTOM, 0, 0);//相对父窗体的对齐方式
        //3.pop事件处理
        Button bt1 = inflate.findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {//按钮事件监听处理
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "弹出", Toast.LENGTH_SHORT).show();
            }
        });
        inflate.findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {//点击阴影关闭pop
            @Override
            public void onClick(View v) {
                //4.关闭Pop
                popupWindow.dismiss();
            }
        });
    }
}

