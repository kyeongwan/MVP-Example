package kr.co.lemonlab.mvp.adapter;

import java.util.ArrayList;

import kr.co.lemonlab.mvp.model.GitHubItem;

/**
 * Created by lk on 2017. 7. 22..
 */

public interface ListAdaptercontract {

    interface View{
        void notifyAdapter();
        android.view.View.OnClickListener onClickFunc = null;
    }

    interface Model {
        void addItem(ArrayList<GitHubItem> items);
        void clearItems();
        GitHubItem getItem(int position);
    }
}
