package com.stackroute.Muzix;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExsistsException;
import com.stackroute.Muzix.service.TrackService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
@Component
public class CommandLineStartUpRunner implements CommandLineRunner {
    TrackService trackService;

    public CommandLineStartUpRunner(TrackService trackService) {
        this.trackService = trackService;
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
}
