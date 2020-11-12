package fr.utbm.TA72brainstorming;

import java.util.concurrent.atomic.AtomicLong;

import fr.utbm.TA72brainstorming.entity.User;
import fr.utbm.TA72brainstorming.repository.EntityUserDao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Ta72BrainstormingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ta72BrainstormingApplication.class, args);
                /*User u1 = new User();
                u1.setUsername("coreduss");
                u1.setPassword("qwertyr");
                u1.setFirstname("Loanns");
                u1.setLastname("Peureys");
				u1.setEmail("mail");
                EntityUserDao efd = new EntityUserDao();
                efd.save(u1);*/
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
