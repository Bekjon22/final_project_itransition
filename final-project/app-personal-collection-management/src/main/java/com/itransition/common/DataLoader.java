package com.itransition.common;

import com.itransition.entity.Role;
import com.itransition.entity.User;
import com.itransition.enums.PermissionEnum;
import com.itransition.enums.RoleEnum;
import com.itransition.repository.RoleRepository;
import com.itransition.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Bekjon Bakhromov
 * @since  24.06.2022-12:31 AM
 */
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {

        if (initialMode.equals("always")) {
            Role roleUser = new Role(
                    "USER",
                    null,
                    new HashSet<>(Arrays.asList(PermissionEnum.CREATE_CATEGORY,
                            PermissionEnum.GET_CATEGORY,
                            PermissionEnum.DELETE_CATEGORY,
                            PermissionEnum.GET_CATEGORY_ALL)),
                    RoleEnum.ROLE_USER
            );

            Role roleAdmin = new Role(
                    "SUPER_ADMIN",
                    null,
                    new HashSet<>(Arrays.asList(PermissionEnum.values())),
                    RoleEnum.ROLE_ADMIN
            );

            roleRepository.saveAll(new ArrayList<>(Arrays.asList(roleAdmin, roleUser)));

            User adminUser = User.builder()
                    .setEmail("blabla@gmail.com")
                    .setFirstName("Admin")
                    .setPassword(passwordEncoder.encode("root123"))
                    .setRole(roleAdmin)
                    .setEnabled(true)
                    .build();
            userRepository.save(adminUser);

        }

    }
}
