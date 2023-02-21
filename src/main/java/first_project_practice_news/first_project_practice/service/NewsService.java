package first_project_practice_news.first_project_practice.service;

import first_project_practice_news.first_project_practice.model.News;
import first_project_practice_news.first_project_practice.model.User;
import first_project_practice_news.first_project_practice.repository.NewsRepository;
import first_project_practice_news.first_project_practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final UserRepository userRepository;

    private final UserService userService;

    public void addNews(News news, Long id) {
        News n = new News();
        n.setTitle(news.getTitle());
        n.setContent(news.getContent());
        n.setUser(userService.getUser(id));
        newsRepository.save(n);
        /*News news = new News();
        news.setTitle(title);
        news.setContent(content);
        news.setUser(userRepository.findById(id).orElseThrow());
        newsRepository.save(news);*/
    }

    public List<News> getAllNews() {
        List<News> news = newsRepository.findAll();
        return news;
    }
}
