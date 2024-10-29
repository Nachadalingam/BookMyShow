package Book.My.Show.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private int screenNo;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<ScereenFeature>screenFeatures;

    @OneToMany
    private List<Seats>seatsList;
}
