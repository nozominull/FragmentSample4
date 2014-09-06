package com.nozomi.fragmentsample4.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nozomi.fragmentsample4.R;

public class Fragment3 extends BaseFragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int mSectionNumber = -1;

    public static Fragment3 newInstance(int sectionNumber) {
        final Fragment3 fragment = new Fragment3();
        final Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment3() {
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
        return "title3";
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

}