package com.nozomi.fragmentsample4.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nozomi.fragmentsample4.R;
import com.nozomi.fragmentsample4.util.ToastUtil;

public class Fragment2 extends BaseFragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int mSectionNumber = -1;

    public static Fragment2 newInstance(int sectionNumber) {
        final Fragment2 fragment = new Fragment2();
        final Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mSectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        final TextView sectionLabelView = (TextView) rootView.findViewById(R.id.section_label);
        sectionLabelView.setText("fragment" + mSectionNumber);
    }

    @Override
    public String getTitie() {
        return "title2";
    }

    @Override
    public boolean onBackPressed() {
        // use this action.
        ToastUtil.makeToast(getActivity(), "fragment2");
        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment2, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        if (id == R.id.action_example) {
            ToastUtil.makeToast(getActivity(), "fragment2 example");
            return true;
        }
        return false;
    }
}