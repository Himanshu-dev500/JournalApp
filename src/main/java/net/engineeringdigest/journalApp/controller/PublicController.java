package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.Users;
import net.engineeringdigest.journalApp.service.UserEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserEntryService userEntryService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<>(userEntryService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/create/user")
    public ResponseEntity<Users> saveUsers(@RequestBody Users users) {
        userEntryService.saveNewUser(users);
        return new ResponseEntity<>(users, HttpStatus.CREATED);

    }


    @GetMapping("/userId")
    public ResponseEntity<Users> getUsersByIds(@PathVariable ObjectId id) {
        Optional<Users> users = userEntryService.getUserById(id);
        if (users.isPresent()) {
            return new ResponseEntity<>(users.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
