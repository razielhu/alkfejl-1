/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.repository;

import hu.elte.alkfejl.entity.Folder;
import hu.elte.alkfejl.entity.Task;
import hu.elte.alkfejl.entity.Team;
import hu.elte.alkfejl.entity.User;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends CrudRepository<Folder, Long> {
    
    Optional<Folder> findById(Long id);
    
    List<Folder> findAllByDeleted(boolean deleted);
    
    void delete(Folder folder);
    
    //kell ez?
    //void addTask(User user, Group group, Timestamp deadline, String description, int priority);
    
    
}
