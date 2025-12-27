package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.Users;
import net.engineeringdigest.journalApp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserEntryService userEntryService;

    @GetMapping("/all/users")
    public ResponseEntity<?> getAllUsers() {
        List<Users> allUsers = userEntryService.getAllUsers();
        if (allUsers != null || !allUsers.isEmpty()) {
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add/admin")
    public void saveAdmin(@RequestBody Users user) {
        userEntryService.saveAdmin(user);
    }
}
