package com.project.database.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.database.Entities.User;
@Repository
public interface UserRepositery  extends JpaRepository<User,Integer> {
    
}
