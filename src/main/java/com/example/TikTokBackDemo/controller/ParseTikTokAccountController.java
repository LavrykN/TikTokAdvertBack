package com.example.TikTokBackDemo.controller;

import com.example.TikTokBackDemo.dto.ParseDto;
import com.example.TikTokBackDemo.dto.ParseResponse;
import com.example.TikTokBackDemo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parse")
@RequiredArgsConstructor
public class ParseTikTokAccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity parseTikTokAccount(@RequestBody ParseDto parseDto) {
        ParseResponse parseResponse = new ParseResponse();

        if (accountService.findByUsername(parseDto.getUsername()).isPresent()){
            parseResponse.setAdded(true);
            return ResponseEntity.status(HttpStatus.OK).body(parseResponse);
        }

        try{
            String docCustomConn = Jsoup.connect("https://www.tiktok.com/node/share/user/@" + parseDto.getUsername())
                    .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36")
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();

            JSONObject myResponse = new JSONObject(docCustomConn).getJSONObject("body").getJSONObject("userData");

            String bio = myResponse.getString("signature");

            parseResponse.setBio(bio);
            parseResponse.setUsername(myResponse.getString("uniqueId"));
            parseResponse.setFans(myResponse.getInt("fans"));
            parseResponse.setHeart(myResponse.getInt("heart"));
            parseResponse.setUrlImage(String.valueOf(myResponse.getJSONArray("coversMedium").get(0)));

        }catch (Exception e){
            System.out.println("Error " + e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(parseResponse);
    }
}
