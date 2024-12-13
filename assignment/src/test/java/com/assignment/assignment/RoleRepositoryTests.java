package com.assignment.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.assignment.Repository.Rolerepo;
import com.assignment.assignment.entities.Role;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
    @Autowired private Rolerepo rolerepo;
     
    @Test
    public void testCreateRoles() {
        Role admin = new Role("ADMIN");
        Role editor = new Role("USER");
        
         
        rolerepo.saveAll(List.of(admin, editor));
         
        long count = rolerepo.count();
        assertEquals(2, count);
    }
}
