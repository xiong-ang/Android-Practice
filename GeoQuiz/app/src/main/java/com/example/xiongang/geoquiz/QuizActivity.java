package com.example.xiongang.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mAnswerButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;

    private Question[] mQuestions=new Question[]{
            new Question(R.string.question1,true),
            new Question(R.string.question2,false),
            new Question(R.string.question3,true),
            new Question(R.string.question4,true)
    };
    private int mCurrentIndex=0;
    private static final String KEY_INDEX="index";
    private boolean mAnswerShown=false;

    private static final String TAG="QuizActivity";
    private static final int REQUES_CODE_CHEAT=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.d(TAG,"onCreate() called");

        //应对屏幕旋转造成的Activity重建
        if(savedInstanceState!=null)
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX);

        mQuestionTextView=(TextView)findViewById(R.id.question_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestions.length;
                updateQuestion();
            }
        });
        updateQuestion();

        mTrueButton=(Button)findViewById(R.id.button_true);
        mTrueButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                /*
                Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                */
                checkAnswer(true);
            }
        });
        mFalseButton=(Button)findViewById(R.id.button_false);
        mFalseButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                /*
                Toast toast = Toast.makeText(QuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM,0,0);
                toast.show();
                */
                checkAnswer(false);
            }
        });

        mAnswerButton=(Button)findViewById(R.id.button_answer);
        mAnswerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Question q=mQuestions[mCurrentIndex];
                startActivityForResult(AnswerActivity.createAnswerIntent(QuizActivity.this,q.getTextResId(),q.getAnswer()),REQUES_CODE_CHEAT);
            }
        });

        mNextButton=(ImageButton)findViewById(R.id.button_next);
        mNextButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestions.length;
                updateQuestion();
            }
        });
        mPrevButton=(ImageButton)findViewById(R.id.button_prev);
        mPrevButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+mQuestions.length-1)%mQuestions.length;
                updateQuestion();
            }
        });
    }
    private void updateQuestion()
    {
        int questionId=mQuestions[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(questionId);
        mAnswerShown=false;
        //mFalseButton.setEnabled(false);
        //mTrueButton.setEnabled(false);
        //mPrevButton.setEnabled(false);
    }
    private void checkAnswer(boolean userAnswer)
    {
        boolean answer=mQuestions[mCurrentIndex].getAnswer();
        int messageId=0;
        if(mAnswerShown)
            messageId=R.string.judgement_toast;
        else
        {
            if(userAnswer==answer)
                messageId=R.string.correct_toast;
            else
                messageId=R.string.incorrect_toast;
        }
        Toast.makeText(QuizActivity.this,messageId,Toast.LENGTH_SHORT).show();

        if(mCurrentIndex==mQuestions.length-1)
            Toast.makeText(QuizActivity.this,R.string.complate_toast,Toast.LENGTH_SHORT).show();
    }

    //Buddle 用于保存Activity，以应对比如屏幕旋转时的Activity重建
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState() called");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(TAG,"onResume() called");
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(TAG,"onPause() called");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(TAG,"onStop() called");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG,"onDestroy() called");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if(resultCode!= Activity.RESULT_OK)
            return;

        if(requestCode==REQUES_CODE_CHEAT)
        {
            if(intent!=null)
                mAnswerShown=AnswerActivity.getAnswerShown(intent);
        }
    }
}
