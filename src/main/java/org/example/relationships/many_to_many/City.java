package org.example.relationships.many_to_many;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class City {
    @Id
    @GeneratedValue
    @Column(name = "city_id")
    int id;

    String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "city_person",
            joinColumns = @JoinColumn(name = "FK_City"),
    inverseJoinColumns = @JoinColumn(name = "FK_Person"))
    List<Person> people;
}