package biz.korwin.web.service.home;



import org.springframework.stereotype.Component;

import biz.korwin.web.service.home.model.PaymentVO;
import biz.korwin.web.service.home.model.PaymentsVO;

@Component
public interface IPaymentWS {
	/* Returns the list of payments that have the same payment limit date. */
	public PaymentsVO getPaymentsByDate(String date);
	
	/* Returns a payment by payment ID. */
	public PaymentVO getPaymentById(long id);
	
	/* Creates a payment. */
	public PaymentVO create(String payee, String payeeProduct,
			int cycle, int amountInCents, String dueDate,
			String paymentLimitDate, boolean deprecated);
	
	/* Deletes a payment. */
	public boolean delete(long id);	
	
	/* Updates a payment. */
	public PaymentVO update(long id, String payee,
			String payeeProduct,
			int cycle,
			int amountInCents,
			String dueDate,
			String paymentLimitDate,
			boolean deprecated);	
}
