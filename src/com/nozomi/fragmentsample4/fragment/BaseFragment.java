package com.nozomi.fragmentsample4.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

public abstract class BaseFragment extends Fragment {

    public abstract String getTitie();

    public abstract boolean onBackPressed();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // update title.
        ((ActionBarActivity) activity).getSupportActionBar().setTitle(getTitie());
    }

}