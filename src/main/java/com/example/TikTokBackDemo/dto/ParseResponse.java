package com.example.TikTokBackDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParseResponse {

    private String bio;
    private String username;
    private int fans;
    private int heart;
    private String urlImage;
    private boolean added = false;
}
