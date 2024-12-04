package com.example.gamecollectionmanager;

import androidx.appcompat.app.AlertDialog;
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
    SQLiteDatabase db;
    StringBuilder sb = new StringBuilder();
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

        enterNameEl = findViewById(R.id.enterNameEl);
        enterPlatformEl = findViewById(R.id.enterPlatformEl);
        db = openOrCreateDatabase("gameCollection", MODE_PRIVATE, null);
        db.execSQL("create table if not exists games (gameName varchar(50),gameConsole varchar(50));");


    }
    public void save(View v){
        String gameName = enterNameEl.getText().toString().trim();
        String gameConsole = enterPlatformEl.getText().toString().trim();

        if(gameName.length() == 0 || gameConsole.length() ==0){
            sb.delete(0,sb.length());
            sb.append("Please Enter All the Fields");
            ShowMessage("Error", sb.toString());
        }else{
            db.execSQL("insert into games(gameName, gameConsole) Values('" + gameName + "','" + gameConsole + "' )");
            sb.delete(0,sb.length());
            sb.append("Happy Gaming");
            ShowMessage("Added!", sb.toString());
        }

    }

    public void toHome(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void toSearch(View v){
        Intent i = new Intent(this, searchGame.class);
        startActivity(i);
    }

    public void ShowMessage(String title, String message){
        android.app.AlertDialog.Builder messBr = new android.app.AlertDialog.Builder(this);
        messBr.setCancelable(true);
        messBr.setTitle(title);
        messBr.setMessage(message);
        messBr.show();
    }
}