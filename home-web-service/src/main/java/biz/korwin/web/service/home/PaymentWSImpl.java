package biz.korwin.web.service.home;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import biz.korwin.web.service.home.model.PaymentVO;
import biz.korwin.web.service.home.model.PaymentsVO;
import biz.korwin.web.service.home.service.IPaymentService;

/**
 * Web service implementation.
 * */
@Component("paymentsService")
public class PaymentWSImpl implements IPaymentWS {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	
	@Autowired
	IPaymentService paymentService;
	
	@Override
	public PaymentsVO getPaymentsByDate(String date) {

		
		List<PaymentVO> listOfPayments = paymentService.getPaymentsByDate(date);
		PaymentsVO payments = new PaymentsVO();
		payments.setPayments(listOfPayments);
		
		return payments;
		
	}

	

	@Override
	public Response delete(long id) {
		
		if(paymentService.delete(id)){
			return Response.status(Status.OK).build();
		}else{
			return Response.status(Status.EXPECTATION_FAILED).build();
		}
	}

	@Override
	public PaymentVO update(long id, String payee,
			String payeeProduct,
			int cycle,
			int amountInCents,
			String dueDate,
			String paymentLimitDate,
			boolean deprecated) {
		
		PaymentVO updatePayment = new PaymentVO();
		
		updatePayment.setId(id);
		updatePayment.setPayee(payee);
		updatePayment.setPayeeProduct(payeeProduct);
		updatePayment.setCycle(cycle);
		updatePayment.setAmountInCents(amountInCents);
		updatePayment.setDueDate(dueDate);
		updatePayment.setPaymentLimitDate(paymentLimitDate);
		//updatePayment.setPaidDate(paidDate);
		updatePayment.setDeprecated(deprecated);
		
		
		PaymentVO paymentUpdated = paymentService.update(updatePayment);
		
		return paymentUpdated;
	}

	@Override
	public PaymentVO getPaymentById(long id) {
		
		PaymentVO payment = paymentService.getPaymentById(id);

		return payment;
	}



	@Override
	public PaymentVO create(String payee, String payeeProduct,
			int cycle, int amountInCents, String dueDate,
			String paymentLimitDate, boolean deprecated) {
		
		PaymentVO payment = new PaymentVO();
		payment.setAmountInCents(amountInCents);
		payment.setCycle(cycle);
		payment.setDueDate(dueDate);
		payment.setPaidDate(null);
		payment.setPayee(payee);
		payment.setPayeeProduct(payeeProduct);
		payment.setPaymentLimitDate(paymentLimitDate);
		
		PaymentVO createdPayment = paymentService.create(payment);
		
		return createdPayment;
	}

	
}
