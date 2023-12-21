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
@ToString
@Table(name = "SGroup")
public class Group {
    @Id
    @GeneratedValue
    @Column(name = "group_id")
    int id;

    String name;

    int age;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "group")
    Praestor praestor;
}
