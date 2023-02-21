package first_project_practice_news.first_project_practice.api;

import first_project_practice_news.first_project_practice.model.News;
import first_project_practice_news.first_project_practice.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@RequiredArgsConstructor
public class NewController {

    private final NewsService newsService;

    @GetMapping(value="/home")
    public List<News> getNews(){
        return newsService.getAllNews();
    }
    @PostMapping
    public void addNews(@RequestBody News news, Long id) {
        newsService.addNews(news, id);
    }
}
