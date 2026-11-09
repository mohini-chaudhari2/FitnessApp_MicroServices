package com.fitness.userservice.userService;

import com.fitness.userservice.UserRepo.UserRepository;
import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.models.User;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public  UserResponse register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email alredy exist");
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFistName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());
        return userResponse;
    }

    public @Nullable UserResponse getUserProfile(String userid) {

        User user = userRepository.findById(userid)
                .orElseThrow(()->new RuntimeException("User not found"));

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        userResponse.setLastName(user.getLastName());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        userResponse.setCreatedAt(user.getCreatedAt());
        return userResponse;

    }
}
