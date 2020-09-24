package com.example.TikTokBackDemo.service;

import com.example.TikTokBackDemo.domain.Account;
import com.example.TikTokBackDemo.domain.PromoAccount;
import com.example.TikTokBackDemo.dto.FilterDTO;
import com.example.TikTokBackDemo.dto.MaxValueDTO;
import com.example.TikTokBackDemo.dto.PromoAccountDTO;
import com.example.TikTokBackDemo.repository.AccountRepository;
import com.example.TikTokBackDemo.repository.PromoAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PromoAccountRepository promoAccountRepository;


    @Override
    public PromoAccountDTO create(PromoAccountDTO promoAccountDTO) {
        Account account = new Account(promoAccountDTO.getAccountInfo());
        accountRepository.save(account);

        PromoAccount promoAccount = new PromoAccount(
                account,
                promoAccountDTO.getPrice(),
                promoAccountDTO.getDescription(),
                promoAccountDTO.getTheme(),
                promoAccountDTO.getContact(),
                promoAccountDTO.getDate()
        );
        promoAccountRepository.save(promoAccount);

        return promoAccountDTO;
    }

    @Override
    public List<PromoAccount> getAll(Integer pageNo, Integer pageSize) {
        return promoAccountRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by("date").descending())).getContent();
    }

    @Override
    public List<PromoAccount> getByFilter(FilterDTO filterDTO) {
        return promoAccountRepository.filter(filterDTO, PageRequest.of(filterDTO.getPageNo(), filterDTO.getPageSize())).getContent();
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public MaxValueDTO getMaxValue() {
        Long[] values = promoAccountRepository.getMaxPrice().get(0);
        MaxValueDTO maxValueDTO = new MaxValueDTO(values[1],values[0],values[2]);
        return maxValueDTO;
    }


}
