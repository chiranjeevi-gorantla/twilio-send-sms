package com.chirango.twiliointegration.controller;

import com.chirango.twiliointegration.TwilioConfiguration;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SmsController {

    @Autowired
    private TwilioConfiguration twilioConfiguration;

    @GetMapping("/sendSMS")
    public ResponseEntity<String> sendSMS() {
        Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());

        Message.creator(
                new PhoneNumber(twilioConfiguration.getToPhoneNumber()),
                new PhoneNumber(twilioConfiguration.getFromPhoneNumber()),
                "Hello from Twilio 📞")
                .create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }

}
