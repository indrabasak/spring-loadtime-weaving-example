package com.basaki.service;

import java.text.MessageFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"squid:S2629"})
public class UselessService {

    private static final Logger
            log = LoggerFactory.getLogger(UselessService.class);

    public void sayHello(String name) {
        log.info(MessageFormat.format("Hello {0}", name));
    }
}
