package Book.My.Show.example.demo.Service;

import Book.My.Show.example.demo.Dto.BookingRequestDto;
import Book.My.Show.example.demo.Exception.UserNotFoundException;
import Book.My.Show.example.demo.Repository.ShowRepository;
import Book.My.Show.example.demo.Repository.ShowSeatRepository;
import Book.My.Show.example.demo.Repository.UserRepository;
import Book.My.Show.example.demo.models.*;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookingService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public BookingTicket bookTicket(BookingRequestDto request) throws UserNotFoundException {
      Long userId=  request.getUserId();
      Long showId=request.getShowId();
      List<Long>showSeatId=request.getShowSeatId();

          Optional<User>user= userRepository.findById(userId);
          if(user.isEmpty())
          {
              throw new UserNotFoundException();
          }
          Optional<BMSShow>show=showRepository.findById(showId);
          List<ShowSeat>showSeats=showSeatRepository.findAllById(showSeatId);
          boolean s=reserve(showSeats);
          BookingTicket b=new BookingTicket();
          b.setBookingId(UUID.randomUUID());
          b.setBillAmount(calculation(showSeats));
          b.setBmsShow(show.get());
          b.setShowSeat(showSeats);
          b.setUser(user.get());
          b.setBookingStatus(BookingStatus.Booked);
          return b;


    }

    public Integer calculation(List<ShowSeat>showSeats)
    {
        Integer amount=0;
        for(int i=0;i<showSeats.size();i++)
        {
            Seats seats=showSeats.get(i).getSeats();
            if(seats.getSeatType().equals(SeatType.MahaRaja))
            {
                amount+=100;
            } else if (seats.getSeatType().equals(SeatType.Queen)) {
                amount+=50;
            } else if (seats.getSeatType().equals(SeatType.Shouldgers)) {
                amount+=30;
            }

        }
        return amount;
    }
    @Transactional(isolation=Isolation.SERIALIZABLE)
    public boolean reserve(List<ShowSeat>showSeats)
    {
        for(int i=0;i<showSeats.size();i++)
        {
            if(showSeats.get(i).getShowSeatStatus().equals(ShowSeatStatus.Locked))
            {
               Duration k= Duration.between(showSeats.get(i).getLocakedAt(), LocalTime.now());
               if(k.toMinutes()>10)
               {
                   showSeats.get(i).setLocakedAt(LocalTime.now());
               }
               else {
                   throw new RuntimeException("These Seat is Already Locked");
               }
            } else if (showSeats.get(i).getShowSeatStatus().equals(ShowSeatStatus.Available)) {
                showSeats.get(i).setShowSeatStatus(ShowSeatStatus.Locked);
                showSeats.get(i).setLocakedAt(LocalTime.now());
            } else if (showSeats.get(i).getShowSeatStatus().equals(ShowSeatStatus.Booked)) {
                throw new RuntimeException("It is already Booked");
            }
        }

        return true;
    }
}
