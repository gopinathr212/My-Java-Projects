package com.advento.numberpatternms.service.impl;

import org.springframework.stereotype.Service;

import com.advento.numberpatternms.service.NumberPatService;
@Service(value = "numberpatternserviceimpl")
public class NumberPatServiceImpl implements NumberPatService{
   
	public  String loopOne() {
		String a="";
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				a+=(i + " ");
			}
			a+=("\n");
		}
		return a;
	}
	
	public  String loopTwo() {
		String b="";
		int n = 1;
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				b+=(n + " ");
				n++;
			}
			b+=("\n");
		}
		return b;
	}
	
	public String loopThree() {
		String c="";
		for (int i = 0; i <= 5; i++) {
			for (int j = 1; j < i; j++) {
				c+=(j + " ");
			}
			c+=("\n");
		}
		return c;
	}
}
