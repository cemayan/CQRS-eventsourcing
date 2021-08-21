package com.ca.musicqueryapi.controllers;



import com.ca.musicqueryapi.dto.SongLookupResponse;
import com.ca.musicqueryapi.queries.FindAllSongsQuery;
import com.ca.musicqueryapi.queries.FindSongByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/songLookup")
public class SongLookupController {
    private final QueryGateway queryGateway;

    @Autowired
    public SongLookupController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(path = "/")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public ResponseEntity<SongLookupResponse> getAllUsers() {
        try {
            var query = new FindAllSongsQuery();
            var response = queryGateway.query(query, ResponseTypes.instanceOf(SongLookupResponse.class)).join();

            if (response == null || response.getSongs() == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Failed to complete get all songs request";
            System.out.println(e.toString());

            return new ResponseEntity<>(new SongLookupResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public ResponseEntity<SongLookupResponse> getUserById(@PathVariable(value = "id") String id) {
        try {
            var query = new FindSongByIdQuery(id);
            var response = queryGateway.query(query, ResponseTypes.instanceOf(SongLookupResponse.class)).join();

            if (response == null || response.getSongs() == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Failed to complete get song by ID request";
            System.out.println(e.toString());

            return new ResponseEntity<>(new SongLookupResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
