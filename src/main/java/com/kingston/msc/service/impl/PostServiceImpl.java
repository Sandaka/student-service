package com.kingston.msc.service.impl;

import com.kingston.msc.entity.Audit;
import com.kingston.msc.entity.PostTags;
import com.kingston.msc.entity.Posts;
import com.kingston.msc.entity.Tags;
import com.kingston.msc.model.PostRegistrationStudent;
import com.kingston.msc.model.StudentPostDto;
import com.kingston.msc.repository.PostRepository;
import com.kingston.msc.repository.PostTagsRepository;
import com.kingston.msc.repository.TagsRepository;
import com.kingston.msc.resttemplate.CourseProviderServiceProxy;
import com.kingston.msc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 9/8/22
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostTagsRepository postTagsRepository;

    @Autowired
    private TagsRepository tagsRepository;

    @Autowired
    private CourseProviderServiceProxy courseProviderServiceProxy;


    @Override
    public Posts savePost(PostRegistrationStudent postRegistrationStudent) {

        Posts posts = new Posts();
        Audit audit = new Audit();
        audit.setStatus(1);
        audit.setLastEditDate(new Date());
        audit.setCreatedDate(new Date());

        posts.setAudit(audit);
        posts.setBody(postRegistrationStudent.getBody());
        posts.setFeedback("");
        posts.setPostDate(new Date());
        posts.setRegistrationId(courseProviderServiceProxy.getRegIdBySmsUserId(postRegistrationStudent.getSmsUserId())); //
        posts.setTitle(postRegistrationStudent.getTitle());
        posts.setViews(1);

        Posts saved_posts = postRepository.save(posts);

        List<PostTags> postTagsList = new ArrayList<>();
        if (!postRegistrationStudent.getTagNames().isEmpty()) {

            // get tag ids
            List<Tags> tagsList = tagsRepository.findTagsByTagNameIn(postRegistrationStudent.getTagNames());
            if (!tagsList.isEmpty()) {
                tagsList.forEach(tag -> { // need tag id
                    PostTags postTags = new PostTags();
                    postTags.setAudit(audit);
                    postTags.setPostId(saved_posts);
                    postTags.setTagsId(tag);

                    postTagsList.add(postTags);
                });

                postTagsRepository.saveAll(postTagsList);
            }
        }

        return posts;
    }

    @Override
    public List<PostRegistrationStudent> getAllPosts() {

        List<Posts> postsList = postRepository.findAll(Sort.by(Sort.Direction.DESC, "postDate"));

        List<PostRegistrationStudent> postRegistrationStudentList = new ArrayList<>();
        if (!postsList.isEmpty()) {
            List<StudentPostDto> list = courseProviderServiceProxy.getStudentsByRegIds();
            postsList.forEach(posts -> {
                PostRegistrationStudent postRegistrationStudent = new PostRegistrationStudent();
                postRegistrationStudent.setBody(posts.getBody());
                postRegistrationStudent.setPostDate(posts.getPostDate());
                postRegistrationStudent.setFullName("Sandaka Wijesinghe");
                List<String> tagList = new ArrayList<>();
                tagList.add("Java");
                tagList.add("Spring boot");
                postRegistrationStudent.setTagNames(tagList);
                postRegistrationStudent.setTitle(posts.getTitle());
                postRegistrationStudent.setViews(posts.getViews());

                postRegistrationStudentList.add(postRegistrationStudent);
            });
        }
        return postRegistrationStudentList;
    }
}
