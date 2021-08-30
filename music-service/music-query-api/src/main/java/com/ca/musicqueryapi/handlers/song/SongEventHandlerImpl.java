package com.ca.musicqueryapi.handlers.song;

import com.ca.musiccore.events.song.AllSongRegisteredEvent;
import com.ca.musiccore.events.song.SongRegisteredEvent;
import com.ca.musiccore.mapper.AlbumMapper;
import com.ca.musiccore.mapper.ArtistMapper;
import com.ca.musiccore.mapper.GenreMapper;
import com.ca.musiccore.mapper.SongMapper;
import com.ca.musiccore.models.Album;
import com.ca.musiccore.models.Artist;
import com.ca.musiccore.models.Genre;
import com.ca.musiccore.models.Song;
import com.ca.musicqueryapi.repositories.AlbumRepository;
import com.ca.musicqueryapi.repositories.ArtistRepository;
import com.ca.musicqueryapi.repositories.GenreRepository;
import com.ca.musicqueryapi.repositories.SongRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@ProcessingGroup("music-group")
public class SongEventHandlerImpl implements SongEventHandler {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final GenreRepository genreRepository;
    private final ArtistRepository artistRepository;
    private final StreamBridge streamBridge;


    @Autowired
    public SongEventHandlerImpl(SongRepository songRepository, AlbumRepository albumRepository,
                                GenreRepository genreRepository, ArtistRepository artistRepository, StreamBridge streamBridge) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.genreRepository = genreRepository;
        this.artistRepository = artistRepository;
        this.streamBridge = streamBridge;
    }


    @EventHandler
    @Override
    public void on(SongRegisteredEvent songRegisteredEvent) {

       Song song_ = SongMapper.INSTANCE.songEventToSong( songRegisteredEvent );
       song_.setNewSong(true);

        songRepository.save(song_).subscribe();
    }

    @EventHandler
    @Override
    public void on(AllSongRegisteredEvent allSongRegisteredEvent) {


        streamBridge.send("music-topic", allSongRegisteredEvent);


//        Song song_ = SongMapper.INSTANCE.songDTOToSong(allSongRegisteredEvent.getSong());
//        song_.setNewSong(true);
//
//        Album album_ = AlbumMapper.INSTANCE.albumDTOToAlbum(allSongRegisteredEvent.getAlbum());
//        if(allSongRegisteredEvent.getAlbum().getId() == null) {
//            album_.setId(UUID.randomUUID().toString());
//        }
//
//        album_.setNewAlbum(true);
//
//        Artist artist_ = ArtistMapper.INSTANCE.artistDTOToArtist(allSongRegisteredEvent.getArtist());
//
//        if(allSongRegisteredEvent.getArtist().getId() == null){
//            artist_.setId(UUID.randomUUID().toString());
//        }
//
//        artist_.setNewArtist(true);
//
//        Genre genre_ = GenreMapper.INSTANCE.genreDTOToGenre(allSongRegisteredEvent.getGenre());
//
//        if(allSongRegisteredEvent.getGenre().getId() == null) {
//            genre_.setId(UUID.randomUUID().toString());
//        }
//
//        genre_.setNewGenre(true);
//
//
//
//        albumRepository.save(album_).subscribe();
//        artistRepository.save(artist_).subscribe();
//        genreRepository.save(genre_).subscribe();
//
//
//        song_.setAlbumId(album_.getId());
//        song_.setArtistId(artist_.getId());
//        song_.setGenreId(genre_.getId());
//
//        songRepository.save(song_).subscribe();
    }

}
