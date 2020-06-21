package nut.doubt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@SpringBootApplication
public class DoubtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoubtApplication.class, args);
	}

}
