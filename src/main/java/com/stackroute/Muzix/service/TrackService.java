package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExsistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExsistsException;

    public void deleteTrack(int id);

    public List<Track> getAllTracks();

    public Track getTrackById(int id)throws TrackNotFoundException;

    public Track UpdateTrack(Track track);

    public List<Track> getTrackByName(String name)throws TrackNotFoundException;

}
