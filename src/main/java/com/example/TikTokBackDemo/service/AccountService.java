package com.example.TikTokBackDemo.service;

import com.example.TikTokBackDemo.domain.Account;
import com.example.TikTokBackDemo.domain.PromoAccount;
import com.example.TikTokBackDemo.dto.FilterDTO;
import com.example.TikTokBackDemo.dto.MaxValueDTO;
import com.example.TikTokBackDemo.dto.PromoAccountDTO;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    PromoAccountDTO create(PromoAccountDTO promoAccountDTO);
    List<PromoAccount> getByFilter(FilterDTO filterDTO);
    Optional<Account> findByUsername(String username);
    List<PromoAccount> getAll(Integer pageNo, Integer pageSize);
    MaxValueDTO getMaxValue();
}
