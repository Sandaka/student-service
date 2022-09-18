package com.kingston.msc.repository;

import com.kingston.msc.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 9/8/22
 */
@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {
}
