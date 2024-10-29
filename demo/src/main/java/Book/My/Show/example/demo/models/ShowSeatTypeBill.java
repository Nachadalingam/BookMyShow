package Book.My.Show.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatTypeBill extends BaseModel {
    @ManyToOne
    private BMSShow show;
    @ManyToOne
    private SeatType seatType;

    private int amount;

}
