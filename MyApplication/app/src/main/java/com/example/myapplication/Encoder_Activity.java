package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Encoder_Activity extends AppCompatActivity {

    public TextView msg;
    public static String str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder_);
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Symbol Encoder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        msg=findViewById(R.id.msg);
        msg.setText(""+str);




    }

    public static void convert(StringBuffer st) {

        String st1 = st.toString();
        char c[] = st1.toCharArray();
        int j = 0;
        for (int i = 0; i < st1.length(); i++) {

            for (j = j + 0; j < st.length(); j++) {

                if (st1.charAt(i) == ' ') {
                    j++;


                    break;
                }

                if (c[i] == '0' && c[i + 1] == '1' && c[i + 2] == '1' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "a");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '1' && c[i + 2] == '2' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "b");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '1' && c[i + 2] == '3' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "c");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '1' && c[i + 2] == '4' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "d");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '1' && c[i + 2] == '5' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "e");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '1' && c[i + 2] == '6' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "f");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '1' && c[i + 2] == '7' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "g");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '1' && c[i + 2] == '8' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "h");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '1' && c[i + 2] == '9' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "i");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '2' && c[i + 2] == '0' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "j");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '2' && c[i + 2] == '1' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "k");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '2' && c[i + 2] == '2' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "l");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '2' && c[i + 2] == '3' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "m");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '2' && c[i + 2] == '4' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "n");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '2' && c[i + 2] == '5' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "o");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '2' && c[i + 2] == '6' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "p");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '2' && c[i + 2] == '7' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "q");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '2' && c[i + 2] == '8' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "r");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '2' && c[i + 2] == '9' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "s");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '3' && c[i + 2] == '0' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "t");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '3' && c[i + 2] == '1' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "u");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '3' && c[i + 2] == '2' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "v");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '3' && c[i + 2] == '3' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "w");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '3' && c[i + 2] == '4' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "x");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '3' && c[i + 2] == '5' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "y");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '0' && c[i + 1] == '3' && c[i + 2] == '6' && c[i + 3] == '@') {
                    st.replace(j, j + 4, "z");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '1' && c[i + 2] == '1' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "A");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '1' && c[i + 2] == '2' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "B");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '1' && c[i + 2] == '3' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "C");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '1' && c[i + 2] == '4' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "D");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '1' && c[i + 2] == '5' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "E");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '1' && c[i + 2] == '6' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "F");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '1' && c[i + 2] == '7' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "G");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '1' && c[i + 2] == '8' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "H");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '1' && c[i + 2] == '9' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "I");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '2' && c[i + 2] == '0' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "J");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '2' && c[i + 2] == '1' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "K");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '2' && c[i + 2] == '2' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "L");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '2' && c[i + 2] == '3' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "M");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '2' && c[i + 2] == '4' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "N");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '2' && c[i + 2] == '5' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "O");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '2' && c[i + 2] == '6' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "P");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '2' && c[i + 2] == '7' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "Q");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '2' && c[i + 2] == '8' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "R");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '2' && c[i + 2] == '9' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "S");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '3' && c[i + 2] == '0' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "T");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '3' && c[i + 2] == '1' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "U");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '3' && c[i + 2] == '2' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "V");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '3' && c[i + 2] == '3' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "W");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '3' && c[i + 2] == '4' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "X");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '3' && c[i + 2] == '5' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "Y");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else if (c[i] == '1' && c[i + 1] == '3' && c[i + 2] == '6' && c[i + 3] == '#') {
                    st.replace(j, j + 4, "Z");
                    j = j + 1;
                    i = i + 3;
                    break;
                } else {
                    j++;
                    break;
                }
            }
        }

          str=st.toString();
    }




}