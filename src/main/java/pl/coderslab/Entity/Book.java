package pl.coderslab.Entity;

import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5)
    private String title;

    private String author;
    @Size(min = 5 , max = 600)
    private String description;
    @NotNull
    @ManyToOne
    private Publisher publisher;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors;


}
