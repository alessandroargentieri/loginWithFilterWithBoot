package com.quicktutorialz.secux.Secux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SecuxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuxApplication.class, args);
	}
}
