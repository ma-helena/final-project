package com.example.userapi.repository;

import com.example.userapi.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findById (String id);

    //checar se usuário existe
}
