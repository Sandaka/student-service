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
@Table(name = "post_tags")
@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PostTags implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Posts postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", referencedColumnName = "id", nullable = false)
    private Tags tagsId;

    @Embedded
    private Audit audit;
}
