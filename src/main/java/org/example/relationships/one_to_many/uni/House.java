package org.example.relationships.one_to_many.uni;

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
public class House {
    @Id
    @GeneratedValue
    @Column(name = "house_id")
    int id;

    int number;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "house_citizen",
            joinColumns = @JoinColumn(name = "FK_House"),
            inverseJoinColumns = @JoinColumn(name = "FK_Citizen"))
    List<Citizen> citizens;
}
