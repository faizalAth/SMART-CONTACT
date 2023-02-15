package com.smart.contact;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactManagerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ContactManagerApplication.class, args);
		Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://127.0.0.1:8088/CONTACT-MANAGER/home");
	}
}
