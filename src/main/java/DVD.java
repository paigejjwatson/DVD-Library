import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DVD {

    private String title;
    private LocalDate releaseDate;
    private String rating;
    private String director;
    private String studio;
    private String userReview;

//    enum MPAARating {
//        G,
//        PG,
//        PG13,
//        R,
//        NC17
//    }

}

