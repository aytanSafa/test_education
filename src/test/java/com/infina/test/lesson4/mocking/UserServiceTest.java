package com.infina.test.lesson4.mocking;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;


    @Test
    void sendIdReturnUser() {

        //given
       User mockUser = new User();
       mockUser.setId(1L);
       mockUser.setName("John");
       mockUser.setBalance(150.50);

        //when
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        User user = userService.findById(1L);

        //then

        assertNotNull(user);
        assertEquals("John",user.getName());

        verify(userRepository,atLeastOnce()).findById(1L);

    }

    @Test
    void successSave() {
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("John");
        mockUser.setBalance(150.50);

        when(userRepository.findByName("John")).thenReturn(Optional.empty());

        userService.save(mockUser);

        verify(userRepository).save(mockUser);

    }
}
