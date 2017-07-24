package kr.co.lemonlab.mvp.data.network;

import java.util.ArrayList;

import kr.co.lemonlab.mvp.model.GitHubItem;
import retrofit2.Call;
import retrofit2.Retrofit;

public class RetrofitGitHub {

    private GitHubService gitHubService;

    private static RetrofitGitHub retrofitGitHub;

    public static RetrofitGitHub getInstance() {
        if (retrofitGitHub == null) {
            synchronized (RetrofitGitHub.class) {
                if (retrofitGitHub == null) {
                    retrofitGitHub = new RetrofitGitHub();
                }
            }
        }
        return retrofitGitHub;
    }

    private RetrofitGitHub() {
        Retrofit retrofit = RetrofitCreator.createRetrofit();
        gitHubService = retrofit.create(GitHubService.class);
    }

    /**
     * Retrofit Search url
     */
    public Call<ArrayList<GitHubItem>> searchGitHubUser(String userKeyword) {
        return gitHubService.searchUser(userKeyword);
    }
}