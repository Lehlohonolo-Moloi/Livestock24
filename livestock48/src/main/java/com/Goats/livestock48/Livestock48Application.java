package com.Goats.livestock48;

import com.Goats.livestock48.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Livestock48Application {
	static Customer me;
	public static void setSelf(Customer customer){
		me = customer;
	}

	public static Customer getSelf(){
		return me;
	}

	public static String getRegisteredUser(){
		if (me != null){
			return me.getFirstName();
		}
		else return "You Are Not Registered";
	}
	public static void main(String[] args) {
		SpringApplication.run(Livestock48Application.class, args);
	}

}
