package com.yassine.methods;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class MailFinder {

	public List<String> emaillist (String url){
		
		List<String> emailList = new ArrayList<String>();

	    try {
	        Document doc = Jsoup.connect(url)
	                .userAgent("Mozilla")
	                .get();

	        Pattern p = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
	        Matcher matcher = p.matcher(doc.body().html());
	        while (matcher.find()) {
	            emailList.add(matcher.group());
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return emailList;
	}
	public List<String> urlReader(String  path) {
		List<String> urls=new ArrayList<String>();
		try {
			
			BufferedReader reader=new BufferedReader(new FileReader(path));
			String line=reader.readLine();
			while (line!=null) {
				urls.add(line);
				line=reader.readLine();
			}
			reader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return urls;
	}
	
	
}
