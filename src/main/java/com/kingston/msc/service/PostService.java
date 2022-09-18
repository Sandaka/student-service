package com.kingston.msc.service;

import com.kingston.msc.entity.Posts;
import com.kingston.msc.model.PostRegistrationStudent;

import java.util.List;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 9/8/22
 */
public interface PostService {

    Posts savePost(PostRegistrationStudent postRegistrationStudent);

    List<PostRegistrationStudent> getAllPosts();
}
