package hu.elte.alkfejl.controller;

import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.entity.Folder;
import hu.elte.alkfejl.entity.Team;
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
import hu.elte.alkfejl.repository.TeamRepository;
import hu.elte.alkfejl.service.UserService;
import java.util.Optional;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("api/team/")
public class TeamController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private UserService userService;
    
    
    
    @PostMapping(value="/create")
    @ResponseBody
    @Role({User.Role.USER, User.Role.ADMIN})
    public ResponseEntity create(
        @RequestParam(  value = "name", required = true ) String name,
        @RequestParam(  value = "description", required = true ) String description
        ) {
            
            User user = null;
            Optional<User> optuser = userRepository.findById(this.userService.getUser().getId());
            if(optuser.isPresent()) {
                user = optuser.get();
            }
            if(user != null) {
                Team t = new Team(name, description);
                user.getTeams().add(t);
                Team endTeam = teamRepository.save(t);
                return ResponseEntity.ok(endTeam);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
    }
    
    
    @PostMapping(value="/edit")
    @ResponseBody
    @Role({User.Role.USER, User.Role.ADMIN})
    public ResponseEntity edit(
        @RequestParam(  value = "team", required = true ) Long teamId,
        @RequestParam(  value = "name", required = false ) String name,
        @RequestParam(  value = "description", required = false ) String description
        ) {
            System.out.println("name:" + name);
            User user = null;
            Optional<User> optuser = userRepository.findById(this.userService.getUser().getId());
            if(optuser.isPresent()) {
                user = optuser.get();
            }
            Team team = null;
            Optional<Team> optteam = teamRepository.findById(teamId);
            if(optteam.isPresent()) {
                team = optteam.get();
            }
            
            if(user != null && team != null && user.getTeams().contains(team)) {
                System.out.println("Bent vagyok");
                if(name != null)  team.setName(name);
                if(description != null)  team.setDescription(description);
                Team t = teamRepository.save(team);
                return ResponseEntity.ok(t);
            }
            
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
}

 
