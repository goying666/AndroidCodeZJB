package renchaigao.com.zjbapplication.team;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import renchaigao.com.zjbapplication.R;


public class TeamFragment extends Fragment {

    private View view;
    public Activity mContext;

    public static final TeamFragment newInstance(int page) {
        TeamFragment f = new TeamFragment();
        Bundle bdl = new Bundle(1);
        bdl.putInt("page_number", page);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_team, container, false);
//        initButton();
//        initCardView();
//        initFloatingActionButton();
        return view;
    }
}
