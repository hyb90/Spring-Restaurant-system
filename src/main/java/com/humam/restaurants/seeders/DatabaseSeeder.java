package com.humam.restaurants.seeders;


import com.humam.restaurants.extras.ERole;
import com.humam.restaurants.models.Role;

import com.humam.restaurants.repository.RoleRepository;
import com.humam.restaurants.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by smatt on 29/06/2017.
 */
@Component
public class DatabaseSeeder {


    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseSeeder(
            UserRepository userRepository,
            RoleRepository roleRepository,
            JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedRolesTable();
//        seedUsersTable();
    }

//    private void seedUsersTable() {
//        String sql = "SELECT username, email FROM users U  ";
//        List<User> u = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
//        if(u == null || u.size() <= 0) {
//            User user = new User();
//            user.setName("Spring Blog");
//            user.setUsername("admin");
//            user.setEmail("test@test.com");
//            user.setPassword(new BCryptPasswordEncoder().encode("test123"));
//            user.setRole(Roles.SUPER_ADMIN.toString());
//            user.setBanned(false);
//            user.setConfirmEmail(true);
//            userRepository.save(user);
//            logger.info("Users Seeded");
//        } else {
//            logger.trace("Users Seeding Not Required");
//        }
//    }

    private void seedRolesTable() {
        String sql = "SELECT name FROM roles r  " ;
        List<Role> r = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if(r == null || r.size() <= 0) {
            Role role1 = new Role();
            role1.setName(ERole.ROLE_ADMIN);
            roleRepository.save(role1);
            Role role2 = new Role();
            role2.setName(ERole.ROLE_EDITOR);
            roleRepository.save(role2);
            Role role3 = new Role();
            role3.setName(ERole.ROLE_USER);
            roleRepository.save(role3);
        } else {

        }
    }



}