package com.taffah.springjwt;

import com.taffah.springjwt.models.*;
import com.taffah.springjwt.repository.ClientRepository;
import com.taffah.springjwt.repository.RoleRepository;
import com.taffah.springjwt.repository.UserRepository;
import com.taffah.springjwt.repository.VolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityJwtApplication {

	public static void main(String[] args) {
    SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(VolRepository volRepository,
											   RoleRepository roleRepository,
											   UserRepository userRepository,
											   ClientRepository clientRepository
											   ) {
		return args -> {
			Vol vol=new Vol();
			vol.setNom("oufz");
			vol.setDateArrivee(new Date());
			vol.setNom("oiuzef");
			volRepository.save(vol);

			Client client=new Client();
			client.setEmail("pijaef@gmail.com");
			client.setNom("oiufhzef");
			clientRepository.save(client);
			/*
			Role role = new Role();
			role.setName(ERole.ROLE_ADMIN);
			roleRepository.save(role);


			Set<Role> roles = new HashSet<>();
			roles.add(role);


			User user = new User();
			user.setEmail("walo@gmail.com");
			user.setUsername("walo@gmail.com");
			user.setRoles(roles);


			String password = "walo@gmail.com";
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedPassword = encoder.encode(password);

			user.setPassword(encodedPassword);

			userRepository.save(user);*/
		};
	}

}
