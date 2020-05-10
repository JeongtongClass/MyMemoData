package com.example.mymemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddActivity extends AppCompatActivity {
    public  String msg;
    private EditText edtText;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
//파이어베이스연동
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edtText=findViewById(R.id.edtMemo);

        findViewById(R.id.btnDone).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String str= edtText.getText().toString();
                msg = edtText.getText().toString();
                databaseReference.child("To do list").push().setValue(msg); //파이어데이터베이스에 등록됨.


                if(str.length()>0){
                    Date date=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

                    String substr=sdf.format(date);
                    Toast.makeText(AddActivity.this,str+","+substr,Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.putExtra("main",str);
                    intent.putExtra("sub",substr);
                    setResult(0,intent);

                    finish();

                }
            }
        });

        findViewById(R.id.btnNo).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });
//이방법은 나중에
       /* databaseReference.child("To do list").addChildEventListener(new ChildEventListener() {  // message는 child의 이벤트를 수신합니다.
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Memo memo = dataSnapshot.getValue(Memo.class);  //
                ArrayList<String> adapter;
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
                listView.setAdapter(adapter);
                adapter.add(memo.getMaintext() + memo.getSubtext());  // adapter에 추가.
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });*/
    }



}
