package pl.sweetprezenty.v1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column
    private String email;

    @Column(name = "client_name")
    private String name;
    @Column(name = "client_surname")
    private String surname;
}
