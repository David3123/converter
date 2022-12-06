package com.example.unitconverterapplication.Manvelyan303;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sp1;
    Spinner sp2;
    EditText editT;
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        editT = findViewById(R.id.editT);
        text3 = findViewById(R.id.text3);


        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        sp1.setAdapter(adp);
        sp2.setAdapter(adp);
    }

    public void on_convert(View v)
    {
        float from = Float.parseFloat(editT.getText().toString());

        String s1 = (String) sp1.getSelectedItem();
        String s2 = (String) sp2.getSelectedItem();

        float to = 0.0f;

        if (s1.equals("mm"))
        {
            if (s2.equals("mm")) to = from * 1.0f;
            if (s2.equals("cm")) to = from * 0.1f;
            if (s2.equals("m")) to = from * 0.001f;
            if (s2.equals("km")) to = from * 0.000001f;
        }

        if (s1.equals("cm"))
        {
            if (s2.equals("mm")) to = from * 10.0f;
            if (s2.equals("cm")) to = from * 1.0f;
            if (s2.equals("m")) to = from * 0.01f;
            if (s2.equals("km")) to = from * 0.00001f;
        }

        if (s1.equals("m"))
        {
            if (s2.equals("mm")) to = from * 1000.0f;
            if (s2.equals("cm")) to = from * 100.0f;
            if (s2.equals("m")) to = from * 1.0f;
            if (s2.equals("km")) to = from * 0.001f;
        }

        if (s1.equals("km"))
        {
            if (s2.equals("mm")) to = from * 1000000.0f;
            if (s2.equals("cm")) to = from * 100000.0f;
            if (s2.equals("m")) to = from * 1000.0f;
            if (s2.equals("km")) to = from * 1.0f;
        }

        text3.setText(String.valueOf(to));
    }
}