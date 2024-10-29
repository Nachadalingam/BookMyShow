package Book.My.Show.example.demo.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Movie {
    private String movieName;
    private int year;
    private Date movieReleseDate;
    private String descrpion;
    private String rating;
}
