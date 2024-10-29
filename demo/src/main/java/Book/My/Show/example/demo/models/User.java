package Book.My.Show.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.model.TableMapping;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{

    private String name;

    @OneToMany
    private List<BookingTicket> bookingTicketList;

    private String phoneNo;

    private String password;
}
