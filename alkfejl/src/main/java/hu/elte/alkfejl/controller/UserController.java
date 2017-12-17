/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.controller;

import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.entity.Folder;
import hu.elte.alkfejl.entity.User;
import hu.elte.alkfejl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import hu.elte.alkfejl.repository.FolderRepository;
import hu.elte.alkfejl.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private UserService userService;
    
    
    @GetMapping(value="/gettt")
    @ResponseBody
    @Role({User.Role.USER, User.Role.ADMIN})
    public ResponseEntity getUserthing(
        ) {
            
            List<Folder> folders = userService.getUser().getFolders();
            for(Folder f : folders) {
                if(!f.isDeleted()) folders.remove(f);
            }
            
            return ResponseEntity.ok(folders);

    }
    
    @PostMapping(value="/edit")
    @ResponseBody
    @Role({User.Role.USER, User.Role.ADMIN})
    public ResponseEntity editAccount(
        @RequestParam(  value = "id", required = true )Long userId,
        @RequestParam(  value = "name", required = false ) String name,
        @RequestParam(  value = "password", required = false ) String password,
        @RequestParam(  value = "email", required = false )String email
        ) {
            User user = null;
            Optional<User> optuser = userRepository.findById(userId);
            if(optuser.isPresent()) {
                user = optuser.get();
            }
            if(user != null) {
                if(name != null) user.setName(name);
                if(password != null) user.setPassword(password);
                if(email != null) user.setEmail(email);

                User endUser = userRepository.save(user);
                return ResponseEntity.ok(endUser);
            } else {
                return null;
            }
    }
    
}

 
