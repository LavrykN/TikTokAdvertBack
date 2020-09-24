package com.example.TikTokBackDemo.repository;

import com.example.TikTokBackDemo.domain.PromoAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromoAccountRepository extends JpaRepository<PromoAccount, Long>, CustomPromoAccountRepository {

    @Query("SELECT max(accountInfo.fans), max(price), max(accountInfo.heart) FROM PromoAccount")
    List<Long[]> getMaxPrice();
}
