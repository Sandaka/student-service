package com.kingston.msc.repository;

import com.kingston.msc.entity.PostTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 9/8/22
 */
@Repository
public interface PostTagsRepository extends JpaRepository<PostTags, Long> {
}
