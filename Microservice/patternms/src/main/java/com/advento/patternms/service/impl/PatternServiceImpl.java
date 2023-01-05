package com.advento.patternms.service.impl;

import org.springframework.stereotype.Service;

import com.advento.patternms.service.PatternService;

@Service(value = "patternserviceimpl")
public class PatternServiceImpl implements PatternService{

	@Override
	public String loopOne() {
		 String k ="";
		// TODO Auto-generated method stub
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <i; j++) {
				k += ("* ");
			}
			k += ("\n");
		}
		return k;
	}
	
	public  String loopTwo() {
		String m="";
		for (int i = 5; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				m +=("*" + " ");
			}
			m+=("\n");
		}
		return m;
	}
	
	public  String loopThree() {
		String a="";
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j <= i; j++) {
				a+=(" ");
			}
			for (int k = 0; k < 6 - i; k++) {
				a+=("* ");
			}
			a+=("\n");
		}
		return a;
	}
	
	public  String loopFour() {
		String b="";
		int i, j, k;
		for (i = 0; i < 6; i++) {
			for (j = 6 - i; j > 1; j--) {
				b +=(" ");
			}
			for (k = 0; k <= i; k++) {
				b +=("* ");
			}
			b +=("\n");
		}
		return b;
	}
	
	public  String loopFive() {
		String c="";
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j > i; j--) {
				c+=(" ");
			}
			for (int k = 1; k <= (i * 2) - 1; k++) {
				c+=("*");
			}
			c+=("\n");
		}
		for (int i = 5 - 1; i >= 1; i--) {
			for (int j = 5 - 1; j >= i; j--) {
				c+=(" ");
			}
			for (int k = 1; k <= (i * 2) - 1; k++) {
				c+=("*");
			}

			c+=("\n");
		}
		return c;
	}
    
	public  String loopSix() {
		String d="";
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				d+=("*");
			}
			d+=("\n");
		}

		for (int i = 1; i < 5; i++) {
			for (int j = 4; j >= i; j--) {
				d+=("*");
			}
			for (int k = 1; k < i; k++) {
				d+=(" ");
			}

			d+=("\n");
		}
		return d;
	}


}
