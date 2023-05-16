package com.dgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//@ServletComponentScan
public class AppWalletApplication {
    public static void main(String[] args){
        SpringApplication.run(AppWalletApplication.class,args);
    }
}
