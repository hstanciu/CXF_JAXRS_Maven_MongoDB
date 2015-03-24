package biz.korwin.web.service.home.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * This is a way to deal with returning an array in the response. The array 
 * of PaymentVOs is wrapped inside a PaymentsVO.
 * */
@XmlRootElement(name="paymentsList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentsVO {
	
	public List<PaymentVO> payments;

	public List<PaymentVO> getPayments() {
		return this.payments;
	}

	public void setPayments(List<PaymentVO> payments) {
		this.payments = payments;
	}
}
