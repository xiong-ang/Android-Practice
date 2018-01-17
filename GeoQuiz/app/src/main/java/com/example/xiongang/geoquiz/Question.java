package com.example.xiongang.geoquiz;

/**
 * Created by xiongang on 2018/1/15.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswer;

    public Question(int textResId, boolean answer)
    {
        mTextResId=textResId;
        mAnswer=answer;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
