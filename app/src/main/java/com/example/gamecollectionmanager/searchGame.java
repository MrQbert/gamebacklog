package com.example.gamecollectionmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class searchGame extends AppCompatActivity {
    FloatingActionButton toHomeEl;
    FloatingActionButton toAddEl;
    SQLiteDatabase db;
    Button search;
    ListView list;
    EditText nameInput;
    EditText consoleInput;
    ArrayList<String> name;
    ArrayList<String> console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_game);

        toHomeEl = findViewById(R.id.homeEl);
        toAddEl = findViewById(R.id.addEl);
        search = findViewById(R.id.search);
        nameInput = findViewById(R.id.enterNameEl);
        consoleInput = findViewById(R.id.enterPlatformEl);

        db = openOrCreateDatabase("gameCollection", MODE_PRIVATE, null);
        db.execSQL("create table if not exists games (gameName varchar(50),gameConsole varchar(50));");
//        ViewAll();
//        CustomListAdapter adapter = new CustomListAdapter(this,name,console);
//        list = findViewById(R.id.list);
//        list.setEmptyView(findViewById(R.id.empty));
//        list.setAdapter(adapter);

    }

    public void searchGame(View V){
        String nameQuery ="'"+nameInput.getText().toString()+"'";
        String consoleQuery ="'"+consoleInput.getText().toString()+"'";
        Cursor c = db.rawQuery("select * from games where  gameName="+ nameQuery + "AND gameConsole= "+ consoleQuery +";",null);
        if(c.getCount()==0) {
            ShowMessage("Game Not Found In Collection", nameQuery + " for " + consoleQuery );
            return;
        }else if(c.getCount() > 0){
            ShowMessage("Game Found", nameQuery + " for " + consoleQuery );
        }

    }


    public void ShowMessage(String title, String message){
        AlertDialog.Builder messBr = new AlertDialog.Builder(this);
        messBr.setCancelable(true);
        messBr.setTitle(title);
        messBr.setMessage(message);
        messBr.show();
    }

    public  void toHome(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public  void toAdd(View v){
        Intent i = new Intent(this,addGame.class);
        startActivity(i);
    }
}