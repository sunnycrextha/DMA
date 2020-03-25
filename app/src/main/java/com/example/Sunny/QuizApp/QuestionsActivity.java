package com.example.Sunny.QuizApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Sunny.QuizApp.R;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "Smells like teen spirit was the first single off Nirvana's hit album of this name",
                            "Green Day followed up success of 1994's 'dookie' album with the 1995 album this name ",
                            "Bon jovi was the lead singer of which band?",
                            "Jim morrison was the lead singer of which band?",
                            "Mick jagger was the lead singer of which band?",
                            "ozzy osbourne was the lead singer of which band?",
                            "Marcus mumford was the lead singer of which band?",
                            "James hetfield was the lead singer of which band?",
                            "Brian Johnson was the lead singer of which band?",
                            "Chris Martin was the lead singer of which band?"
                         };
    String answers[] = {"Nevermind","Insomniac","Bon jovi","The Doors","The Rolling Stones","Black Sabbath","mumford and sons","Metallica","ACDC","Coldplay"};
    String opt[] = {
                    "In Utero","Nirvana Unplugged ","Bleach","Nevermind",
                    "American idiot","Insomniac","Kerplunk","Nimrod",
                    "warrant","Bon jovi","Greenday","abstract",
                    "The Doors","Three Dog Night","The kinks","Grease",
                    "The rolling stones","Maroon 5","Beatles","MCR",
                    "Iron Maiden","Black Sabbath","Pantera","Metallica",
                    "Lumineers","The kongos","mumford and sons","Fun",
                    "megadeth","Metallica","Bad company","Six feet under",
                    "ACDC","Twisted sister","Motorhead","Panic at the disco",
                     "Imagine Dragons","Snow Patrol","One republic","Coldplay"
                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Welcome");
        else
        textView.setText("welcome " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}