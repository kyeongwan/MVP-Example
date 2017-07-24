package kr.co.lemonlab.mvp.data;

import android.content.Context;

import java.util.ArrayList;

import kr.co.lemonlab.mvp.model.GitHubItem;

/**
 * Created by lk on 2017. 7. 22..
 */

public interface DataSource {

    interface LoadDataCallBack {
        void onLoadData(ArrayList<GitHubItem> list);
        void onFailData(String errorMsg);
    }

    void getDatas(Context context, String keyword, LoadDataCallBack callBack);

}
