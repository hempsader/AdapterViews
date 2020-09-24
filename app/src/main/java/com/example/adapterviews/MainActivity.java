package com.example.adapterviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, TextWatcher {
    private TextView selection;
    private AutoCompleteTextView autoCompleteTextView;
    private static final String[] items= {"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main );



        //List
        ListView listView = findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items));


        //Spinner
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items));
        selection = findViewById(R.id.selection);

        //gridview
        GridView gridView = findViewById(R.id.grid);
        gridView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items));
        gridView.setOnItemClickListener(this);

        //autocomplete
        autoCompleteTextView = findViewById(R.id.edit);
        autoCompleteTextView.addTextChangedListener(this);
        autoCompleteTextView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,items));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        selection.setText(items[i]);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selection.setText(items[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        selection.setText("");
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        selection.setText(autoCompleteTextView.getText());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}