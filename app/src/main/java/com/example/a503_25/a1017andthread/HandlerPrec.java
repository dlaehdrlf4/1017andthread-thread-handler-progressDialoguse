package com.example.a503_25.a1017andthread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HandlerPrec extends AppCompatActivity {

    TextView textView;
    //화면을 주기적으로 갱신 하려고 만든 것이다 handler
    Handler handler = new Handler(){
        int i = 0;
        //밑에를 붙이면 에러나면 밑에 머가 뜬다.
        @Override
        public void handleMessage(Message message){
            textView.setText(i+"");
            i = i + 1;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_prec);
        textView = (TextView) findViewById(R.id.textView);

        /*//이렇게 작업을 하면 다운로드라고 생각하면 끝날때까지 아무것도 못한다.
        for(int i =0;i<10;i=i+1){
            try{
                Thread.sleep(1000);
                textView.setText(i+"");
            }catch (Exception e){
                e.getMessage();
            }
        }
        textView.setText("끝");*/
        new Thread() {
            public void run() {
                for (int i = 0; i < 10; i = i + 1)
                {
                    try {
                        Thread.sleep(1000);
                        handler.sendEmptyMessage(1);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
        }.start();
    }
}
