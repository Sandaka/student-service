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
@Table(name = "tags")
@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tags implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tag_name", nullable = false)
    private String tagName;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private Set<PostTags> postTagsSet;

    @Embedded
    private Audit audit;
}
