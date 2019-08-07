package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track);

    public void deleteTrack(int id);

    public List<Track> getAllTracks();

    public Track getTrackById(int id);

    public Track updateTrack(Track track);

}
