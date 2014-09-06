package com.nozomi.fragmentsample4.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.nozomi.fragmentsample4.R;
import com.nozomi.fragmentsample4.fragment.BaseFragment;
import com.nozomi.fragmentsample4.fragment.Fragment1;
import com.nozomi.fragmentsample4.fragment.Fragment2;
import com.nozomi.fragmentsample4.fragment.Fragment3;
import com.nozomi.fragmentsample4.fragment.NavigationDrawerFragment;
import com.nozomi.fragmentsample4.util.ToastUtil;

public class MainActivity extends ActionBarActivity implements
        NavigationDrawerFragment.NavigationDrawerCallbacks {
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private BaseFragment mSelectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        // init actionBar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // change fragment.
        if (position == 0) {
            mSelectedFragment = Fragment1.newInstance(position + 1);
        } else if (position == 1) {
            mSelectedFragment = Fragment2.newInstance(position + 1);
        } else if (position == 2) {
            mSelectedFragment = Fragment3.newInstance(position + 1);
        }
        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, mSelectedFragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (mSelectedFragment == null) {
            // shouldn't reach here.
            finish();
        } else if (!mSelectedFragment.onBackPressed()) {
            // mSelectedFragment did't use this action.
            ToastUtil.makeToast(this, "finish");
            finish();
        }
    }
}
