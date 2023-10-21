package vn.edu.iuh.fit.www_lab_week6.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", length = 100, nullable = false)
    private String title;
    @Lob
    @Column(name = "content", columnDefinition = "TINYTEXT", nullable = false)
    private String content;
    @Column(name = "pulished", columnDefinition = "BIT(1)", nullable = false)
    private Boolean pulished;
    @Column(name = "crreated_at", nullable = false)
    private Instant crreatedAt;
    @Column(name = "update_at", nullable = false)
    private Instant updateAt;
    @Column(name = "pulished_at", nullable = false)
    private Instant pulishedAt;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "parent_id",nullable = false)
    private PostComment parent;

    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false)
    private Post post;

    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments =new LinkedHashSet<>();

}
