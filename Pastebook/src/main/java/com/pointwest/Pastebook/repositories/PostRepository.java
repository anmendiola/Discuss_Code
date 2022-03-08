package com.pointwest.Pastebook.repositories;

import com.pointwest.Pastebook.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Object> {
}
