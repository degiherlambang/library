package co.id.middleware.libraryproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Getter
    private UUID id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String author;

    @Getter
    @Setter
    private Date publishDate;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Date createdDate;

}
