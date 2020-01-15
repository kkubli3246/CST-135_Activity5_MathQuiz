package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Game game = new Game();
    int secondsRemaining = 29;

    CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            tv_time.setText(Integer.toString(secondsRemaining) + "sec");
            progressBar.setProgress(30 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            tv_time.setText("0sec");
            progressBar.setProgress(30);

            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);

            tv_bottomMessage.setText("Time is Up! " + game.getCorrect() + 1 + "/" + game.getTotalQuestions());


            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                }
            }, 4000);



        }
    };



    Button btn_start;
    Button btn_answer0;
    Button btn_answer1;
    Button btn_answer2;
    Button btn_answer3;

    TextView tv_score;
    TextView tv_questions;
    TextView tv_time;
    TextView tv_bottomMessage;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button)findViewById(R.id.btn_start);
        btn_answer0 = (Button)findViewById(R.id.btn_answer0);
        btn_answer1 = (Button)findViewById(R.id.btn_answer1);
        btn_answer2 = (Button)findViewById(R.id.btn_answer2);
        btn_answer3 = (Button)findViewById(R.id.btn_answer3);

        tv_score = (TextView)findViewById(R.id.tv_score);
        tv_questions = (TextView)findViewById(R.id.tv_questions);
        tv_time = (TextView)findViewById(R.id.tv_time);
        tv_bottomMessage = (TextView)findViewById(R.id.tv_bottomMessage);

        progressBar = findViewById(R.id.progressBar);

        tv_time.setText("0sec");
        tv_questions.setText("");
        tv_bottomMessage.setText("Press Go!");
        tv_score.setText("O Points");

        View.OnClickListener startButtonClickListener =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button startButton = (Button)v;

                startButton.setVisibility(View.INVISIBLE);
                secondsRemaining = 30;
                game = new Game();
                timer.start();

                nextTurn();
            }
        };

        View.OnClickListener answerButtonClickListener =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button)v;

                int answerSelected = Integer.parseInt((buttonClicked.getText().toString()));


                game.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(game.getScore()));

                nextTurn();
            }
        };

        btn_start.setOnClickListener(startButtonClickListener);

        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);



    }

    private void nextTurn(){
        game.makeNewQuestion();
        int [] answers = game.getCurrentQuestion().getAnswerArray();

        btn_answer0.setText(Integer.toString(answers[0]));
        btn_answer1.setText(Integer.toString(answers[1]));
        btn_answer2.setText(Integer.toString(answers[2]));
        btn_answer3.setText(Integer.toString(answers[3]));

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        tv_questions.setText(game.getCurrentQuestion().getQuestionPhrase());
        tv_bottomMessage.setText(game.getCorrect() + 1 + "/" + game.getTotalQuestions());


    }
}
