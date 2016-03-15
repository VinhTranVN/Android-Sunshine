package vinhtt.example.android_sunshine.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vinhtt.example.android_sunshine.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private TextView mDetailInfo;

    public DetailActivityFragment() {
    }

    public static DetailActivityFragment newInstance() {
        Bundle args = new Bundle();
        DetailActivityFragment fragment = new DetailActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDetailInfo = (TextView) view.findViewById(R.id.detail_info);
    }

    public void updateData(String detailInfo){
        mDetailInfo.setText(detailInfo);
    }
}
