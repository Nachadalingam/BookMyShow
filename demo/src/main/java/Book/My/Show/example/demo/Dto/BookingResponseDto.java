package Book.My.Show.example.demo.Dto;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
public class BookingResponseDto {
    private Long BookingId;
    private int amount;
    private String message;
}
