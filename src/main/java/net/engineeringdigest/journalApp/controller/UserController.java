package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Repository.UserRepo;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.entity.Users;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserEntryService;
import net.engineeringdigest.journalApp.service.WeatherService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserEntryService userEntryService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WeatherService weatherService;



    @DeleteMapping("/userId")
    public ResponseEntity<Users> deleteUsers(@RequestBody ObjectId id) {
        userEntryService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

@PutMapping
    public ResponseEntity<Users> updateUsers(@RequestBody Users users) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getName();
        Users userInDb = userEntryService.getUserByUserName(username);
            userInDb.setPassword(users.getPassword());
            userInDb.setUserName(users.getUserName());
            userEntryService.saveNewUser(userInDb);
        return new ResponseEntity<>(users, HttpStatus.NO_CONTENT);


    }

    @DeleteMapping
    public ResponseEntity<Users> deleteUser(@RequestBody ObjectId id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userRepo.deleteByUserName(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        String greeting = "";
        if (weatherResponse != null) {
            greeting = ", Weather feels like " + weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi " + authentication.getName() + greeting, HttpStatus.OK);
    }

}
