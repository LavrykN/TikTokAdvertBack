package com.example.TikTokBackDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromoAccountDTO {

    private AccountDto accountInfo;

    private Long price;
    private String description;
    private List<Integer> theme;
    private String contact;
    private Date date;
}
