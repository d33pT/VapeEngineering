package de.academy.abschlussprojekt.herbie.server;

import de.academy.abschlussprojekt.herbie.server.post.Post;
import de.academy.abschlussprojekt.herbie.server.post.PostRepository;
import de.academy.abschlussprojekt.herbie.server.security.SecurityConfiguration;
import de.academy.abschlussprojekt.herbie.server.user.User;
import de.academy.abschlussprojekt.herbie.server.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Import(SecurityConfiguration.class)
public class ServerApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private PostRepository postRepository;


	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Michi", passwordEncoder.encode("Test")));
		postRepository.save(new Post("Geiler Scheiß", "Testtext"));
	}
}
