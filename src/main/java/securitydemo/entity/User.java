package securitydemo.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
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
