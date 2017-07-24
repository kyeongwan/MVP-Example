package kr.co.lemonlab.mvp.view.presenter;

import android.content.Context;

import java.util.ArrayList;

import kr.co.lemonlab.mvp.adapter.ListAdapter;
import kr.co.lemonlab.mvp.adapter.ListAdaptercontract;
import kr.co.lemonlab.mvp.data.DataSource;
import kr.co.lemonlab.mvp.model.GitHubItem;

/**
 * Created by lk on 2017. 7. 22..
 */

public class MainPresenter implements MainContract.Presenter{


    public MainContract.View view;
    public ListAdaptercontract.Model adapterModel;
    public ListAdaptercontract.View adapterView;
    public ListAdapter adapter;
    public DataSource dataSource;

    public MainPresenter(MainContract.View view, ListAdapter adapter, DataSource dataSource) {
        this.view = view;
        this.adapterModel = adapter;
        this.adapterView = adapter;
        this.adapter = adapter;
        this.dataSource = dataSource;
    }




    @Override
    public void loadItems(Context context, String userId) {
        view.showProgress();
        dataSource.getDatas(context, userId, new DataSource.LoadDataCallBack() {
            @Override
            public void onLoadData(ArrayList<GitHubItem> list) {
                adapter.clearItems();
                adapter.addItem(list);
                adapter.notifyAdapter();
                view.dismissProgress();
            }

            @Override
            public void onFailData(String errorMsg) {
                view.dismissProgress();
                view.showMessage(errorMsg);
            }
        });
    }


}
