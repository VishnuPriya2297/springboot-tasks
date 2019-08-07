package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExsistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

     Track saveTrack(Track track) throws TrackAlreadyExsistsException;

     void deleteTrack(int id);

     List<Track> getAllTracks();

     Track getTrackById(int id)throws TrackNotFoundException;

     Track updateTrack(Track track);

     List<Track> getTrackByName(String name)throws TrackNotFoundException;

}
