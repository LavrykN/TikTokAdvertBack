package com.example.TikTokBackDemo.repository;

import com.example.TikTokBackDemo.domain.PromoAccount;
import com.example.TikTokBackDemo.dto.FilterDTO;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;

@Repository
public class CustomPromoAccountRepositoryImpl implements CustomPromoAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<PromoAccount> filter(FilterDTO filterDTO, Pageable pageable) {

        var jpql = new StringBuilder();
        jpql.append("FROM PromoAccount WHERE 1=1 ");

        var parameters = new HashMap<String, Object>();

        // Start Price
        if (filterDTO.getPrice_of() != null) {
            jpql.append("and price >= :price_of ");
            parameters.put("price_of", filterDTO.getPrice_of());
        }
        if (filterDTO.getPrice_to() != null) {
            jpql.append("and price <= :price_to ");
            parameters.put("price_to", filterDTO.getPrice_to());
        }
        // Start Fans
        if (filterDTO.getFans_of() != null) {
            jpql.append("and accountInfo.fans >= :fans_of ");
            parameters.put("fans_of", filterDTO.getFans_of());
        }
        if (filterDTO.getFans_to() != null) {
            jpql.append("and accountInfo.fans <= :fans_to ");
            parameters.put("fans_to", filterDTO.getFans_to());
        }
        // Start Hearts
        if (filterDTO.getHearts_of() != null) {
            jpql.append("and accountInfo.heart >= :heart_of ");
            parameters.put("heart_of", filterDTO.getHearts_of());
        }

        if (filterDTO.getHearts_to() != null) {
            jpql.append("and accountInfo.heart <= :heart_to ");
            parameters.put("heart_to", filterDTO.getHearts_to());
        }
        // Start Theme
        if (filterDTO.getTheme() != null) {
            jpql.append("and :theme member of theme ");
            parameters.put("theme", filterDTO.getTheme());
        }

        jpql.append("ORDER BY date DESC ");
        

        TypedQuery<PromoAccount> query = entityManager.createQuery(jpql.toString(), PromoAccount.class);

        parameters.forEach((key, value) -> query.setParameter(key, value));

        Page<PromoAccount> page = new PageImpl<>(query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()).setMaxResults(pageable.getPageSize()).getResultList());
        return page;
    }

}

