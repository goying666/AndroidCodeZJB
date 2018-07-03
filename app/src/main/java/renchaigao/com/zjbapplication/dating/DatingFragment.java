package renchaigao.com.zjbapplication.dating;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import renchaigao.com.zjbapplication.R;

/**
 * Created by Administrator on 2018/7/3/003.
 */

public class DatingFragment extends Fragment {
    private View view;
    public Activity mContext;

    public static final DatingFragment newInstance(int page) {
        DatingFragment f = new DatingFragment();
        Bundle bdl = new Bundle(1);
        bdl.putInt("page_number", page);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dating, container, false);

        return view;
    }
}
