package com.example.finalchallengeday1_project2_quizapp_mvcarchitecture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalchallengeday1_project2_quizapp_mvcarchitecture.model.Question;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "MainActivity";
    private TextView textView;
    private Button trueBtn;
    private Button falseBtn;
    private ImageButton previousBtn;
    private ImageButton nextBtn;

    private Question question[] = new Question[]{
            new Question(R.string.question_1,false),
            new Question(R.string.question_2,true),
            new Question(R.string.question_3,false),
            new Question(R.string.question_4,false),
            new Question(R.string.question_5,false),
            new Question(R.string.question_6,true),
            new Question(R.string.question_7,true)
    };

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.question_textView);
        trueBtn = findViewById(R.id.trueBtn_button);
        falseBtn = findViewById(R.id.falseBtn_button);
        previousBtn = findViewById(R.id.previousBtn_imageButton);
        nextBtn = findViewById(R.id.nextBtn_imageButton);

        trueBtn.setOnClickListener(this);
        falseBtn.setOnClickListener(this);
        previousBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

        updateQuestion();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.trueBtn_button:
                checkAnswer(true);
                break;

            case R.id.falseBtn_button:
                checkAnswer(false);
                break;

            case R.id.previousBtn_imageButton:
                if (currentIndex>0){
                    currentIndex = (currentIndex - 1) % question.length;
                    Log.d(TAG, "onClick: current question: "+currentIndex);
                    updateQuestion();
                }

                break;

            case R.id.nextBtn_imageButton:
                    currentIndex = (currentIndex + 1)  % question.length;
                    updateQuestion();
                    Log.d(TAG, "onClick: current question: "+currentIndex);
                break;

            default:
        }
    }

    private void updateQuestion(){
        textView.setText(question[currentIndex].getQuestionText());
    }

    private void checkAnswer(boolean checkIsAnswerTrue){

        boolean isAnswerTrue =  question[currentIndex].isAnswerTrue();

        if (checkIsAnswerTrue == isAnswerTrue){
            Toast.makeText(getApplicationContext(),"Answer Is : True",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Answer Is : False",Toast.LENGTH_SHORT).show();
        }

    }

}