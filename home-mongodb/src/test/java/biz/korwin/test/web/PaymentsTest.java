package biz.korwin.test.web;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.korwin.web.service.home.dao.IPaymentDAO;
import biz.korwin.web.service.home.model.PaymentTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class PaymentsTest {

	@Autowired
	private IPaymentDAO paymentsDAO;
	
	
	@Test
	public void testRead() {
		
		PaymentTO paymentTO = paymentsDAO.getPaymentById(1L);
		
		System.out.println(paymentTO);
	
	}
	
	
	@Test
	public void testGetPaymentsByDate() {
		
		List<PaymentTO> listOfPayments = paymentsDAO.getPaymentsByDate("20150328");
		
		System.out.println(listOfPayments);
	
	}

}
