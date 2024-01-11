package com.example.userrev;

import com.example.userrev.Model.User;
import com.example.userrev.repository.UserRepository;
import com.example.userrev.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest
class UserRevApplicationTests {
    @Autowired
     UserRepository userRepository;
    @MockBean
    UserService userService;

    @Test
    void contextLoads() {
    }
    @Test
    public void testSave(){
        User user =  User.build(1l,"shola",20,"ifeanyi@gmail.com", "+234");
        User user1=userRepository.save(user);
        Long id=user.getUserId();


        assertNotNull(user);
        assertEquals("shola",user1.getName());

    }
@Test
public void getAllServiceTest(){
   when( userService.getUserList()).thenReturn(
           List.of(User.build(1l,"mercy",20,"mercy@gmail.com", "+234"),
           User.build(2l,"femi",20,"femi@gmail.com", "+234"),
           User.build(4l,"shola",20,"shola@gmail.com", "+234")));
   assertEquals(3,userService.getUserList().size());
   assertEquals(20,userService.getUserList().get(0).getAge());
}
public void getUserId(){
        User user =  User.build(1l,"mercy",20,"mercy@gmail.com", "+234");
        when(userService.findUserById(1l))
                .thenReturn(Optional.of(user));
        assertEquals(user,userService.findUserById(1l));

}

}
