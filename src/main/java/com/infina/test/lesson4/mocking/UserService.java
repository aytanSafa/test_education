package com.infina.test.lesson4.mocking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    public User findById(long id){
        Optional<User> userOpt = userRepository.findById(id);
        return userOpt.orElseThrow(() -> new RuntimeException("User does not exist"));
    }

    public void save(User user) {
        Optional<User> optionalUser = userRepository.findByName(user.getName());
        if (optionalUser.isPresent())
            throw new RuntimeException("User already exist");
        userRepository.save(user);
    }







}
