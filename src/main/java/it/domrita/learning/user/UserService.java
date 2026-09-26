package it.domrita.learning.user;

import it.domrita.learning.user.dto.CreateUserRequest;
import it.domrita.learning.user.dto.UserResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Transactional
    public UserResponse create( CreateUserRequest request){

        if(!userRepository.existsByEmail(request.email()))
        {User user= new User(request.name(),request.email());
          userRepository.save(user);
        return new UserResponse(user.getId(),user.getEmail(), user.getName());
        }else throw new IllegalArgumentException("Sei coglione ti sei già registrato");

    }

}
