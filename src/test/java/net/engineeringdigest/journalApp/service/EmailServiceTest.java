//package net.engineeringdigest.journalApp.service;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//@Import(EmailService.class)
//class EmailServiceTest {
//
//    @Autowired
//    private EmailService emailService;
//
//    @MockBean
//    private JavaMailSender mailSender;
//
//    @Test
//     void testSendEmail() {
//        emailService.sendEmail("tes@gmail.com",
//                "Testing java mail sender",
//                "Hi! How r u");
//    }
//
//}
