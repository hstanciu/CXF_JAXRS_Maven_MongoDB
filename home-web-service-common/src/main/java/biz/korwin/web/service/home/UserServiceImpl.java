package biz.korwin.web.service.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import biz.korwin.web.service.home.model.PaymentVO;
import biz.korwin.web.service.home.model.PaymentsVO;

@Service
public class UserServiceImpl implements IUserService {

	public static final String SERVER_URI = "http://localhost:8080/home-web-service/rest/";
	
	@Override
	public List<PaymentVO> getPaymentsByDate(String date) {
		
		RestTemplate restTemplate = new RestTemplate();
		PaymentsVO paymentsWS = restTemplate.getForObject(SERVER_URI+"payments/date/"+date, PaymentsVO.class);

		List<PaymentVO> payments;
		if(null == paymentsWS){
			payments = new ArrayList<>();
		}else{
			payments = paymentsWS.getPayments();
		}
		
		return payments;
	}

	@Override
	public List<PaymentVO> getIncomingPayments(String date, int daysAhead) {
		// TODO Auto-generated method stub
		return null;
	}

}
