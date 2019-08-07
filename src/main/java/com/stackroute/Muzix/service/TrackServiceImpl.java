package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExsistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;
import com.stackroute.Muzix.repository.TrackRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExsistsException {
        if(trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExsistsException("Track already exsists");
        }

        Track savedTrack=trackRepository.save(track);
        if(savedTracks==null)
            throw new TrackAlreadyExsistsException("Track already exsists");
        return savedTrack;
    }

    @Override
    public void deleteTrack(int id) {
        trackRepository.deleteById(id);
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {

        if(!trackRepository.findById(id).isPresent()) {
            throw new TrackNotFoundException("The track does not exsist");

        }
        else
        {
            Track track = trackRepository.findById(id).get();
            return track;

        }
    }

    @Override
    public Track updateTrack(Track track) {
        Track updatedTrack=trackRepository.save(track);
        return updatedTrack;
    }
    @Override
    public List<Track> getTrackByName(String name) throws TrackNotFoundException
    {
        if(trackRepository.findByName(name).isEmpty()) {
            throw new TrackNotFoundException("The track does not exsist");
        }
        else {
            List<Track> track = trackRepository.findByName(name);
            return track;
        }
    }
}
