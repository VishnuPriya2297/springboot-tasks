package com.stackroute.Muzix.Controller;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController
{
TrackService trackService;

    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }
    @PostMapping("track")
    public ResponseEntity<?> save(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> getallUsers()
    {
        return  new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") Integer id )
    {
        ResponseEntity responseEntity;
        trackService.deleteTrack(id);
        responseEntity=new ResponseEntity<String>("Deleted",HttpStatus.FORBIDDEN);
        return responseEntity;
    }
    @PutMapping("track")
    public ResponseEntity<?> updateUser(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        trackService.saveTrack(track);
        responseEntity=new ResponseEntity<String>("successfully Updated", HttpStatus.CREATED);
        return responseEntity;
    }

}
