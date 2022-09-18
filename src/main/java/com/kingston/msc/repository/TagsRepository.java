package com.kingston.msc.repository;

import com.kingston.msc.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 9/8/22
 */
@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {

    List<Tags> findTagsByTagNameIn(List<String> tags);
}
