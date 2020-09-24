package com.example.TikTokBackDemo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterDTO {

    private Integer pageNo = 0;
    private Integer pageSize = 3;
    private Long price_of;
    private Long price_to;
    private Integer theme;
    private Long fans_of;
    private Long fans_to;
    private Long hearts_of;
    private Long hearts_to;
}
