package Book.My.Show.example.demo.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequestDto {
    private Long userId;
    private List<Long>showSeatId;
    private Long showId;
}
