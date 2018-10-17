package com.example.a503_25.a1017andthread;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class HandlerDialog extends AppCompatActivity {

    //진행율을 표시하기 위한 대화상자
    ProgressDialog progressDialog;
    //값을 나타낼 변수
    int value;


    public void download(){
        try{
            Thread.sleep(1000);
            Toast.makeText(HandlerDialog.this,"다운로드 완료",Toast.LENGTH_SHORT).show();
        }catch (Exception e){}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_dialog);

        Button download = (Button)findViewById(R.id.download);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(HandlerDialog.this).setTitle("다운로드").setMessage("다운로드 하시겠습니다.").setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        value = 0;
                        progressDialog = new ProgressDialog(HandlerDialog.this);
                        progressDialog.setMax(13);
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progressDialog.setTitle("다운로드");
                        progressDialog.setMessage("기다리시오>>>>>>>>>>");
                        //뒤로 버튼을 대화상자를 닫을 수 없도록 설정
                        progressDialog.setCancelable(false);
                        progressDialog.show();



                        //직접 메소드를 구현하는게 아니고 핸들러로 구현
                        handler.sendEmptyMessage(0);
                    }
                }).setNegativeButton("아니오",null).show();
            }
        };



        download.setOnClickListener(listener);
    }
    Handler handler = new Handler(){
      public void handleMessage(Message message){

          value = value + 1;
          try{
              Thread.sleep(1000);
              if(value < 13){
                  progressDialog.setProgress(value);
                  handler.sendEmptyMessage(0);
              }else {
                  //대화상자가 화면에 안보이게 하기
                  progressDialog.dismiss();
              }
          }catch (Exception e){}
          // int a = message.what;
         // download();
         // Toast.makeText(HandlerDialog.this,a+"",Toast.LENGTH_LONG).show();


      }
    };
}
