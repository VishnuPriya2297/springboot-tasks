package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExsistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    Track saveTrack(Track track) throws TrackAlreadyExsistsException;

    boolean deleteTrack(int id);

    List<Track> getAllTracks();

   Track getTrackById(int id)throws TrackNotFoundException;

    Track updateTrack(Track track);

   // public List<Track> getTrackByName(String name)throws TrackNotFoundException;

}
