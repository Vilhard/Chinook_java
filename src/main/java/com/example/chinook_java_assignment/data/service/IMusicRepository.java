package com.example.chinook_java_assignment.data.service;

import com.example.chinook_java_assignment.model.music.Artist;
import com.example.chinook_java_assignment.model.music.Genre;
import com.example.chinook_java_assignment.model.music.Track;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IMusicRepository {
    List<Artist> getFiveRandomArtists();
    List<Track> getFiveRandomTracks();
    List<Genre> getFiveRandomGenres();
    List<Track> getSearchMatchingTracks(String keyword);
}
