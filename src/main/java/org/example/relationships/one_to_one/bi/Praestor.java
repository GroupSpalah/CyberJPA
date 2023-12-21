package org.example.relationships.one_to_one.bi;

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
@ToString(exclude = "group")
public class Praestor {
    @Id
    @GeneratedValue
    @Column(name = "praestor_id")
    int id;

    String name;

    @OneToOne
    @JoinColumn(name = "FK_Praestor_Group")
    Group group;
}
