package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;

import java.util.List;

public interface TrackService {

    Track saveTrack(Track track);

     void deleteTrack(int id);

     List<Track> getAllTracks();

     Track getTrackById(int id);

     Track updateTrack(Track track);

     List<Track> getTrackByName(String name);

}
