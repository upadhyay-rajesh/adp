package com.rkcpinfo.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.rkcpinfo.model.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

}