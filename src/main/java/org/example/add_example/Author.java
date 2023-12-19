package org.example.add_example;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Table(name = "New_Author")
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "author_id")
    int id;//author_id

    @Column(length = 50, unique = true)
    String name;//VARCHAR(50)

    @Enumerated(EnumType.STRING)
    Genre genre;

    int age;
}
