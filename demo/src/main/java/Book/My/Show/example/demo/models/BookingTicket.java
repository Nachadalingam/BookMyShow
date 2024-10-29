package Book.My.Show.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class BookingTicket extends  BaseModel{

    private UUID bookingId;

    @OneToMany
    private List<Payment> paymentList;

    private Integer billAmount;

    @OneToOne
    private BMSShow bmsShow;

    @OneToMany
    private List<ShowSeat> showSeat;

    @OneToMany
    private User user;

   @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

}
