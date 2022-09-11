package tracker.com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import tracker.com.TrackerProperties;
import tracker.com.entity.WorkTime;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class EmailService {

    private static final String EMPLOYEE = "employee";
    private static final String WORK_TIME = "workTime";
    private static final String BASE_URL = "baseUrl";

    private final TrackerProperties trackerProperties;
    private final JavaMailSender javaMailSender;
    private final MessageSource messageSource;
    private final SpringTemplateEngine templateEngine;

    public EmailService(
            TrackerProperties trackerProperties,
            JavaMailSender javaMailSender,
            MessageSource messageSource,
            SpringTemplateEngine templateEngine
    ) {
        this.trackerProperties = trackerProperties;
        this.javaMailSender = javaMailSender;
        this.messageSource = messageSource;
        this.templateEngine = templateEngine;
    }

    @Async
    public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
        log.debug(
                "Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
                isMultipart,
                isHtml,
                to,
                subject,
                content
        );
        // Prepare message using a Spring helper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
            message.setTo(to);
            message.setFrom(trackerProperties.getMail().getFrom());
            message.setSubject(subject);
            message.setText(content, isHtml);
            javaMailSender.send(mimeMessage);
            log.info("Sent email to User '{}'", to);
        } catch (MailException | MessagingException e) {
            log.warn("Email could not be sent to user '{}'", to, e);
        }
    }

    @Async
    public void sendEmailFromTemplate(WorkTime workTime, String templateName, String subject) {
        Context context = new Context();
        context.setVariable(EMPLOYEE, workTime.getEmployee());
        context.setVariable(WORK_TIME, workTime);
        context.setVariable(BASE_URL, trackerProperties.getMail().getBaseUrl());
        String content = templateEngine.process(templateName, context);
        sendEmail(workTime.getEmployee().getEmail(), subject, content, false, true);
    }

    @Async
    public void sendCreatedEmail(WorkTime workTime) {
        log.info("Sending work time creation, email to '{}'", workTime.getEmployee().getEmail());
        String subject = "Saisie des Temps: " + workTime.getMonth() + " " + workTime.getMonth();
        sendEmailFromTemplate(workTime, "mail/workTimeCreatedEmail", subject);
    }

}
