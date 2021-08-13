package com.revature.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckAccount {

	@Before("execution(public void addAccount())")
	public void checkAddAccount() {
		System.out.println("Checking account");
	}
}
