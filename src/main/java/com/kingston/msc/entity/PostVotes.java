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
@Table(name = "post_votes")
@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PostVotes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "registrationId", nullable = false)
    private Long registrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Posts postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_type_id", referencedColumnName = "id", nullable = false)
    private VoteType voteTypeId;

    @Embedded
    private Audit audit;
}
