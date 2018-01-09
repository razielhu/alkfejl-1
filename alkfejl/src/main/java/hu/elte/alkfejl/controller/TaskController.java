/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.controller;

import form.folderAndTask;
import form.userBody;
import hu.elte.alkfejl.entity.Folder;
import hu.elte.alkfejl.entity.Task;
import hu.elte.alkfejl.repository.FolderRepository;
import hu.elte.alkfejl.repository.TeamRepository;
import hu.elte.alkfejl.repository.UserRepository;
import hu.elte.alkfejl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/task/")
public class TaskController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private TeamRepository taskRepository;
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping(value="/add",  method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody folderAndTask fnt){
        Folder f = fnt.getFolder();
        Task t = fnt.getTask();
        Task newTask = new Task(f, t);
        newTask.setUser(this.userService.getUser());
        
        return ResponseEntity.ok(this.taskRepository.findById(t.getId()));
        
    }
    /*
    @ResponseBody
    @RequestMapping(value="/list",  method = RequestMethod.GET)
    public ResponseEntity tasks(){
        return ResponseEntity.ok(this.userRepository.findById(this.userService.getUser().getId()).get().getFolders());
        
    }*/
    
    
}
