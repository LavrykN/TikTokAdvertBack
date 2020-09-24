package com.example.TikTokBackDemo.domain;

import com.example.TikTokBackDemo.dto.AccountDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
public class Account {


    @Id
    @GeneratedValue(strategy = AUTO)
    @JsonIgnore
    private Long id;

    private String bio;
    private String username;
    private Long fans;
    private Long heart;
    private String urlImage;

    public Account() {
    }

    public Account(AccountDto accountDto) {
        this.bio = accountDto.getBio();
        this.username = accountDto.getUsername();
        this.fans = accountDto.getFans();
        this.heart = accountDto.getHeart();
        this.urlImage = accountDto.getUrlImage();
    }
}
