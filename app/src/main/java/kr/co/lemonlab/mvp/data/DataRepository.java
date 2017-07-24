package kr.co.lemonlab.mvp.data;


import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.lemonlab.mvp.model.GitHubItem;

/**
 * Created by lk on 2017. 7. 22..
 */

public class DataRepository implements DataSource{

    private RemoteDataSource remoteDataSource = new RemoteDataSource();
    private HashMap<String, ArrayList<GitHubItem>> cacheMap = new HashMap<>();

    @Override
    public void getDatas(Context context, final String keyword, final LoadDataCallBack callBack) {
        if (cacheMap.containsKey(keyword)) {
            callBack.onLoadData(cacheMap.get(keyword));
            return;
        }

        remoteDataSource.getDatas(context, keyword, new LoadDataCallBack() {
            @Override
            public void onLoadData(ArrayList<GitHubItem> list) {
                cacheMap.put(keyword, list);
                callBack.onLoadData(list);
            }

            @Override
            public void onFailData(String errorMsg) {
                callBack.onFailData(errorMsg);
            }
        });
    }
}
