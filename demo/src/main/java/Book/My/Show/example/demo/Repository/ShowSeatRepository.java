package Book.My.Show.example.demo.Repository;

import Book.My.Show.example.demo.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<Long, ShowSeat> {
}
