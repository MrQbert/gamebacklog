package com.example.gamecollectionmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton toSearchEl;
    FloatingActionButton toAddEl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toSearchEl = findViewById(R.id.searchEl);
        toAddEl = findViewById(R.id.addEl);






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