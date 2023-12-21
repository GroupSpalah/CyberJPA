package org.example.relationships.one_to_one.uni;

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
public class Human {
    @Id
    @GeneratedValue
    @Column(name = "human_id")
    int id;

    String name;

    int age;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "FK_Human_Phone")
    Phone phone;//phone_phone_id
}
