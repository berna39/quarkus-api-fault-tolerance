package com.terminator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Episode {
    private Long id;
    private String name;
    private String season;
    private String summary;
}
