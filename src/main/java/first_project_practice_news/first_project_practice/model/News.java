package first_project_practice_news.first_project_practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class News extends BaseEntity{

    private String title;
    private String content;
    @ManyToOne
    private User user;
}
