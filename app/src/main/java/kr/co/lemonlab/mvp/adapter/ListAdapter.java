package kr.co.lemonlab.mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.lemonlab.mvp.R;
import kr.co.lemonlab.mvp.model.GitHubItem;


/**
 * Created by lk on 2017. 7. 22..
 */

public class ListAdapter extends BaseAdapter implements ListAdaptercontract.Model, ListAdaptercontract.View {

    private ArrayList<GitHubItem> dataList = new ArrayList<>();
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public void addItem(ArrayList<GitHubItem> items) {
        dataList = items;
    }

    @Override
    public void clearItems() {
        dataList = new ArrayList<>();
    }

    @Override
    public GitHubItem getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        }

        TextView tv_name = (TextView)view.findViewById(R.id.tv_name);
        TextView tv_content = (TextView)view.findViewById(R.id.tv_content);

        tv_name.setText(getItem(i).name);
        tv_content.setText(getItem(i).html_url);

        view.setOnClickListener(onClickFunc);
        return view;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }
}
