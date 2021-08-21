package com.ca.musicqueryapi.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindSongByIdQuery {
    private String id;
}
