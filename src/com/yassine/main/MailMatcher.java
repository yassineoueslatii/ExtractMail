package com.yassine.main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.yassine.methods.MailFinder;

public class MailMatcher {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<String> emailList;
		String url= "";
		MailFinder mailFinder=new MailFinder();
		List<String> urls=mailFinder.urlReader("src/Files/input.txt");
		for (String urll : urls) {
			
			url=urll;
			emailList=mailFinder.emaillist(urll);
		    
		    for (String string : emailList) {
		    	System.out.println(string);
				
			}
		}
		
		
	}
	}

