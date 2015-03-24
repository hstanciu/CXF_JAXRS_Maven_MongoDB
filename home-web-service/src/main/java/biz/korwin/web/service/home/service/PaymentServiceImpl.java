package biz.korwin.web.service.home.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.korwin.web.service.home.dao.IPaymentDAO;
import biz.korwin.web.service.home.model.PaymentTO;
import biz.korwin.web.service.home.model.PaymentVO;
/**
 * Service implementation for the payment web service.
 * */
@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentDAO paymentDAO;
	
	@Override
	public PaymentVO getPaymentById(long id) {
		
		PaymentTO paymentTO = paymentDAO.getPaymentById(id);
		PaymentVO paymentVO = new PaymentVO(paymentTO.getId(), paymentTO.getPayee(), paymentTO.getPayeeProduct(),
				paymentTO.getCycle(), paymentTO.getAmountInCents(), paymentTO.getDueDate(), 
				paymentTO.getPaymentLimitDate(), paymentTO.getPaidDate(), paymentTO.isDeprecated());
		return paymentVO;
		
	}

	@Override
	public PaymentVO create(PaymentVO newPayment) {
		
		PaymentTO paymentTO = new PaymentTO(newPayment.getPayee(), newPayment.getPayeeProduct(),
				newPayment.getCycle(), newPayment.getAmountInCents(), newPayment.getDueDate(), 
				newPayment.getPaymentLimitDate(), newPayment.getPaidDate(), newPayment.isDeprecated());
		
		paymentTO = paymentDAO.create(paymentTO);
		
		PaymentVO paymentVO = new PaymentVO(paymentTO.getId(), paymentTO.getPayee(), paymentTO.getPayeeProduct(),
				paymentTO.getCycle(), paymentTO.getAmountInCents(), paymentTO.getDueDate(), 
				paymentTO.getPaymentLimitDate(), paymentTO.getPaidDate(), paymentTO.isDeprecated());
		
		return paymentVO;
	}

	@Override
	public boolean delete(long id) {
		
		return paymentDAO.delete(id);
		
	}

	@Override
	public PaymentVO update(PaymentVO updatePayment) {
		
		PaymentTO paymentTO = new PaymentTO(updatePayment.getId(), updatePayment.getPayee(), updatePayment.getPayeeProduct(),
				updatePayment.getCycle(), updatePayment.getAmountInCents(), updatePayment.getDueDate(), 
				updatePayment.getPaymentLimitDate(), updatePayment.getPaidDate(), updatePayment.isDeprecated());
		
		paymentTO =  paymentDAO.update(paymentTO);
		
		PaymentVO paymentVO = new PaymentVO(paymentTO.getId(), paymentTO.getPayee(), paymentTO.getPayeeProduct(),
				paymentTO.getCycle(), paymentTO.getAmountInCents(), paymentTO.getDueDate(), 
				paymentTO.getPaymentLimitDate(), paymentTO.getPaidDate(), paymentTO.isDeprecated());
		
		return paymentVO;
		
	}

	@Override
	public List<PaymentVO> getPaymentsByDate(String date) {
		// TODO Auto-generated method stub
		
		List<PaymentTO> paymentsTOList = paymentDAO.getPaymentsByDate(date);
		
		List<PaymentVO> listOfPayments = new ArrayList<PaymentVO>();
		
		if(null != paymentsTOList){
			for(int i = 0; i < paymentsTOList.size(); i++){
				PaymentTO paymentTO = paymentsTOList.get(i);
				if(null != paymentTO){
					PaymentVO paymentVO = new PaymentVO(paymentTO.getId(), paymentTO.getPayee(), paymentTO.getPayeeProduct(),
											paymentTO.getCycle(), paymentTO.getAmountInCents(), paymentTO.getDueDate(), 
											paymentTO.getPaymentLimitDate(), paymentTO.getPaidDate(), paymentTO.isDeprecated());
					listOfPayments.add(paymentVO);
				}
			}
		}
		
		
		return listOfPayments;
	}
	
	

}
