package Book.My.Show.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BMSShow extends BaseModel{
    @ManyToOne
    private Screen screen;

    private String startTime;

    private String endTime;

    @ManyToMany
    private Movie movie;

}
