package com.example.TikTokBackDemo.controller;

import com.example.TikTokBackDemo.domain.PromoAccount;
import com.example.TikTokBackDemo.dto.FilterDTO;
import com.example.TikTokBackDemo.dto.MaxValueDTO;
import com.example.TikTokBackDemo.dto.PromoAccountDTO;
import com.example.TikTokBackDemo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping()
    private ResponseEntity createAccount(@RequestBody PromoAccountDTO promoAccountDTO){
        accountService.create(promoAccountDTO);
        return new ResponseEntity(true, HttpStatus.OK);
    }

    @GetMapping()
    private List<PromoAccount> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                      @RequestParam(defaultValue = "5") Integer pageSize
    ){
        return accountService.getAll(pageNo, pageSize);
    }

    @PostMapping("/filter")
    private List<PromoAccount> getAllByFilter(@RequestBody FilterDTO filterDTO){
        return accountService.getByFilter(filterDTO);
    }

    @GetMapping("/maxvalue")
    private MaxValueDTO getMaxValue(){
        return accountService.getMaxValue();
    }

    @GetMapping("/testTG")
    private void testTG(){
        sendToTelegram();
    }

    public static void sendToTelegram() {
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

        String apiToken = "863343055:AAEC2gO7hBjZg3EsFn-tYAVQpIFiyYkupwY";
        String chatId = "-1001299264251";
        String text = "Hello";

        urlString = String.format(urlString, apiToken, chatId, text);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
