package org.example.zizonsecurity.domain;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "roles")
@Getter
public class Role {
    private Long Id;
    private String name;
}
