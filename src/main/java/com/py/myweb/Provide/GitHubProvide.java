package com.py.myweb.Provide;

import com.alibaba.fastjson.JSON;
import com.py.myweb.dto.AccessTokenDTO;
import com.py.myweb.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvide {
    public String getAccessToken( AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();


            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string=response.body().string();
                String token=string.split("&")[0].split("=")[1];

                //System.out.println("得到的token是："+token);
                return token;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https:/api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string=response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
