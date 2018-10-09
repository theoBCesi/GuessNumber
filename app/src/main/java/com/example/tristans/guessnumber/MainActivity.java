package com.example.tristans.guessnumber;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends Activity {

    Integer secret;
    Integer currentValue;
    TextView txtviewm;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imgBtn0 = (ImageButton) findViewById(R.id.image0);
        ImageButton imgBtn1 = (ImageButton) findViewById(R.id.image1);
        ImageButton imgBtn2 = (ImageButton) findViewById(R.id.image2);
        ImageButton imgBtn3 = (ImageButton) findViewById(R.id.image3);
        ImageButton imgBtn4 = (ImageButton) findViewById(R.id.image4);
        ImageButton imgBtn5 = (ImageButton) findViewById(R.id.image5);
        ImageButton imgBtn6 = (ImageButton) findViewById(R.id.image6);
        ImageButton imgBtn7 = (ImageButton) findViewById(R.id.image7);
        ImageButton imgBtn8 = (ImageButton) findViewById(R.id.image8);
        ImageButton imgBtn9 = (ImageButton) findViewById(R.id.image9);

        imgBtn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touche(0);
            }
        });
        imgBtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touche(1);
            }
        });
        imgBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touche(2);
            }
        });
        imgBtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touche(3);
            }
        });
        imgBtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touche(4);
            }
        });
        imgBtn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touche(5);
            }
        });
        imgBtn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touche(6);
            }
        });
        imgBtn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touche(7);
            }
        });
        imgBtn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touche(8);
            }
        });
        imgBtn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touche(9);
            }
        });

        txtviewm = (TextView) findViewById(R.id.textView2);
        txtviewm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        txtviewm.setTextColor(Color.BLUE);
        txtviewm.setText("?");
        secret = (int) ThreadLocalRandom.current().nextInt(0, 100);
        currentValue = -1;
        result = (TextView) findViewById(R.id.textView);
        result.setText("");
    }

    public void touche(Integer value) {
        Log.d("GuessClicked", "" + value);
        Log.d("Secret", "" + secret);
        result.setText(result.getText().toString() + value.toString());

        Log.d("result", "" + result.getText().toString());
        currentValue = Integer.parseInt(result.getText().toString());
        if (currentValue > 99) {
            result.setText(value.toString());
            currentValue=value;
        }
        if (currentValue > secret) {
            txtviewm.setText("-");
            txtviewm.setTextColor(Color.RED);
        } else if (currentValue < secret) {
            txtviewm.setText("+");
            txtviewm.setTextColor(Color.RED);
        } else {
            txtviewm.setText("Win - nouveau nombre généré");
            txtviewm.setTextColor(Color.GREEN);
            secret = (int) ThreadLocalRandom.current().nextInt(0, 100);
        }
    }
}
