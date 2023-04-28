package com.example.userapi.service;

import com.example.userapi.dto.request.UserRequest;
import com.example.userapi.model.User;
import com.example.userapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    //salvar usuário
    public Mono<User> salvar (UserRequest userRequest){
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
        return userRepository.save(user);
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
