package com.example.a503_25.a1017andthread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThreadHandlerQueue extends AppCompatActivity {

    //핸들러 생성
    Handler handler = new Handler(){
      @Override
      public void handleMessage(Message msg){
          String str = (String)msg.obj;
          Toast.makeText(ThreadHandlerQueue.this,str,Toast.LENGTH_SHORT).show();
      }
    };
   /*     //스레드 생성 // anonyclass로 생성 스레드
    Thread th1 = new Thread(){
        @Override
        public void run(){
            try{
                Thread.sleep(1000);
                handler.sendEmptyMessage(0);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_handler_queue);

        //클래스를 만들어서 쓰는것은 하나가지고 여러가지 일을 할 수 있다.
        class ThreadEx extends Thread{
            String url;
            public ThreadEx(String url){
                this.url = url;
            }
            public void run(){
                try{
                    //핸들러에게 데이터를 전달하면서 호출
                    Message message = new Message();
                    message.obj = url;
                   // handler.sendMessage(message);
                    // 밑에는 딜레이를 줘서 10초 있다가 나오게
                    handler.sendMessageDelayed(message,10000);
                }catch (Exception e){}
            }
        }


        // 버튼을 눌렀을 때 스레드 시작
        Button button = (Button)findViewById(R.id.btn);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ThreadEx th1 = new ThreadEx("영화정보");
                    ThreadEx th2 = new ThreadEx("극장정보");
                    th1.start();
                    th2.start();
                    // 여기 안에다 만들면 여러번 만들어서 앱이 죽지 않고 밖에서 만들면 한번 누르고 나면 앱이 죽는다.
                    //스레드 생성 // anonyclass로 생성 스레드
                /*Thread th1 = new Thread(){
                    @Override
                    public void run(){
                        try{
                            Thread.sleep(1000);
                            handler.sendEmptyMessage(0);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                th1.start();*/
                }
        };
        button.setOnClickListener(listener);
    }
}
