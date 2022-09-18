package com.kingston.msc.service.impl;

import com.kingston.msc.entity.PostTags;
import com.kingston.msc.repository.PostTagsRepository;
import com.kingston.msc.service.PostTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 9/8/22
 */
@Service
@Transactional
public class PostTagsServiceImpl implements PostTagsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PostTagsRepository postTagsRepository;

    @Override
    public List<PostTags> savePostsTags(List<PostTags> postTagsList) {
        return postTagsRepository.saveAll(postTagsList);
    }
}
