package biz.korwin.web.service.home.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import biz.korwin.web.service.home.IUserService;
import biz.korwin.web.service.home.model.PaymentVO;

@Component
public class PaymentsChecker {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private EmailSender emailSender;
	
	@Value("${email.receivers}")
	private List<String> emailReceivers;
	
	@Scheduled(fixedRateString="${check.period}")
	public void checkPayments(){
		
		List<PaymentVO> listOfPayments = userService.getPaymentsByDate("20150328");
		
		if(null != listOfPayments && listOfPayments.size() > 0){
			StringBuilder msg = new StringBuilder();
			msg.append("Ceau, \nAzi trebuiesc platite urmatoarele:\n");
			
			for(PaymentVO payment : listOfPayments){
				msg = msg.append(payment.getPayee()).append(", ")
						.append(payment.getPayeeProduct()).append(" ")
						.append(payment.getAmountInCents()/100).append("$ Data limita este:")
						.append(payment.getPaymentLimitDate());
			}
			
			for(String receiver : emailReceivers){
				emailSender.sendMail("hstanciu@gmail.com", receiver, "Payments of the day", msg.toString());
			}
			
		}
		System.out.println("JOb running");
	}
}
