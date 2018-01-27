package com.example.xiongang.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by xiongang on 2018/1/22.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
