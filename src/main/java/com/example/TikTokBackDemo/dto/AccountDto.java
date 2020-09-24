package com.example.TikTokBackDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto{

    private String bio;
    private String username;
    private Long fans;
    private Long heart;
    private String urlImage;
}
