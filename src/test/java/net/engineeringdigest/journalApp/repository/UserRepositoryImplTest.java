package net.engineeringdigest.journalApp.repository;


import net.engineeringdigest.journalApp.Repository.UserRepositoryImpl;
import net.engineeringdigest.journalApp.entity.Users;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@SpringBootTest
public class UserRepositoryImplTest {

    @Autowired
    private UserRepositoryImpl userRepository;


    @Test
    public void getUser() {
        userRepository.getUsersForSa();
    }

}
