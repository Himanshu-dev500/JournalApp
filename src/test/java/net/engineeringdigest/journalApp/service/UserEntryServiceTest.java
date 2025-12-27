package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.UserRepo;
import net.engineeringdigest.journalApp.entity.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootTest
public class UserEntryServiceTest {

    @Autowired
    private  UserRepo userRepo;

    @Autowired
     private UserEntryService userEntryService;

    @ParameterizedTest
    @ValueSource(strings = {
            "Ishaan",
            "Kishan"
    })
    public void testFindUserByUserName(String name) {
        Assertions.assertNotNull(userRepo.findByUserName(name));

    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,4,8"

    })
    public void test(int a,int b, int expected){
        Assertions.assertEquals(expected,a+b);
    }
}
