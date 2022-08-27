package com.kingston.msc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/16/22
 */
@Entity
@Table(name = "vote_type")
@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VoteType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type_name", nullable = false)
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private Set<PostVotes> postVotesSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private Set<CommentVotes> commentVotesSet;

    @Embedded
    private Audit audit;
}
