package first_project_practice_news.first_project_practice.repository;

import first_project_practice_news.first_project_practice.model.Permission;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
