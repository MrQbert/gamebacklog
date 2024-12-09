package com.example.gamecollectionmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton toSearchEl;
    FloatingActionButton toAddEl;
    SQLiteDatabase db;
    ListView list;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> console = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toSearchEl = findViewById(R.id.searchEl);
        toAddEl = findViewById(R.id.addEl);

        db = openOrCreateDatabase("gameCollection", MODE_PRIVATE, null);
        db.execSQL("create table if not exists games (gameName varchar(50),gameConsole varchar(50));");
        ViewAll();

        CustomListAdapter adapter = new CustomListAdapter(this,name,console);
        list = findViewById(R.id.list);
        list.setEmptyView(findViewById(R.id.empty));
        list.setAdapter(adapter);

    }
    public void ViewAll(){
        Cursor c = db.rawQuery("select gameName, gameConsole from games",null);
        if(c.getCount()==0){
            ShowMessage("No Games In Collection", "Add Games");
            return;
        }
        while(c.moveToNext()){
            name.add(c.getString(0));
            console.add(c.getString(1));
        }
    }
    public void ShowMessage(String title, String message){
        AlertDialog.Builder messBr = new AlertDialog.Builder(this);
        messBr.setCancelable(true);
        messBr.setTitle(title);
        messBr.setMessage(message);
        messBr.show();
    }

    public void toSearch(View v){
        Intent i = new Intent(this, searchGame.class);
        startActivity(i);
    }
    public void toAdd(View v){
        Intent i = new Intent(this, addGame.class);
        startActivity(i);
    }

}