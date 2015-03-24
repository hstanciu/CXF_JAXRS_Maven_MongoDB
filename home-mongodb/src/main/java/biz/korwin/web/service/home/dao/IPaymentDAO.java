package biz.korwin.web.service.home.dao;


import java.util.List;

import biz.korwin.web.service.home.model.PaymentTO;

/** 
 * DAO interface for accessing the Payments data source.
 * */
public interface IPaymentDAO {
	
	/* Returns a payment by payment ID. */
	public PaymentTO getPaymentById(long id);
	
	/* Creates a payment. */
	public PaymentTO create(PaymentTO newPayment);
	
	/* Deletes a payment. */
	public boolean delete(long id);	
	
	/* Updates a payment. */
	public PaymentTO update(PaymentTO updatePayment);
	
	/* Returns the list of payments that have the same payment limit date. */
	public List<PaymentTO> getPaymentsByDate(String date);
}
