package kr.co.lemonlab.mvp.view.presenter;

import android.content.Context;

/**
 * Created by lk on 2017. 7. 22..
 */

public interface MainContract {

    interface View {
        void showProgress();
        void showMessage(String msg);
        void dismissProgress();
    }

    interface Presenter {
        void loadItems(Context context, String userId);
    }
}
