package biz.korwin.web.service.home;

import java.util.List;

import biz.korwin.web.service.home.model.PaymentVO;

public interface IUserService {
	List<PaymentVO> getPaymentsByDate(String date);
	List<PaymentVO> getIncomingPayments(String date, int daysAhead);
	
}
