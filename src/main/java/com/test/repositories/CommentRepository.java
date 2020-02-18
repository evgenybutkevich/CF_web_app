package com.test.repositories;

import com.test.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    Iterable<Comment> findByPath(Integer path);

}
