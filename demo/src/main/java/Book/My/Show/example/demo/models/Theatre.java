package Book.My.Show.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;

     @OneToMany
    private List<Screen>screenList;

    @OneToMany
    private Region region;


}
