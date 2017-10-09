package com.eprogrammerz.examples.eureka;

import com.eprogrammerz.examples.eureka.models.Bookmark;
import com.eprogrammerz.examples.eureka.repositories.BookmarkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
public class BookmarkServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(BookmarkRepository bookmarkRepository) {
		return args -> {
			bookmarkRepository.deleteAll();

			Arrays.asList("yogen", "dipa").forEach(n ->
					bookmarkRepository.save(new Bookmark(n,
							"http://some-other-host" + n + ".com/",
							"A description for " + n + "'s link",
							n)));
		};
	}
}
