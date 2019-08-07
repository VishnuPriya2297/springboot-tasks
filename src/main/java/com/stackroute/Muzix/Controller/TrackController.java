package com.stackroute.Muzix.Controller;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExsistsException;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController
{
private TrackService trackService;

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
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable(value = "id") Integer id)
    {
        ResponseEntity responseEntity;
        try {
            responseEntity=new ResponseEntity<Track>(trackService.getTrackById(id), HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

   @GetMapping("trackname/{name}")
   //@Query("from Track where name=?1 ")
   public ResponseEntity<?> getAllUsersByName(@PathVariable(value = "name") String name )
   {
       ResponseEntity responseEntity;
       try {
           responseEntity= new ResponseEntity<List<Track>>(trackService.getTrackByName(name), HttpStatus.OK);
       }
       catch (Exception e)
       {
           responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
       }
       return responseEntity;
   }
    @PutMapping("track")
    public ResponseEntity<?> updateUser(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
        } catch (TrackAlreadyExsistsException e) {
            e.printStackTrace();
        }
        responseEntity=new ResponseEntity<String>("successfully Updated", HttpStatus.CREATED);
        return responseEntity;
    }


}
