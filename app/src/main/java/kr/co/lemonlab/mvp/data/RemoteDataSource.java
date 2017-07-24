package kr.co.lemonlab.mvp.data;


import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import kr.co.lemonlab.mvp.data.network.RetrofitGitHub;
import kr.co.lemonlab.mvp.model.GitHubItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lk on 2017. 7. 22..
 */

public class RemoteDataSource implements DataSource {

    @Override
    public void getDatas(Context context, String keyword, final LoadDataCallBack callBack) {
        RetrofitGitHub retrofitGitHub = RetrofitGitHub.getInstance();

        final Call<ArrayList<GitHubItem>> gitHubUserCall = retrofitGitHub.searchGitHubUser(keyword);
        gitHubUserCall.enqueue(new Callback<ArrayList<GitHubItem>>() {
            @Override
            public void onResponse(Call<ArrayList<GitHubItem>> call, Response<ArrayList<GitHubItem>> response) {
                ArrayList<GitHubItem> gitHubUserResponse = response.body();
                if (gitHubUserResponse != null) {
                    Log.d("RemoteDataSource", gitHubUserResponse.toString());
                    callBack.onLoadData(gitHubUserResponse);
                    return;
                }
                callBack.onFailData("데이터가 없습니다.");
            }

            @Override
            public void onFailure(Call<ArrayList<GitHubItem>> call, Throwable t) {
                callBack.onFailData(t.getMessage());
                Log.e("RemoteDataSource", t.getMessage());
            }
        });
    }

}
