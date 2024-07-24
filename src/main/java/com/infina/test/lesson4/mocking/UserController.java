package com.infina.test.lesson4.mocking;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    ResponseEntity<User> findUserById(@PathVariable long userId){
        return ResponseEntity.ok(userService.findById(userId));
    }
}
