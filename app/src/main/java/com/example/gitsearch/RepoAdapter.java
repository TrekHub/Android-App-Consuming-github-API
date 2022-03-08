package com.example.gitsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gitsearch.model.Item;

import java.util.List;

public class RepoAdapter extends BaseAdapter {
    private Context mContext;
    private List<Item> items;

    public RepoAdapter(Context applicationContext, List<Item> itemArrayList) {
        this.mContext = applicationContext;
        this.items = itemArrayList;

    }

    @Override
    public int getCount() {
        return items.size();
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

        if (view == null) {
            listView = inflater.inflate(R.layout.repo_card, null);

            TextView repoName = (TextView) listView
                    .findViewById(R.id.repo_name);
            repoName.setText(items.get(i).getName());

            TextView repoDescription = (TextView) listView.findViewById(R.id.repo_description);
            repoDescription.setText(items.get(i).getDescription());
        } else {
            listView = (View) view;
        }
        return listView;
    }
}
