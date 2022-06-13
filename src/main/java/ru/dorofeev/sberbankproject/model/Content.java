package ru.dorofeev.sberbankproject.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Content implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "content_generator")
    @SequenceGenerator(name = "content_generator", sequenceName = "content_seq")
    Long id;

    @ManyToMany(mappedBy = "contentList")
    @ToString.Exclude
    Set<Page> pageList;
}
