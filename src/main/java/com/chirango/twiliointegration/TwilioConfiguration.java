package com.chirango.twiliointegration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwilioConfiguration {

    @Value("${account_sid")
    private String accountSid;

    @Value("${auth_token")
    private String authToken;

    @Value("${to_phone_number")
    private String toPhoneNumber;

    @Value("${from_phone_number")
    private String fromPhoneNumber;
}
