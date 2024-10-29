package Book.My.Show.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seats extends BaseModel{

    private long seatNo;

    @ManyToOne
    private SeatType seatType;

    private int rowNumber;

    private int colNumber;

}
