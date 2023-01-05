package com.advento.printms.service.impl;

import org.springframework.stereotype.Service;

import com.advento.printms.service.PrintService;
@Service(value = "printserviceimpl")
public class PrintServiceImpl implements PrintService{
        
	public  String div(int length) {
		String a="";
		for (int i = 1; i <= length; i++) {
			if (i % 11 == 0) {
				a+=(i + " ");
                }
			}
		return a;
	}
	

	@Override
	public String even(int length) {
		String b="";
		for (int i = 1; i <= length; i++) {
			if (i % 2 == 0) {
				b+=(i + " ");
			}
		}
		return b;
	}
	
	public String odd(int length) {
		String c="";
		for (int i = 1; i <= length; i++) {
			if (i % 2 != 0) {
				c+=(i + " ");
			}
		}
		return c;
	}
}
