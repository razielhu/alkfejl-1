/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.entity;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Task extends BaseEntity {
   
    
    public Task(Folder folder, Task t) {
        this.folder = folder;
        this.state = "created";
        this.description = t.getDescription();
        this.priority = t.getPriority();
    }
    
    public Task(Folder folder, String description) {
        this.folder = folder;
        this.state = "created";
        this.description = description;
    }
    
    public Task(Folder folder, String description, int priority) {
        this.folder = folder;
        this.state = "created";
        this.description = description;
        this.priority = priority;
    }
    
    public Task(Folder folder, String description, int priority, Timestamp deadline) {
        this.folder = folder;
        this.state = "created";
        this.description = description;
        this.priority = priority;
    }
    //java.sql.Timestamp, de lehet változtatni kell még
    @Column(nullable = false)
    private Timestamp deadline;
    
    @Column(nullable = false)
    private String state;
    
    @Column
    private String description;
    
    @Column(nullable = false)
    private int priority = 5;
    
    @ManyToOne( targetEntity = User.class, 
               cascade = CascadeType.ALL)
    private User user;
    
    @ManyToOne( targetEntity = Folder.class, 
               cascade = CascadeType.ALL)
    private Folder folder;
    
    @Column(nullable = false)
    private boolean deleted = false;
}
