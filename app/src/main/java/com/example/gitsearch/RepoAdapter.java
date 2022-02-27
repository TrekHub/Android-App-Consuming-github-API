package com.example.gitsearch;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RepoAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mRepoNames;

    public RepoAdapter(Context mContext, String[] mRepoNames) {
        this.mContext = mContext;
        this.mRepoNames = mRepoNames;
    }

    @Override
    public int getCount() {
        return mRepoNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listView;

        if(view == null){
            listView = inflater.inflate(R.layout.repo_card, null);

            TextView repoName = (TextView) listView
                    .findViewById(R.id.repo_name);
            repoName.setText(mRepoNames[i]);
        } else {
            listView = (View) view;
        }
        return listView;
    }
}
