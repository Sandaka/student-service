package com.kingston.msc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/16/22
 */
@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment_body", nullable = false)
    private String commentBody;

    @Column(name = "views")
    private int views = 0;

    @Column(name = "comment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "registration_id", nullable = false)
    private Long registrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Posts postId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private Set<CommentVotes> commentVotesSet;

    @Embedded
    private Audit audit;
}
