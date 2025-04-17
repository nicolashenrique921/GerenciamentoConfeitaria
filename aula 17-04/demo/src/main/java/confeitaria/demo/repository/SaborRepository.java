package confeitaria.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import confeitaria.demo.model.Sabor;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {
}

