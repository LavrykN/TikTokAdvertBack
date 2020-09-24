package com.example.TikTokBackDemo.repository;

import com.example.TikTokBackDemo.domain.PromoAccount;
import com.example.TikTokBackDemo.dto.FilterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomPromoAccountRepository {
    Page<PromoAccount> filter(FilterDTO filterDTO, Pageable pageable);

}
