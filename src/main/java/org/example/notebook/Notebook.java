package org.example.notebook;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Notebook {
    @Id
    @GeneratedValue
    @Column(name = "notebook_id")
    int id;

    String model;
    String producer;
    LocalDate date;
    int ram;
    int ssd;

}
