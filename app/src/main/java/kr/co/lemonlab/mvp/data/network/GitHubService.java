package kr.co.lemonlab.mvp.data.network;

import java.util.ArrayList;

import kr.co.lemonlab.mvp.model.GitHubItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubService {
    //https://api.github.com/users/kyeongwan/repos
    @GET("/users/{user_name}/repos")
    Call<ArrayList<GitHubItem>> searchUser(@Path("user_name") String userKeyword);
}