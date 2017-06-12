//package com.niit.kingfisherfrontend.sms;
//
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class Smstoclient 
//{
//     public void  sendsms(String messages,Long no)
//     {
//    	 try {
//    		 System.out.println(no);
//    		 System.out.println(messages);
// 			// Construct data
// 			String user = "username=" +"arunsaha05081993@gmail.com";
// 			String hash = "&hash=" + "c38e80491b72162f9fcb7de6cc4f81ee4b0a9f98d3543934acce7ca3f9b73295";
// 			String message = "&message=" + messages;
// 			String sender = "&sender=" + "OTP";
// 			String numbers = "&numbers=" + no;
// 			
// 			// Send data
// 			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.textlocal.in/send/?").openConnection();
// 			String data = user + hash + numbers + message + sender;
// 			conn.setDoOutput(true);
// 			conn.setRequestMethod("POST");
// 			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
// 			conn.getOutputStream().write(data.getBytes("UTF-8"));
// 			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
// 			final StringBuffer stringBuffer = new StringBuffer();
// 			String line;
// 			while ((line = rd.readLine()) != null) {
// 				stringBuffer.append(line);
// 			}
// 			rd.close();
// 			
// 			
// 		} catch (Exception e) {
// 			System.out.println("Error SMS "+e);
// 					}
// 	}
//  }
//
