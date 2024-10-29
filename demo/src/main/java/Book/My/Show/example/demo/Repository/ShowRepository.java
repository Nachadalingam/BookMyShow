package Book.My.Show.example.demo.Repository;

import Book.My.Show.example.demo.models.BMSShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Long, BMSShow> {
}
