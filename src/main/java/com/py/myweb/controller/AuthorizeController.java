package com.py.myweb.controller;

import com.py.myweb.Provide.GitHubProvide;
import com.py.myweb.domain.User;
import com.py.myweb.dto.AccessTokenDTO;
import com.py.myweb.dto.GithubUser;
import com.py.myweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GitHubProvide gitHubProvide;
    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String client_id;
    @Value("${github.client.secret}")
    private String client_secret;
    @Value("${github.redirect.uri}")
    private String client_url;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code" )String code,
                           @RequestParam(name = "state" )String state,
                           HttpServletResponse response) {



        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);//764316e90df9ea61d7d9
        accessTokenDTO.setClient_secret(client_secret);//67863e5878f1e86c4bc2fc1f931e39688dc45fb7
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(client_url);http://localhost:8080/callback
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvide.getAccessToken(accessTokenDTO);
        GithubUser githubUser = gitHubProvide.getUser(accessToken);
        if(githubUser!=null&&githubUser.getId()!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountID(String.valueOf(githubUser.getId()));
            user.setGmtCreat(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreat());
            user.setAvatarurl(githubUser.getAvatarurl());
            userMapper.insert(user);
            //登录成功，写cookie和session
            response.addCookie(new Cookie("token",token));

            return "index";//"redirect:/index";
            //sign in success
        }else {
            return "index";//"redirect:/index";
            //sign in error
        }
    }

}
