package com.stackroute.Muzix.Service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExsistsException;
import com.stackroute.Muzix.repository.TrackRepository;
import com.stackroute.Muzix.service.TrackServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ServiceTest {
    @Autowired
    private MockMvc mockMvc;
    private Track track;
    @Mock
    TrackRepository trackRepository;
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> trackList=null;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        //mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
        track = new Track();
        track.setId(15);
        track.setName("girls like you");
        track.setComment("nice song ");
        trackList = new ArrayList();
        trackList.add(track);

    }
    @Test
    public void saveTrackTest() throws TrackAlreadyExsistsException
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack=trackService.saveTrack(track);
        Assert.assertEquals(track, savedTrack);
    }
    @Test
    public void getallTracksTest()
    {
        trackRepository.save(track);
        when(trackRepository.findAll()).thenReturn(trackList);
        List<Track> list = trackService.getAllTracks();
        Assert.assertEquals(trackList,list);
    }


    @Test
    public void updateTrackTest()
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track updateTrack=null;
        try
        {
            updateTrack=trackService.saveTrack(track);
        }
        catch(TrackAlreadyExsistsException e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals(track, updateTrack);
    }

}
