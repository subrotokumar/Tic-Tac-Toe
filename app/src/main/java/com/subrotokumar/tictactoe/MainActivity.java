package com.subrotokumar.tictactoe;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> a=new ArrayList<>();
    private ArrayList<Integer> b=new ArrayList<>();
    private int activePlayer=1;
    Boolean isGameOngoing=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button restartMatch=(Button) findViewById(R.id.btnRestart);
        restartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Button)findViewById(R.id.btn1)).setText("");
                ((Button)findViewById(R.id.btn2)).setText("");
                ((Button)findViewById(R.id.btn3)).setText("");
                ((Button)findViewById(R.id.btn4)).setText("");
                ((Button)findViewById(R.id.btn5)).setText("");
                ((Button)findViewById(R.id.btn6)).setText("");
                ((Button)findViewById(R.id.btn7)).setText("");
                ((Button)findViewById(R.id.btn8)).setText("");
                ((Button)findViewById(R.id.btn9)).setText("");
                activePlayer=1;
                isGameOngoing=true;
                ((TextView)findViewById(R.id.tvResult)).setText("");
                a.clear();
                b.clear();
            }
        });
    }

    public void clickbtn(View view) {
        if(isGameOngoing) {
            try {
                Button btnSelected = (Button) view;
                int cellId = 0;
                switch (btnSelected.getId()) {
                    case R.id.btn1:
                        cellId = 1;
                        break;
                    case R.id.btn2:
                        cellId = 2;
                        break;
                    case R.id.btn3:
                        cellId = 3;
                        break;
                    case R.id.btn4:
                        cellId = 4;
                        break;
                    case R.id.btn5:
                        cellId = 5;
                        break;
                    case R.id.btn6:
                        cellId = 6;
                        break;
                    case R.id.btn7:
                        cellId = 7;
                        break;
                    case R.id.btn8:
                        cellId = 8;
                        break;
                    case R.id.btn9:
                        cellId = 9;
                        break;
                }

                playerAction(cellId, btnSelected);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    boolean winner(ArrayList<Integer> c)
    {
        if(c.contains(1)&&c.contains(2)&&c.contains(3))
            return true;
        else if(c.contains(4)&&c.contains(5)&&c.contains(6))
            return true;
        else if(c.contains(7)&&c.contains(8)&&c.contains(9))
            return true;
        else if(c.contains(1)&&c.contains(4)&&c.contains(7))
            return true;
        else if (c.contains(2)&&c.contains(5)&&c.contains(8))
            return true;
        else if(c.contains(3)&&c.contains(6)&&c.contains(9))
            return true;
        else if(c.contains(1)&&c.contains(5)&&c.contains(9))
            return true;
        else if(c.contains(3)&&c.contains(5)&&c.contains(7))
            return true;
        else
            return false;
    }
    public void playerAction(int cellId,Button btnselected)
    {
        if(btnselected.getText().toString().isEmpty())
        {
            if(activePlayer==1)
            {
                a.add(cellId);
                btnselected.setText("x");
                btnselected.setTextColor(Color.parseColor("#072227"));
                activePlayer=2;
                if(winner(a)) {
                    TextView tv=(TextView) findViewById(R.id.tvResult);
                    tv.setText("X Won!");
                    //Toast.makeText(this, "Player X wins.", Toast.LENGTH_SHORT).show();
                    isGameOngoing=false;
                }
            }
            else
            {
                b.add(cellId);
                btnselected.setText("o");
                btnselected.setTextColor(Color.parseColor("#4FBDBA"));
                activePlayer=1;
                if(winner(b)) {
                    TextView tv=(TextView) findViewById(R.id.tvResult);
                    tv.setText("O Won!!");
                    //Toast.makeText(this, "Player O wins.", Toast.LENGTH_SHORT).show();
                    isGameOngoing=false;
                }
            }
        }
    }
}