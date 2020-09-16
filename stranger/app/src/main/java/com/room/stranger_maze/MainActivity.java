package com.room.stranger_maze;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView room1ImgView,room2ImgView,room3ImgView,room4ImgView,room5ImgView,room6ImgView,room7ImgView,room8ImgView;
    Button room1Btn,room2Btn,room3Btn,room4Btn,room5Btn,room6Btn,room7Btn,room8Btn;
    private SharedPreferences appData;
    boolean savedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appData = getSharedPreferences("appData",MODE_PRIVATE);

        BtnClickedListener onClickListener = new BtnClickedListener() ;

        room1Btn = findViewById(R.id.room1Btn);
        room1ImgView = findViewById(R.id.room1ImgView);
        room1Btn.setOnClickListener(onClickListener);
        room2Btn = findViewById(R.id.room2Btn);
        room2ImgView = findViewById(R.id.room2ImgView);
        room2Btn.setOnClickListener(onClickListener);
        room3Btn = findViewById(R.id.room3Btn);
        room3ImgView = findViewById(R.id.room3ImgView);
        room3Btn.setOnClickListener(onClickListener);
        room4Btn = findViewById(R.id.room4Btn);
        room4ImgView = findViewById(R.id.room4ImgView);
        room4Btn.setOnClickListener(onClickListener);
        room5Btn = findViewById(R.id.room5Btn);
        room5ImgView = findViewById(R.id.room5ImgView);
        room5Btn.setOnClickListener(onClickListener);
        room6Btn = findViewById(R.id.room6Btn);
        room6ImgView = findViewById(R.id.room6ImgView);
        room6Btn.setOnClickListener(onClickListener);
        room7Btn = findViewById(R.id.room7Btn);
        room7ImgView = findViewById(R.id.room7ImgView);
        room7Btn.setOnClickListener(onClickListener);
        room8Btn = findViewById(R.id.room8Btn);
        room8ImgView = findViewById(R.id.room8ImgView);
        room8Btn.setOnClickListener(onClickListener);

        savedData = appData.getBoolean("saved",false);
        if(savedData){
            // SharedPreferences 객체.get타입( 저장된 이름, 기본값 )
            // 저장된 이름이 존재하지 않을 시 기본값
            room1ImgView.setImageResource(appData.getInt("room1Img",R.drawable.icon_lock));
            room2Btn.setEnabled(appData.getBoolean("btn2Enable",false));
            room2ImgView.setImageResource(appData.getInt("room2Img",R.drawable.icon_lock));
            room3Btn.setEnabled(appData.getBoolean("btn3Enable",false));
            room3ImgView.setImageResource(appData.getInt("room3Img",R.drawable.icon_lock));
            room4Btn.setEnabled(appData.getBoolean("btn4Enable",false));
            room4ImgView.setImageResource(appData.getInt("room4Img",R.drawable.icon_lock));
            room5Btn.setEnabled(appData.getBoolean("btn5Enable",false));
            room5ImgView.setImageResource(appData.getInt("room5Img",R.drawable.icon_lock));
            room6Btn.setEnabled(appData.getBoolean("btn6Enable",false));
            room6ImgView.setImageResource(appData.getInt("room6Img",R.drawable.icon_lock));
            room7Btn.setEnabled(appData.getBoolean("btn7Enable",false));
            room7ImgView.setImageResource(appData.getInt("room7Img",R.drawable.icon_lock));
            room8Btn.setEnabled(appData.getBoolean("btn8Enable",false));
            room8ImgView.setImageResource(appData.getInt("room8Img",R.drawable.icon_lock));
        }
        boolean clear = appData.getBoolean("clear",false);
        if(clear){
            Toast toast = Toast.makeText(this.getApplicationContext(),"이미 모든 방을 탈출하였습니다",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MAINACTIVITY","back to main");
        SharedPreferences.Editor editor = appData.edit();
        editor.putBoolean("saved",true);
        int code = resultCode;
        if (code == 1){
            room1ImgView.setImageResource(R.drawable.icon_open);
            room2Btn.setEnabled(true);
            editor.putInt("room1Img",R.drawable.icon_open);
            editor.putBoolean("btn2Enable",true);
        }
        else if (code == 2){
            room2ImgView.setImageResource(R.drawable.icon_open);
            room3Btn.setEnabled(true);
            editor.putInt("room2Img",R.drawable.icon_open);
            editor.putBoolean("btn3Enable",true);
        }
        else if (code == 3){
            room3ImgView.setImageResource(R.drawable.icon_open);
            room4Btn.setEnabled(true);
            editor.putInt("room3Img",R.drawable.icon_open);
            editor.putBoolean("btn4Enable",true);
        }
        else if (code == 4){
            room4ImgView.setImageResource(R.drawable.icon_open);
            room5Btn.setEnabled(true);
            editor.putInt("room4Img",R.drawable.icon_open);
            editor.putBoolean("btn5Enable",true);
        }
        else if (code == 5){
            room5ImgView.setImageResource(R.drawable.icon_open);
            room6Btn.setEnabled(true);
            editor.putInt("room5Img",R.drawable.icon_open);
            editor.putBoolean("btn6Enable",true);
        }
        else if (code == 6){
            room6ImgView.setImageResource(R.drawable.icon_open);
            room7Btn.setEnabled(true);
            editor.putInt("room6Img",R.drawable.icon_open);
            editor.putBoolean("btn7Enable",true);
        }
        else if (code == 7){
            room7ImgView.setImageResource(R.drawable.icon_open);
            room8Btn.setEnabled(true);
            editor.putInt("room7Img",R.drawable.icon_open);
            editor.putBoolean("btn8Enable",true);
        }
        else if (code == 8){
            room8ImgView.setImageResource(R.drawable.icon_open);
            Toast toast = Toast.makeText(this.getApplicationContext(),"🎉축하합니다! 모든 방을 탈출하셨습니다!🎉",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
            editor.putInt("room8Img",R.drawable.icon_open);
            editor.putBoolean("clear",true);
        }
        else{
            Log.d("MAINACTIVITY","back - default");
        }
        editor.apply();
    }

    class BtnClickedListener implements Button.OnClickListener {
        @Override
        public void onClick(View view){
            Intent intent = new Intent(MainActivity.this,InsideRoomActivity.class);
            int id=view.getId();
            //TODO: switch - case 문으로 할 때는 왜 안먹힐까 생각해보기
            if (id == R.id.room1Btn) {
                intent.putExtra("roomName", "room1");
                intent.putExtra("hint", "hint\nhint\nhint");
                intent.putExtra("answer", "비밀의 숲");
                intent.putExtra("status", 1);
            }
            else if (id == R.id.room2Btn){
                intent.putExtra("roomName", "room2");
                intent.putExtra("hint", "hint\nhint\nhint");
                intent.putExtra("answer", "비밀의 숲");
                intent.putExtra("status", 2);
            }
            else if (id == R.id.room3Btn) {
                intent.putExtra("roomName", "room3");
                intent.putExtra("hint", "hint\nhint\nhint");
                intent.putExtra("answer", "비밀의 숲");
                intent.putExtra("status", 3);
            }
            else if (id == R.id.room4Btn) {
                intent.putExtra("roomName", "room4");
                intent.putExtra("hint", "hint\nhint\nhint");
                intent.putExtra("answer", "비밀의 숲");
                intent.putExtra("status", 4);
            }
            else if (id == R.id.room5Btn) {
                intent.putExtra("roomName", "room5");
                intent.putExtra("hint", "hint\nhint\nhint");
                intent.putExtra("answer", "비밀의 숲");
                intent.putExtra("status", 5);
            }
            else if (id == R.id.room6Btn) {
                intent.putExtra("roomName", "room6");
                intent.putExtra("hint", "hint\nhint\nhint");
                intent.putExtra("answer", "비밀의 숲");
                intent.putExtra("status", 6);
            }
            else if (id == R.id.room7Btn) {
                intent.putExtra("roomName", "room7");
                intent.putExtra("hint", "hint\nhint\nhint");
                intent.putExtra("answer", "비밀의 숲");
                intent.putExtra("status", 7);
            }
            else if (id == R.id.room8Btn) {
                intent.putExtra("roomName", "room8");
                intent.putExtra("hint", "hint\nhint\nhint");
                intent.putExtra("answer", "비밀의 숲");
                intent.putExtra("status", 8);
            }
            else{
                Log.d("MAINACTIVITY","switch - default");
            }
            startActivityForResult(intent, 0);
        }
    }
}