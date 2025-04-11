package co.id.middleware.libraryproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BorrowData {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Getter
    private UUID id;

    @Getter
    @Setter
    private UUID bookId;

    @Getter
    @Setter
    private String bookName;

    @Getter
    @Setter
    private String loanName;

    @Getter
    @Setter
    private String loanAddress;

    @Getter
    @Setter
    private String loanStatus;

    @Getter
    @Setter
    private Date loanDate;

    @Getter
    @Setter
    private Date loanReturnDate;

    @Getter
    @Setter
    private Date createdDate;

    @Getter
    @Setter
    private Date updatedDate;
}
