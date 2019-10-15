package com.Inventory.MWJ.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.MWJ.Model.Usermails;
import com.Inventory.MWJ.Service.UsermailsServices;

@RestController
@RequestMapping("/send")
public class NotificationController {

	@Autowired
	private UsermailsServices usermailservice;

	@PostMapping("/mails")
	public String sendmails(@RequestBody Usermails mail)

	{
		try {
			usermailservice.sendmails(mail);

		} catch (MailException m) {

		}

		return "mail sent successully";
	}

}
