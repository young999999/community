package com.py.myweb.controller;

import com.py.myweb.Provide.GitHubProvide;
import com.py.myweb.domain.AccessTokenDTO;
import com.py.myweb.domain.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {
    @Autowired
    private GitHubProvide gitHubProvide;

    @Value("${github.client.id}")
    private String client_id;
    @Value("${github.client.secret}")
    private String client_secret;
    @Value("${github.redirect.uri}")
    private String client_url;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code" )String code,
                           @RequestParam(name = "state" )String state,
                           HttpServletRequest request) {



        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);//764316e90df9ea61d7d9
        accessTokenDTO.setClient_secret(client_secret);//67863e5878f1e86c4bc2fc1f931e39688dc45fb7
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(client_url);http://localhost:8080/callback
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvide.getAccessToken(accessTokenDTO);
        GithubUser user = gitHubProvide.getUser(accessToken);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            return "redirect:/";
            //sign in success
        }else {
            return "redirect:/";
            //sign in error
        }
    }

}
