package Book.My.Show.example.demo.Repository;

import Book.My.Show.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Long, User> {

}
