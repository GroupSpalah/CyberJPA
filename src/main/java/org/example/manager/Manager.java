package org.example.manager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Manager {
    @Id
    @GeneratedValue
    @Column(name = "manager_id")
    int id;

    String name;

    int age;
}
