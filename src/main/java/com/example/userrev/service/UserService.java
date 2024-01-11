package com.example.userrev.service;

import com.example.userrev.Model.User;
import com.example.userrev.dto.UserDto;
import com.example.userrev.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

   @Autowired
   private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createUser(@Valid UserDto userDto){
        User user = User.build(0,userDto.getName(),userDto.getAge(),userDto.getEmail(),userDto.getPhoneNumber());
        return userRepository.save(user);
    }

    public List<User> getUserList(){

        return userRepository.findAll();
    }

    public Optional<User> findUserById(long id){
        return userRepository.findById(id);
    }


    public Map<String,String> deleteUserById(long id) {
        try{
        userRepository.deleteById(id);
        return Map.of ("messsage:","id deleted");
    }catch (Exception e){
            e.getMessage();
            e.printStackTrace();

        }
        return Map.of("message:","id not found");

        }
}
