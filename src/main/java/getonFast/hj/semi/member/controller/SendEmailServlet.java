package getonFast.hj.semi.member.controller;



import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/sendEmail")
public class SendEmailServlet extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	   HttpSession my_session = req.getSession();
	   
      // 입력 받은 이메일
      String inputEmail = req.getParameter("inputEmail");
      
         // 메일 인코딩
       final String bodyEncoding = "UTF-8"; //콘텐츠 인코딩
       
       String subject = "안녕하세요 빌려듀오입니다.";
       String fromEmail = "rentadmin@spcerent.com";
       String fromUsername = "빌려듀오 관리자";
       String toEmail = inputEmail; // 콤마(,)로 여러개 나열
       
       final String username = "lswk1873@gmail.com";         
       final String password = "dltkddnjs1!";
       
       String encode = URLEncoder.encode(inputEmail, "UTF-8");
       String hostPath = req.getRequestURL().substring(0, ((req.getRequestURL().length() - req.getRequestURI().length())));
       String url = hostPath + req.getContextPath() + "/member/findUpdatePwd?email=" + encode;
       System.out.println(url);
       System.out.println(req.getRequestURL());
       System.out.println(hostPath);
       System.out.println("==========================");
       
       // 메일에 출력할 텍스트
       StringBuffer sb = new StringBuffer();
       sb.append("<h3>안녕하세요</h3>\n");
       sb.append("<h4>비밀번호 변경 링크입니다.</h4>\n");    
       sb.append("<h2><a href='" + url + "'>비밀번호링크</a></h2>");
       
       
       String html = sb.toString();
       
       // 메일 옵션 설정
       Properties props = new Properties();    
       props.put("mail.transport.protocol", "smtp");
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.port", "587");
       props.put("mail.smtp.auth", "true");
    
       props.put("mail.smtp.quitwait", "false");
       props.put("mail.smtp.socketFactory.port", "587");
       props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       props.put("mail.smtp.socketFactory.fallback", "true");
       props.put("mail.smtp.starttls.enable","true");
       
       try {
         // 메일 서버  인증 계정 설정
         Authenticator auth = new Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(username, password);
           }
         };
         
         // 메일 세션 생성
         //Session session = Session.getInstance(props, auth);
         Session session = Session.getDefaultInstance(props);
         
         // 메일 송/수신 옵션 설정
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(fromEmail, fromUsername));
         message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail, false));
         message.setSubject(subject);
         message.setSentDate(new Date());
         
         // 메일 콘텐츠 설정
         Multipart mParts = new MimeMultipart();
         MimeBodyPart mTextPart = new MimeBodyPart();
         MimeBodyPart mFilePart = null;
    
         // 메일 콘텐츠 - 내용
         mTextPart.setText(html, bodyEncoding, "html");
         mParts.addBodyPart(mTextPart);
               
         // 메일 콘텐츠 설정
         message.setContent(mParts);
         
         // MIME 타입 설정
         MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
         MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
         MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
         MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
         MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
         MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
         CommandMap.setDefaultCommandMap(MailcapCmdMap);
    
         // 메일 발송
         Transport t = session.getTransport("smtp");
         t.connect(username, password);   
         t.sendMessage(message, message.getAllRecipients());
         t.close();
         
         //Transport.send( message );
         
         resp.sendRedirect(req.getContextPath());
         
       } catch ( Exception e ) {
         e.printStackTrace();
       }
   }
}