package com.example.a503_25.a1017andthread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.txt);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

        View.OnClickListener handler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   int i = 0;
                while (i < 10) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("예외발생 :", e.getMessage());
                    }
                    //UI 갱신을 하지 않는 코드이므로 작업을 수행합니다.
                    Log.e("돌리고있는중",i +"");
                    i = i + 1;
                    //UI 갱신을 하는 코드이므로 모아서처리합니다.
                    textView.setText(String.format("value = %d", i));
                }
                i = 0;
                while (i < 10) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("예외발생 :", e.getMessage());
                    }
                    //UI 갱신을 하지 않는 코드이므로 작업을 수행합니다.
                    Log.e("태그","안녕하세요");

                }*/
//밑에는 그냥스레드
               /* new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int i = 0;
                        while (i < 10) {
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            i = i + 1;
                            Log.e("value : ",i+"");
                    }
                    }}).start();
                new Thread() {
                    public void run() {
                        int i = 0;
                        while (i < 10) {
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            i = i + 1;
                            Log.e("value : ","안녕하세요");
                        }
                    }
                }.start();*/
/* 상호배제 밑에
               class T implements Runnable{
                   String name;
                   //위에에 두면 초기값을 안주어도 된다.
                   int i;
                   public T(String name){
                       this.name = name;
                   }
                   public void run(){
                       for(int j = 0 ; j<5; j=j+1){
                           try{
                           //안에서잇을 때는 자기이름은 this
                               //괄호 안에 영역은 중간에 쉬는 시간이 발생하더라도
                               // 무조건 한 번에 수행합니다.
                               synchronized (this) {
                                   Log.e(name + "변경하기 전", i + "");
                                   i = i + 1;
                                   Thread.sleep(1000);
                                   Log.e(name + "변경한 후", i + "");
                               }
                           }catch (Exception e){
                               e.printStackTrace();
                           }
                       }
                   }
               }
            T obj = new T("상호배제");
               Thread th = new Thread(obj);
               th.start();
               Thread th2 = new Thread(obj);
               th2.start();
            }*/
            class T extends Thread{
                public void run(){
                    int i=0;
                    while (i<10) {
                        try {
                            Thread.sleep(1000);
                            textView.setText(i + "");
                        } catch (Exception e) {

                        }
                        i=i+1;
                    }
                }
            }
            T th = new T();
            th.start();
            }
        };
        btn1.setOnClickListener(handler);
    }
}
