package securitydemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="authorities")
public class Authority {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="authority")
    private String authority;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="user_id")
    private User user;
}
