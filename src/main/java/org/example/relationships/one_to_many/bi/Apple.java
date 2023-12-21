package org.example.relationships.one_to_many.bi;

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
public class Apple {
    @Id
    @GeneratedValue
    @Column(name = "apple_id")
    int id;

    int size;

    @ManyToOne
    @JoinColumn(name = "FK_Apple_Tree")
    Tree tree;
}
