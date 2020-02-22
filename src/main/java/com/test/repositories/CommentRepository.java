package com.test.repositories;

import com.test.entities.Campaign;
import com.test.entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    Iterable<Comment> findByRecipient(Campaign recipient);

}
