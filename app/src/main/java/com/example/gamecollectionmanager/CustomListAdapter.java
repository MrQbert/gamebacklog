package com.example.gamecollectionmanager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> name;
    private final ArrayList<String> console;


    public CustomListAdapter(@NonNull Activity context, ArrayList name, ArrayList console) {
        super(context, R.layout.listitem, name);
        this.context = context;
        this.name = name;
        this.console = console;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View v, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.listitem,null,true);

        TextView textname= rowView.findViewById(R.id.name);
        TextView textconsole= rowView.findViewById(R.id.console);

        textname.setText(name.get(position));
        textconsole.setText(console.get(position));

        return rowView;
    }
}
