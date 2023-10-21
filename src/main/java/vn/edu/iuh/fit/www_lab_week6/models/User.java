package vn.edu.iuh.fit.www_lab_week6.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="firstName", length = 50, nullable = false)
    private String firstName;
    @Column(name="middleName", length = 50, nullable = false)
    private String middleName;
    @Column(name="lastName", length = 50, nullable = false)
    private String lastName;
    @Column(name="mobile", length = 15, nullable = false)
    private String mobile;
    @Column(name="lastLogin", nullable = false)
    private Instant lastLogin;
    @Column(name="password_hash", length = 32, nullable = false)
    private String passwordHash;
    @Column(name="intro", columnDefinition = "TINYTEXT", nullable = false)
    private String intro;
    @Column(name="profile", columnDefinition = "TINYTEXT", nullable = false)
    private String profile;
    @Column(name="registerd_at", length = 50, nullable = false)
    private Instant registerdAt;
    @Column(name="email", length = 50, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<PostComment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "author")
    private Set<Post> posts;



}
