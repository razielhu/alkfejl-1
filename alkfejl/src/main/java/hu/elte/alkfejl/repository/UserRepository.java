package hu.elte.alkfejl.repository;

import hu.elte.alkfejl.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        CrudRepository<User, Long> {
    
    Optional<User> findByNameAndPassword(String name, 
                                             String password);
    
    Optional<User> findById(Long id);
    
    Optional<User> findByName(String name);
    
    
    void deleteById(Long id);
    
    //User save(User user);
    
    //void login(String username, String password);
    
    //void editAccount(User user, String password, String email);
}
