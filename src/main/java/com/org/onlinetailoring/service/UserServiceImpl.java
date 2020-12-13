package com.org.onlinetailoring.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.org.onlinetailoring.entity.Login;
import com.org.onlinetailoring.entity.UserDetails;
import com.org.onlinetailoring.repository.LoginRepository;
import com.org.onlinetailoring.repository.UserDetailsRepository;
import com.org.onlinetailoring.exception.XasterException;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {

	/** The Constant logger. */
	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/** The user details repository. */
	@Autowired
	UserDetailsRepository userDetailsRepository;

	/** The login repository. */
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	private JavaMailSender sender;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.onlinetailoring.service.UserService#getUserDetails(java.lang.String)
	 */
	public UserDetails getUserDetails(String username) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.onlinetailoring.service.UserService#registerUser(com.org.
	 * onlinetailoring.entity.Login)
	 */
	public UserDetails registerUser(Login login) throws Exception {
		userDetailsRepository.save(login.getUserDetails());
		Login savedLoginDetails = loginRepository.save(login);

		return savedLoginDetails.getUserDetails();
	}

	// private void sendEmail(String email) throws Exception{
	// try {
	// MimeMessage message = sender.createMimeMessage();
	// MimeMessageHelper helper = new MimeMessageHelper(message);
	//
	// helper.setTo(email);
	// helper.setText("<html><head><b>Xaster Verification</b></head>"
	// + "<body><div>Please click the below link to set username and password</div>"
	// + "<div><a href=\"http://localhost:8080/xaster/setlogindetails\">add login
	// details</a></div></body></html>");
	// helper.setSubject("verification mail");
	//
	// sender.send(message);
	// } catch (Exception e) {
	// logger.error("Error occured while sending email : {0}", e.getMessage());
	// }
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.onlinetailoring.service.UserService#getUserDetails(com.org.
	 * onlinetailoring.entity.Login)
	 */
	@Override
	public Login getUserDetails(Login login) {
		Login loginUser = loginRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
		// if(null != loginUser ) {
		// userDetails = loginUser.getUserDetails();
		// }
		return loginUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.onlinetailoring.service.UserService#getAllUsers()
	 */
	@Override
	public List<UserDetails> getAllUsers() {

		List<Login> loginList = loginRepository.findByRole("User");
		List<UserDetails> userDetails = loginList.stream().map(i -> i.getUserDetails()).collect(Collectors.toList());
		return userDetails;
	}

	@Override
	public String sendOTP(String username) throws XasterException {
		String randomNumber = "";
		Login loginUser = loginRepository.findByUsername(username);
		if (loginUser == null) {
			throw new XasterException("invalid username");
		} else {
			String email = loginUser.getUserDetails().getEmail();
			randomNumber = getRandomNumberString();
			try {
				MimeMessage message = sender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message);

				helper.setTo(email);
				helper.setText("OTP for xaster password reset is " + randomNumber);
				helper.setSubject("verification mail");

				sender.send(message);

			} catch (Exception e) {
				logger.error("Error occured while sending email : {0}", e.getMessage());
			}
		}
		return randomNumber;
	}

	public String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return String.format("%06d", number);
	}

	@Override
	public void updatePassword(Login login) throws XasterException {
		// TODO Auto-generated method stub
		Login loginUser = loginRepository.findByUsername(login.getUsername());
		if (loginUser == null) {
			throw new XasterException("invalid username");
		} else {
			loginUser.setPassword(login.getPassword());
			loginRepository.save(loginUser);
		}
	}
}
