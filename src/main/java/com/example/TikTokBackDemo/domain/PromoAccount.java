package com.example.TikTokBackDemo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class PromoAccount {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @JsonIgnore
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accountInfo")
    private Account accountInfo;

    private Long price;

    @Column(columnDefinition = "VARCHAR(1337)")
    private String description;

    @ElementCollection
    private List<Integer> theme = new ArrayList<Integer>();

    private String contact;
    private Date date;

    public PromoAccount() {
    }

    public PromoAccount(Account account, Long price, String description, List<Integer> theme, String contact, Date date) {
        this.accountInfo = account;
        this.price = price;
        this.description = description;
        this.theme = theme;
        this.contact = contact;
        this.date = date;
    }
}
