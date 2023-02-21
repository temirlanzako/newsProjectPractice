package first_project_practice_news.first_project_practice.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
public class Permission extends BaseEntity implements GrantedAuthority {

    private String name;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
