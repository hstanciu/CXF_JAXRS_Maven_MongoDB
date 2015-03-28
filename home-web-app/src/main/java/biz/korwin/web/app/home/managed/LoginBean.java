package biz.korwin.web.app.home.managed;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import biz.korwin.web.service.home.IUserService;
import biz.korwin.web.service.home.model.PaymentVO;

@ManagedBean(name="loginBean")
@SessionScoped
@Component
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	@Autowired
	private IUserService userService;
	
	private List<PaymentVO> paymentsOfInterest;
	
	public String getUserName() {
		return userName;
	}	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public List<PaymentVO> getPaymentsOfInterest() {
		return paymentsOfInterest;
	}
	public void setPaymentsOfInterest(List<PaymentVO> paymentsOfInterest) {
		this.paymentsOfInterest = paymentsOfInterest;
	}
	public String login(){
		
		paymentsOfInterest = userService.getPaymentsByDate("20150328");
		
		return "home";
	}
	

}
