package first_project_practice_news.first_project_practice.controller;

import first_project_practice_news.first_project_practice.model.News;
import first_project_practice_news.first_project_practice.model.User;
import first_project_practice_news.first_project_practice.service.NewsService;
import first_project_practice_news.first_project_practice.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final NewsService newsService;
    private final UserService userService;

    @GetMapping(value = "/home")
    public String index(Model model) {

        List<News> news = newsService.getAllNews();
        model.addAttribute("news", news);
        return "/home";
    }

    @GetMapping(value="/signin")
    public String signIn(){
        return "/signin";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile(Model model){
        model.addAttribute("currentUser", getUser());
        return "/profile";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/add")
    public String add(){
        return "/add";
    }
    @PostMapping(value = "/add")
    public String addNews(@RequestParam(name="id") Long id,
                          News news) {
        /*newsService.addNews(news, userService.getUser(id));*/
        return "redirect:/profile";
    }

    private User getUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            return user;
        }
        return null;
    }
}
