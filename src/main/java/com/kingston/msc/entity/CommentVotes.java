package com.kingston.msc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/16/22
 */
@Entity
@Table(name = "comment_votes")
@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CommentVotes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "registration_id", nullable = false)
    private Long registrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", referencedColumnName = "id", nullable = false)
    private Comments commentsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_type_id", referencedColumnName = "id", nullable = false)
    private VoteType voteTypeId;

    @Embedded
    private Audit audit;
}
