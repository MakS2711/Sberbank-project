package ru.dorofeev.sberbankproject.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "page_generator")
    @SequenceGenerator(name = "page_generator", sequenceName = "page_seq")
    Long id;

    @Column(unique = true)
    @NotNull(message = "The field should not be null!")
    @NotBlank(message = "The field should not be empty!")
    String name;

    @ManyToMany
    @JoinTable(
            name = "content_page",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "page_id")
    )
    @ToString.Exclude
    Set<Content> contentList;
}
