package com.example.chinook_java_assignment.data.service;

import com.example.chinook_java_assignment.data.ConnectionHelper;
import com.example.chinook_java_assignment.model.customer.Customer;
import com.example.chinook_java_assignment.model.music.Artist;
import com.example.chinook_java_assignment.model.music.Genre;
import com.example.chinook_java_assignment.model.music.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MusicRepository implements IMusicRepository {
    /**
     * gets all artists from database and adds them to a list. Uses helper method to sort out and return five random artists.
     * @return
     */
    @Override
    public List<Artist> getFiveRandomArtists() {
        List<Artist> artists = new ArrayList<>();
        try {
            Connection conn = ConnectionHelper.getInstance().getConnection();
            String query = "SELECT * FROM ARTIST";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Artist artist = new Artist(resultSet.getInt("ArtistId"),resultSet.getString("Name"));
                artists.add(artist);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        List<Artist> randomFiveArtist = randomPicker(artists, 5);
        return randomFiveArtist;
    }
    /**
     * gets all tracks from database and adds them to a list. Uses helper method to sort out and return five random tracks.
     * @return
     */
    @Override
    public List<Track> getFiveRandomTracks() {
        List<Track> tracks = new ArrayList<>();
        try {
            Connection conn = ConnectionHelper.getInstance().getConnection();
            String query = "SELECT * FROM TRACK";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Track track = new Track(resultSet.getInt("TrackId"),resultSet.getString("Name"), resultSet.getString("Composer")
                        , resultSet.getInt("AlbumId"), resultSet.getInt("GenreId"));
                tracks.add(track);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        List<Track> randomFiveTracks = randomPicker(tracks, 5);
        return randomFiveTracks;
    }
    /**
     * gets all genres from database and adds them to a list. Uses helper method to sort out and return five random genres.
     * @return
     */
    @Override
    public List<Genre> getFiveRandomGenres() {
        List<Genre> genres = new ArrayList<>();
        try {
            Connection conn = ConnectionHelper.getInstance().getConnection();
            String query = "SELECT * FROM GENRE";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Genre genre = new Genre(resultSet.getInt("GenreId"), resultSet.getString("Name"));
                genres.add(genre);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        List<Genre> randomFiveGenres = randomPicker(genres, 5);
        return randomFiveGenres;
    }
    /**
     * Helper method that uses generics to find and return number of n elements from a parameter list
     * @param t
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> randomPicker(List<T> t, int n) {
        List<T> copy = new ArrayList<T>(t);
        Collections.shuffle(copy);
        return n > copy.size() ? copy.subList(0, copy.size()) : copy.subList(0, n);
    }


    public ArrayList<Track> getSearchMatchingTracks(String keyword) {

        ArrayList<Track> tracks = new ArrayList<Track>();

        try {
            Connection conn = ConnectionHelper.getInstance().getConnection();
            String query = "SELECT TRACK.TrackId, TRACK.Name, TRACK.Composer, TRACK.AlbumId, TRACK.GenreId, ALBUM.Title, GENRE.Name AS Genre FROM TRACK INNER JOIN GENRE ON TRACK.GenreId = GENRE.GenreId INNER JOIN ALBUM ON TRACK.AlbumId = ALBUM.AlbumId WHERE TRACK.Name LIKE ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, "%" +keyword +"%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Track track = new Track(resultSet.getInt("TrackId"),resultSet.getString("Name"), resultSet.getString("Composer"),
                        resultSet.getInt("AlbumId"), resultSet.getInt("GenreId"), resultSet.getString("Title"), resultSet.getString("Genre"));
                tracks.add(track);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return tracks;
    }
}
