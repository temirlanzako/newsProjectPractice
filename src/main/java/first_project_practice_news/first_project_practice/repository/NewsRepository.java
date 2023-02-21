package first_project_practice_news.first_project_practice.repository;

import first_project_practice_news.first_project_practice.model.News;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Long> {

}
