package com.wsh;

import com.wsh.pojo.SmsParam;
import com.wsh.script.TencentSmsScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class AustinApplication {
    public static void main(String[] args) {
        SpringApplication.run(AustinApplication.class, args);
    }
}
