package securitydemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="is_active")
    private boolean isActive;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user"
    )
    private Set<Authority> authorities;
}
