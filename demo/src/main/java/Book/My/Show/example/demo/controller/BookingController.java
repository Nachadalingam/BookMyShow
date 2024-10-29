package Book.My.Show.example.demo.controller;

import Book.My.Show.example.demo.Dto.BookingRequestDto;
import Book.My.Show.example.demo.Dto.BookingResponseDto;
import Book.My.Show.example.demo.Exception.UserNotFoundException;
import Book.My.Show.example.demo.Service.BookingService;
import Book.My.Show.example.demo.models.BookingTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private BookingService bookingService;
    public BookingResponseDto bookTicket(BookingRequestDto request)
    {
        try {
            BookingTicket bookingTicket=bookingService.bookTicket(request);
            return new BookingResponseDto(bookingTicket.getId(),bookingTicket.getBillAmount(),"Success");
        } catch (UserNotFoundException e) {
            return new BookingResponseDto(0l,0,"Failed");
        }
    }
}
