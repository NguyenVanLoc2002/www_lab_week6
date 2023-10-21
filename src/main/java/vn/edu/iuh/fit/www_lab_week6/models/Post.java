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
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", length = 75, nullable = false)
    private String title;
    @Lob
    @Column(name = "content", columnDefinition = "TINYTEXT", nullable = false)
    private String content;
    @Column(name = "published", columnDefinition = "BIT(1)", nullable = false)
    private Boolean published;
    @Column(name = "meta_title", length = 100, nullable = false)
    private String metaTitle;
    @Column(name = "summary", columnDefinition = "TINYTEXT", nullable = false)
    private String summary;
    @Column(name = "crreated_at", nullable = false)
    private Instant crreatedAt;
    @Column(name = "update_at", nullable = false)
    private Instant updateAt;
    @Column(name = "pulished_at", nullable = false)
    private Instant pulishedAt;

    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private User author;

    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments =new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "parent_id",nullable = false)
    private Post parent;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts= new LinkedHashSet<>();
}
