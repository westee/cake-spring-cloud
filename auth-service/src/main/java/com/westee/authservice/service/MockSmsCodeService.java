package com.westee.authservice.service;

import org.springframework.stereotype.Service;

@Service
public class MockSmsCodeService implements SmsCodeService {

    @Override
    public String sendCode(String tel) {
        return "000000";
    }
}
