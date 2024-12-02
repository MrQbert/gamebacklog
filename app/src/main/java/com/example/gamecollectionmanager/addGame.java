package com.example.gamecollectionmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addGame extends AppCompatActivity {
    EditText enterNameEl;
    EditText enterPlatformEl;
    Button submit;
    SQLiteDatabase db;
    StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

        enterNameEl = findViewById(R.id.enterNameEl);
        enterPlatformEl = findViewById(R.id.enterPlatformEl);
        db = openOrCreateDatabase("gameCollection", MODE_PRIVATE, null);
        db.execSQL("create table if not exists games ()");


    }
    public void toHome(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void toSearch(View v){
        Intent i = new Intent(this, searchGame.class);
        startActivity(i);
    }
}