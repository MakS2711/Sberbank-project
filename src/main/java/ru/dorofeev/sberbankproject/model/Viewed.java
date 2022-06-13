package ru.dorofeev.sberbankproject.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "content_id"})
})
public class Viewed implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viewed_generator")
    @SequenceGenerator(name = "viewed_generator", sequenceName = "viewed_seq")
    Long id;

    @ManyToOne
    Users user;

    @ManyToOne
    Content content;
}
