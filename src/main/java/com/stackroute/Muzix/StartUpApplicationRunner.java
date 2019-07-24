package com.stackroute.Muzix;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExsistsException;
import com.stackroute.Muzix.repository.TrackRepository;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component

public class StartUpApplicationRunner implements ApplicationListener<ContextRefreshedEvent>
{
    TrackService trackService;

    public StartUpApplicationRunner(TrackService trackService) {
        this.trackService = trackService;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
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
