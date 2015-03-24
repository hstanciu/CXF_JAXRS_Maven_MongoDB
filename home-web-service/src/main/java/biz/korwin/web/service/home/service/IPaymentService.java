package biz.korwin.web.service.home.service;

import java.util.List;

import biz.korwin.web.service.home.model.PaymentVO;
/**
 * Service interface for implementing the payment web service.
 * */
public interface IPaymentService {
		
	/* Returns a payment by payment ID. */
	public PaymentVO getPaymentById(long id);
	
	/* Creates a payment. */
	public PaymentVO create(PaymentVO newPayment);
	
	/* Deletes a payment. */
	public boolean delete(long id);	
	
	/* Updates a payment. */
	public PaymentVO update(PaymentVO updatePayment);	
	
	/* Returns the list of payments that have the same payment limit date. */
	public List<PaymentVO> getPaymentsByDate(String date);
	
}
