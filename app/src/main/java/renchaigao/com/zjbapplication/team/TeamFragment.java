package renchaigao.com.zjbapplication.team;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import renchaigao.com.zjbapplication.R;
import renchaigao.com.zjbapplication.json.TeamInfo;


public class TeamFragment extends Fragment {

    protected static String TAG = "TeamFragment";
    private View view;
    public Activity mContext;
    private List<TeamInfo> teamClassesList = new ArrayList<>();
    private RecyclerView recyclerView;

    public static final TeamFragment newInstance(int page) {
        TeamFragment f = new TeamFragment();
        Bundle bdl = new Bundle(1);
        bdl.putInt("page_number", page);
        f.setArguments(bdl);
        return f;
    }

    private TabLayout mTablayout;
    private ViewPager viewPager;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_team, container, false);

//        viewPager = view.findViewById(R.id.team_viewPager);
//        if (viewPager != null) {
//            setupViewPager(viewPager);
//            viewPager.setOffscreenPageLimit(2);
//        }
//        mTablayout = view.findViewById(R.id.team_tabLayout);
//        mTablayout.setTabTextColors(ColorStateList.valueOf(R.color.text_color));
//        mTablayout.setSelectedTabIndicatorColor(R.color.text_color);
//        mTablayout.setupWithViewPager(viewPager);

        initCardView();
//        initButton();
//        initCardView();
//        initFloatingActionButton();
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getFragmentManager());
//        recommendFragment = new RecommendFragment();
//        recommendFragment.setChanger(this);
//        adapter.addFragment(recommendFragment, "新曲");
        viewPager.setAdapter(adapter);
    }
    private void initCardView() {
        for (Integer i = 0; i < 16; i++) {
            TeamInfo teamClass = new TeamInfo();
            teamClass.setTeam_boy_number(1);
            teamClass.setTeam_cardview_place(i.toString());
            teamClassesList.add(teamClass);
            Log.e(TAG, "i is : " + i);
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.team_page_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(linearLayoutManager);

        teamClassAdapter adapter_cardview = new teamClassAdapter(teamClassesList);
        recyclerView.setAdapter(adapter_cardview);

    }
    static class Adapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    class teamClassAdapter extends RecyclerView.Adapter<teamClassAdapter.ViewHolder> {

        private List<TeamInfo> teamClassesList;

        public class ViewHolder extends RecyclerView.ViewHolder {
            View teamClassView;
            TextView team_boy_number,
                    team_girl_number,
                    team_cardview_name,
                    team_cardview_style,
                    team_cardview_place,
                    team_place_howlong,
                    my_team_cardview_people_number,
                    team_start_date,
                    team_start_time,
                    team_lave_time,
                    team_tips,
                    team_shop_info;
            ImageView team_image;
            RatingBar place_star_num;

            public ViewHolder(View itemView) {
                super(itemView);
                teamClassView = itemView;
                team_boy_number = itemView.findViewById(R.id.team_boy_number);
                team_girl_number = itemView.findViewById(R.id.team_girl_number);
                team_image = itemView.findViewById(R.id.team_image);
                team_cardview_name = itemView.findViewById(R.id.team_cardview_name);
                team_cardview_style = itemView.findViewById(R.id.team_cardview_style);
                team_cardview_place = itemView.findViewById(R.id.team_cardview_place);
                team_place_howlong = itemView.findViewById(R.id.team_place_howlong);
                my_team_cardview_people_number = itemView.findViewById(R.id.my_team_cardview_people_number);
                team_start_date = itemView.findViewById(R.id.team_start_date);
                team_start_time = itemView.findViewById(R.id.team_start_time);
                team_lave_time = itemView.findViewById(R.id.team_lave_time);
                team_tips = itemView.findViewById(R.id.team_tips);
                place_star_num = itemView.findViewById(R.id.place_star_num);
                team_shop_info = itemView.findViewById(R.id.team_shop_info);
            }
        }

        public teamClassAdapter(List<TeamInfo> teamClasseslist) {
            teamClassesList = teamClasseslist;
        }

        @Override
        public teamClassAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_team_card_view, parent, false);
            final teamClassAdapter.ViewHolder holder = new teamClassAdapter.ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(teamClassAdapter.ViewHolder holder, int position) {
            TeamInfo teamClass = teamClassesList.get(position);

//        holder.team_boy_number.setText(teamClass.getTeam_boy_number());
//        holder.team_girl_number.setText(teamClass.getTeam_girl_number());
//        holder.team_image.setImageResource(R.drawable.place_1);
//        holder.team_cardview_name.setText(teamClass.getTeam_cardview_name());
//        holder.team_cardview_style.setText(teamClass.getTeam_cardview_style());
            holder.team_cardview_place.setText(teamClass.getTeam_cardview_place());
//        holder.team_place_howlong.setText(teamClass.getTeam_place_howlong());
//        holder.my_team_cardview_people_number.setText(teamClass.getMy_team_cardview_people_number());
//        holder.team_start_date.setText(teamClass.getTeam_start_date());
//        holder.team_start_time.setText(teamClass.getTeam_start_time());
//        holder.team_lave_time.setText(teamClass.getTeam_lave_time());
//        holder.team_tips.setText(teamClass.getTeam_tips());
//        holder.place_star_num.setNumStars(teamClass.getPlace_star_num());
//        holder.team_shop_info.setText(teamClass.getTeam_shop_info());
        }

        @Override
        public int getItemCount() {
            return teamClassesList.size();
        }

    }
}
