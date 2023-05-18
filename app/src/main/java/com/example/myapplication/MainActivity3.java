package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity3 extends AppCompatActivity {

    TextView displayWord;
    Button start;
    Button check;
    Button reset;

    EditText word,clue;
    Button[] buttons = new Button[16];

    String word_string;

    ConstraintLayout gameLayout;

    Set<Integer> letterPosition = new HashSet<>() ;
    String k = "";
    int traverseArray;
    int position=0;
    int length,life = 3;





    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word = findViewById(R.id.word_edittext);
        clue = findViewById(R.id.clue_edittext);

        word = findViewById(R.id.word_edittext);
        clue = findViewById(R.id.clue_edittext);
        displayWord = findViewById(R.id.displaytext);
        start = findViewById(R.id.start_button);
        check = findViewById(R.id.check_button);
        reset = findViewById(R.id.reset_button);
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buthttps://github.com/mahesh985/mahesh.idea.gittons[2]= findViewById(R.id.button3);
        buttons[3]= findViewById(R.id.button4);
        buttons[4]= findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6]= findViewById(R.id.button7);
        buttons[7]= findViewById(R.id.button8);
        buttons[8]= findViewById(R.id.button9);
        buttons[9]= findViewById(R.id.button10);
        buttons[10]= findViewById(R.id.button11);
        buttons[11]= findViewById(R.id.button12);
        buttons[12]= findViewById(R.id.button13);
        buttons[13]= findViewById(R.id.button14);
        buttons[14]= findViewById(R.id.button15);
        buttons[15]= findViewById(R.id.button16);
        gameLayout = findViewById(R.id.game_layout);





        for (traverseArray = 0; traverseArray < buttons.length; traverseArray++) {
            buttons[traverseArray].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String tempLetter = buttons[traverseArray].getText().toString();
                    k = k.substring(0, position) + tempLetter + k.substring(position + 1);
                    position++;
                    displayWord.setText(k);
                }
            });
        }

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (int i = 0; i < length; i++) {
                    k += "_";
                }
                displayWord.setText(k);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (k == word_string) {
                    Toast.makeText(MainActivity3.this, "You Won", Toast.LENGTH_SHORT).show();
                } else {
                    life--;
                    if (life == 0) {
                        Toast.makeText(MainActivity3.this, "You Lost", Toast.LENGTH_SHORT).show();
                    } else {
                        for (int i = 0; i < length; i++) {
                            k += "_";
                        }
                        displayWord.setText(k);
                    }

                }
            }
        });


    }

    public void setWord(){
        length = word_string.length();
        for(int i=0;i<length;i++)
        {
            k += "_";
        }
        Random r = new Random();
        Random r2 = new Random();

        int tempNum = r.nextInt(16);
        Character[] myarr = new Character[16];

        while(letterPosition.size()<length)
        {
            letterPosition.add(tempNum);
        }
        int j = 0;
        for(int i: letterPosition )
        {
            myarr[i] = word_string.charAt(j);
            j++;
        }

        for(int i=0;i<16;i++)
        {
            if(!letterPosition.contains(i))
            {
                int tempnum1 = r2.nextInt(26);
                tempnum1 += 97;
                myarr[i] = (char)tempnum1;
            }

            buttons[i].setText(myarr[i]);
        }

    }





}