package com.Inventory.MWJ.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Inventory.MWJ.Model.Usermails;
import com.Inventory.MWJ.Repository.UserMailsRepository;

@Service
public class UsermailsService implements UsermailsServices {

	private JavaMailSender mailsender;

	@Autowired
	private UserMailsRepository mailrepo;

	@Autowired
	public UsermailsService(JavaMailSender mailsender) {
		this.mailsender = mailsender;
	}

	public void sendmails(Usermails user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("sreekarkoushik@gmail.com");
		mail.setSubject("Password Recover");
		mail.setText(user.getCouponsdistributed().toString());
		mail.setSentDate(user.getDate());
		mailsender.send(mail);
		mailrepo.save(user);

	}

}
