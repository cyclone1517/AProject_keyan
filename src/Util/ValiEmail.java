package Util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ValiEmail {
	public static String myEmailAccount = "cyl1517@yeah.net";
    public static String myEmailPassword = "ad79ret85";
    public static String myEmailSMTPHost = "smtp.";	//不完整的host
    public static String receiveMailAccount = null;
	
	public static boolean send(String receiveMail,String title, String yanzhengma) {
		receiveMailAccount=receiveMail;
		System.out.println(receiveMailAccount);
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		
		//现适用于大部分smtp服务器地址与邮箱@后字符串相同的邮箱
		int indexOfAt = receiveMail.lastIndexOf('@');
		myEmailSMTPHost = "smtp.";	//因为是静态类 每次更新前初始化
		myEmailSMTPHost += receiveMail.substring(indexOfAt+1);
		System.out.println(myEmailSMTPHost);
	
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		Session session=Session.getInstance(props);
		try {
			//无法发给qq邮箱
			MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, title,yanzhengma);
			//System.out.println("sth wrong1");
			Transport transport = session.getTransport();
			//System.out.println("sth wrong2");
			transport.connect(myEmailAccount, myEmailPassword);
			//System.out.println("sth wrong3");
			transport.sendMessage(message, message.getAllRecipients());
			//System.out.println("sth wrong4");
			transport.close();
		} catch (Exception e) {
			
			return false;
		}
		//System.out.println("correct");
		return true;
	}


	 public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String title,String yanzhengma) throws Exception {
	        // 1. 创建一封邮件
	        MimeMessage message = new MimeMessage(session);

	        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
	        message.setFrom(new InternetAddress(sendMail, "科研项目展示系统开发小组", "UTF-8"));

	        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        
	        message.addRecipient(MimeMessage.RecipientType.CC, new InternetAddress(sendMail, "尊敬的用户您好", "UTF-8"));
	        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "尊敬的用户您好", "UTF-8"));

	        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
	        message.setSubject(title, "UTF-8");

	        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
	        message.setContent("验证码是:"+yanzhengma, "text/html;charset=UTF-8");

	        // 6. 设置发件时间
	        message.setSentDate(new Date());

	        // 7. 保存设置
	        message.saveChanges();

	        return message;
	    }
	
	
}
