package com.nie.servlet;

import com.nie.pojo.Books;
import com.nie.service.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    private BooksServiceImpl booksServiceImpl;

    @RequestMapping({"/","/login"})
    public String login(HttpServletRequest request,Model model) throws UnsupportedEncodingException {
        String username = "";
        String password = "";
        String ischecked = "";

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie:cookies) {
                if(cookie.getName().equals("Username") || cookie.getName().equals("Password")){
                    if(cookie.getName().equals("Username")){
                        username = URLDecoder.decode(cookie.getValue(),"utf-8");
                        ischecked = "checked";
                    }else if(cookie.getName().equals("Password")){
                        password = cookie.getValue();
                    }
                }
            }
        }
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        model.addAttribute("ischecked",ischecked);
        return "/pages/samples/login";
    }

    @RequestMapping("/toLogin")
    public String toLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Model model,
                          HttpServletRequest request,
                          HttpServletResponse response) throws UnsupportedEncodingException {

        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",username);

            Cookie username_cookie = new Cookie("Username", URLEncoder.encode(username,"utf-8"));
            Cookie password_cookie = new Cookie("Password", URLEncoder.encode(password,"utf-8"));
            if("yes".equals(request.getParameter("remember"))){
                username_cookie.setMaxAge(10*60);
                password_cookie.setMaxAge(10*60);
            }else{
                username_cookie.setMaxAge(0);
                password_cookie.setMaxAge(0);
            }
            response.addCookie(username_cookie);
            response.addCookie(password_cookie);

            return "redirect:index";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "forward:login";
        }

    }

    @RequestMapping("/index")
    public String index(Model model){

        List<Books> booksList =  booksServiceImpl.selectAll();
        model.addAttribute("booksList",booksList);
        return "index";
    }

    @RequestMapping({"/register"})
    public String register(){

        return "/pages/samples/register";
    }

    @RequestMapping("/recommend")
    public String recommend(){

        return "/pages/samples/recommend";
    }

    @RequestMapping("/rankList")
    public String rankList(){

        return "/pages/samples/rankList";
    }

    @RequestMapping("/chineseBooks")
    public String chineseBooks(){

        return "/pages/samples/chineseBook";
    }

    @RequestMapping("/foreignBooks")
    public String foreignBooks(){

        return "/pages/samples/foreignBook";
    }

    @RequestMapping("/toLogout")
    public String toLogout(HttpSession session){
        session.removeAttribute("loginUser");
        return "redirect:/login";
    }

    @RequestMapping("/404.do")
    public String notFoundError(){

        return "pages/samples/error-404";
    }

/*    @RequestMapping("/500.do")
    public String serverError(){

        return "pages/samples/error-500";
    }*/
}
