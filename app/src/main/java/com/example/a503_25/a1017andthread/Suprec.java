package com.example.a503_25.a1017andthread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Suprec extends AppCompatActivity {

    Handler handler = new Handler(){
      public void handleMessage(Message message){
          String str = (String)message.obj;

          Toast.makeText(Suprec.this,str,Toast.LENGTH_LONG).show();
      }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suprec);

        class ThreadEx extends Thread{
            String url;
            public ThreadEx(String url){
                this.url = url;
            }
            public  void run(){
                Message message = new Message();
                message.obj = url;
                handler.sendMessage(message);
            }

        }
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreadEx th1 = new ThreadEx("영화정보");
                ThreadEx th2 = new ThreadEx("극장정보");
                th1.start();
                th2.start();
            }
        });

    }
}
