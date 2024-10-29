package Book.My.Show.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends  BaseModel{
    @ManyToOne
    private BMSShow bmsShow;
    @ManyToOne
    private Seats seats;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;

    private LocalTime LocakedAt;

}
