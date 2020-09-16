package com.room.stranger_maze;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsideRoomActivity extends AppCompatActivity {

    TextView roomTitleTextView, hintTextView;
    EditText answerInput;
    String answer="";
    int status = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inside_room);

        roomTitleTextView = findViewById(R.id.roomTitleTextView);
        hintTextView = findViewById(R.id.hintTextView);
        answerInput = findViewById(R.id.answerInput);

        //이전 화면에서 보낸 것 받음
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String roomTitle = bundle.getString("roomName");
        String hint = bundle.getString("hint");
        answer = bundle.getString("answer");
        status = bundle.getInt("status");

        roomTitleTextView.setText(roomTitle);
        hintTextView.setText(hint);

    }

    public void onEscapeBtnClicked(View view){
        Log.d("INSIDEROOM","onEscapeBtnClicked()");

        String inputAnswer = answerInput.getText().toString();

        if(inputAnswer.equals(answer)){
            //처음 화면으로 돌아가면 방 잠금 이미지 변경되고 다음 버튼 잠금 해제
            setResult(status);
            finish();
        }
        else{
            Toast toast = Toast.makeText(this.getApplicationContext(),"답이 아닙니다.😑",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    }
}
