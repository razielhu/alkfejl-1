package hu.elte.alkfejl.controller;

import hu.elte.alkfejl.entity.User;
import hu.elte.alkfejl.repository.UserRepository;
import hu.elte.alkfejl.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    //@Autowired
    //private PasswordEncoder passwordEncoder;

    @RequestMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        Optional<User> dbUser =
            userRepository.findByName(user.getName());
        if (dbUser.isPresent() && user.getPassword().equals(dbUser.get().getPassword())) {
            userService.setUser(dbUser.get());
            return ResponseEntity.ok(dbUser.get());
        } else {
            return ResponseEntity.status(403).build();
        }
    }
    
    @RequestMapping("/logout")
    public ResponseEntity logout() {
        userService.setUser(null);
        return ResponseEntity.ok(false);
    }
    
    @GetMapping("/user")
    public ResponseEntity getUser() {
        if (userService.getUser() == null) {
            return ResponseEntity.ok(false);
        } else {
            return ResponseEntity.ok(userService.getUser());
        }
    }
}