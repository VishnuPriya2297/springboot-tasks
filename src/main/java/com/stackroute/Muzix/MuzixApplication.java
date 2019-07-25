package com.stackroute.Muzix;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExsistsException;
import com.stackroute.Muzix.repository.TrackRepository;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class MuzixApplication  implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner{

	@Value("15")
	private int Id;

	@Value("meghana")
	private String name;

	@Value("good")
	private String comment;

	@Autowired
	TrackRepository trackRepository;

	@Autowired
	Environment environment;

	@Autowired
	TrackService trackService;

	public static void main(String[] args) {

		SpringApplication.run(MuzixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try
		{
			trackService.saveTrack(new Track(22,"poojitha","bad"));
		}
		catch (TrackAlreadyExsistsException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		try
		{
			trackService.saveTrack(new Track(11,"pallavi","thin"));
		}
		catch (TrackAlreadyExsistsException e)
		{
			e.printStackTrace();
		}

	}
}
