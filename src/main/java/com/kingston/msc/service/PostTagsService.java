package com.kingston.msc.service;

import com.kingston.msc.entity.PostTags;

import java.util.List;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 9/8/22
 */
public interface PostTagsService {

    List<PostTags> savePostsTags(List<PostTags> postTagsList);
}
