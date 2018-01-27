package com.example.xiongang.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by xiongang on 2018/1/22.
 */

public class CrimeActivity extends SingleFragmentActivity {
    public static final String EXTRA_CRIME_ID="com.android.criminalintent.crime_id";

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
    public static Intent newIntent(Context context, UUID crimeId)
    {
        Intent intent=new Intent(context,CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }
}
