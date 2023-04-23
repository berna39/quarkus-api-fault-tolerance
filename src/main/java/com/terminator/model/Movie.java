package com.terminator.model;

import java.net.URL;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private Long id;
    private String name;
    private URL url;
    private URL offisialSite;
    private String summary;
    private String language;
    private Set<String> genres;
    private List<Episode> episodes;
}
