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
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Posts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "views")
    private int views = 0;

    @Column(name = "post_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "registration_id", nullable = false)
    private Long registrationId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private Set<Comments> commentsSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private Set<PostVotes> postVotesSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private Set<PostTags> postTagsSet;

    @Embedded
    private Audit audit;
}
