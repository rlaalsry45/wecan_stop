package com.z5.zcms.util;

import com.z5.zcms.admsys.user.service.ZUserService;
import egovframework.com.cmm.service.EgovProperties;
import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

import static com.z5.zcms.util.ZPrint.print;


@Controller
public class FormMail {

    public static boolean sendMail(DataTable input) throws Exception {
        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("localhost");
        //email.setHostName("smtp.gmail.com");
        //email.setSmtpPort(465);
        //email.setSSL(true);
        email.addTo(input.get("mail1") + "@" + input.get("mail2"), input.get("mail1") + "@" + input.get("mail2"));
        email.setFrom("admin@zsol.co.kr", input.get("sender"));
        //email.setAuthentication("ykslck@gmail.com", "Lzy01150");
        //email.setFrom("ykslck@gmail.com", "ykslck");
        email.setSubject(input.get("title"));
        email.setMsg(input.get("conts"));
        email.setCharset("UTF-8");

        if (!input.get("attach").equals("")) {
            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(input.get("attach"));
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription(input.get("attach_org"));
            attachment.setName(MimeUtility.encodeText(input.get("attach_org")));

            // add the attachment
            email.attach(attachment);
        }

        // send the email
        email.send();

        return true;
    }

    public static boolean sendMail(String to, String from, String title, String msg) throws Exception {
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("localhost");
        email.addTo(to);
        email.setFrom(from, "관리자");
        email.setSubject(title);
        email.setMsg(msg);
        email.setCharset("UTF-8");

        // send the email
        email.send();

        return true;
    }

    public static boolean sendMail(String to, String from, String fromName, String title, String msg) throws Exception {

        String     host       = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.from", from); //반송이메일주소

        Session   session   = Session.getDefaultInstance(properties);
        Multipart multiPart = new MimeMultipart("alternative");

        try {
            MimeMessage  message  = new MimeMessage(session);
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(msg, "text/html; charset=utf-8");

            InternetAddress addr = new InternetAddress(from, fromName, "euc-kr");
            message.setFrom(addr);
//	         message.setReplyTo(InternetAddress.parse("postmaser@demo.zsol.co.kr", false)); //회신 주소

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            multiPart.addBodyPart(htmlPart);

            message.setSubject(MimeUtility.encodeText(title, "utf-8", "B"));

            // Now set the actual message
            message.setContent(multiPart);

            // Send message
            Transport.send(message);
            //System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean sendMail(String to, String from, String fromName, String title, String msg, String filename) throws Exception {
        String     host       = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session   session   = Session.getDefaultInstance(properties);
        Multipart multiPart = new MimeMultipart("alternative");

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSentDate(new Date());


            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(msg, "text/html; charset=utf-8");
            multiPart.addBodyPart(htmlPart);
            message.setSubject(MimeUtility.encodeText(title, "utf-8", "B"));

            //attach
            BodyPart   multibodypart = new MimeBodyPart();
            DataSource source        = new FileDataSource(filename);
            multibodypart.setDataHandler(new DataHandler(source));
            multibodypart.setFileName(filename.substring(filename.lastIndexOf("/")));
            multiPart.addBodyPart(multibodypart);

            // Now set the actual message
            message.setContent(multiPart);

            // Send message
            Transport.send(message, message.getAllRecipients());

            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean sendMail(String to, String subject, String content) throws Exception {
        String host = EgovProperties.getProperty("Globals.mail.host");
        String from = EgovProperties.getProperty("Globals.mail.from");
        String name = EgovProperties.getProperty("Globals.mail.name");
//        print("host = " + host);
//        print("from = " + from);
//        print("name = " + name);
//        print("rcpt = " + to);
//        print("head = " + subject);

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.from", from);

        Session   session   = Session.getDefaultInstance(properties);
        Multipart multiPart = new MimeMultipart("alternative");

        try {
            MimeMessage     mime = new MimeMessage(session);
            InternetAddress addr = new InternetAddress(from, name, "utf-8");
            mime.setFrom(addr);
            mime.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(content, "text/html; charset=utf-8");
            multiPart.addBodyPart(htmlPart);

            mime.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));
            mime.setContent(multiPart);

            Transport.send(mime); // Send message
        } catch (MessagingException me) {
            me.printStackTrace();
            Exception ex = me;
            if (ex instanceof SendFailedException) {
                SendFailedException sfex    = (SendFailedException) ex;
                Address[]           invalid = sfex.getInvalidAddresses();
                if (invalid != null) {
                    System.out.println(" ** Invalid Addresses");
                    for (javax.mail.Address it : invalid) {
                        System.out.println(" " + it);
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static boolean sendMail(ArrayList<String> to, String from, String title, String msg) throws Exception {
        for (int i = 0; null != to && i < to.size(); i++) {
            sendMail(to.get(i), from, title, msg);
        }
        return true;
    }

    public static void templateMail(List<String> tos, String subject, String template, Map<String, Object> values) {
        try {
            print("tos", tos);
            String content = StrSubstitutor.replace(FileUtil.readFile(template), values);
            for (String to : tos) {
                sendMail(to, subject, content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
