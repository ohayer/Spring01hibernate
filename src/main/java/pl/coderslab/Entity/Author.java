package pl.coderslab.Entity;

import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authors")
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
   @PESEL
    private String pesel;
    

}
