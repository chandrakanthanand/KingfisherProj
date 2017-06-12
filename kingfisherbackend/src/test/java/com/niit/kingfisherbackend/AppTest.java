//package com.niit.kingfisherbackend;
//
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//package com.memorynotfound.qrcode;
//
//import net.glxn.qrgen.core.image.ImageType;
//import net.glxn.qrgen.core.vcard.VCard;
//import net.glxn.qrgen.javase.QRCode;
//import java.io.*;
///**
// * Unit test for simple App.
// */
//
//public class CreateQrCodeVCard
//{
//public static void main(String[] args)
//{
//        VCard vCard = new VCard();
//        vCard.setName("memorynotfound.com");
//        vCard.setAddress("street 1, xxxx address");
//        vCard.setCompany("company Inc.");
//        vCard.setPhoneNumber("+xx/xx.xx.xx");
//        vCard.setTitle("title");
//        vCard.setEmail("info@memorynotfound.com");
//        vCard.setWebsite("http://memorynotfound.com");
//
//
//        ByteArrayOutputStream bout =
//                QRCode.from(vCard)
//                        .withSize(250, 250)
//                        .to(ImageType.PNG)
//                        .stream();
//
//        try {
//            OutputStream out = new FileOutputStream("/tmp/qr-code-vcard.png");
//            bout.writeTo(out);
//            out.flush();
//            out.close();
//
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}