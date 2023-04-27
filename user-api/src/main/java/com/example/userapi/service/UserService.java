package com.example.userapi.service;

import com.example.userapi.dto.request.UserRequest;
import com.example.userapi.model.User;
import com.example.userapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    //salvar usuário
    public Mono<User> salvar (UserRequest userRequest){
        User userSave = User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
        return userRepository.save(userSave);
    }

    // buscar todos
    public Flux<User> buscar (){
        return userRepository.findAll();
    }
    //findById

    public Mono<User> buscarPorId (String id){
        return userRepository.findById(id);
    }


}
