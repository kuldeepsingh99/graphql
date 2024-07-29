package com.portal.graphql.repository;

import com.portal.graphql.entity.PostComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComments, Long> {
}
