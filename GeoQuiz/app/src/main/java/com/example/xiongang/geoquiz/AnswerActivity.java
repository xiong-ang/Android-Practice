package com.example.xiongang.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AnswerActivity extends AppCompatActivity {
    private static final String EXTERN_QUESTION="QUESTION";
    private static final String EXTERN_ANSWER="ANSWER";
    private static final String EXTERN_ANSWER_SHOWN="ANSWER_SHOWN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        TextView questionView=(TextView)findViewById(R.id.question_view);
        questionView.setText(getIntent().getIntExtra(EXTERN_QUESTION,R.string.error_text));

        TextView answerView=(TextView)findViewById(R.id.answer_view);
        answerView.setText(getIntent().getBooleanExtra(EXTERN_ANSWER,false)?R.string.buttom_true:R.string.buttom_false);

        setAnswerReturn();
    }
    public static Intent createAnswerIntent(Context packageContext, int questionId, boolean answer)
    {
        Intent intent=new Intent(packageContext,AnswerActivity.class);
        intent.putExtra(EXTERN_QUESTION,questionId);
        return intent.putExtra(EXTERN_ANSWER,answer);
    }
    public static boolean getAnswerShown(Intent intent)
    {
        return intent.getBooleanExtra(EXTERN_ANSWER_SHOWN,false);
    }

    private void setAnswerReturn()
    {
        setResult(RESULT_OK,new Intent().putExtra(EXTERN_ANSWER_SHOWN,true));
    }
}
