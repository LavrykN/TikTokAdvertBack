package com.example.TikTokBackDemo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaxValueDTO {
    private Long maxPrice;
    private Long maxFans;
    private Long maxHearts;
}
