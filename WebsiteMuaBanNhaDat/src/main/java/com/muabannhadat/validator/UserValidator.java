package com.muabannhadat.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.muabannhadat.model.UserModel;
import com.muabannhadat.service.UserService;

@Component
public class UserValidator implements Validator {
	private EmailValidator emailValidator = EmailValidator.getInstance();
	@Autowired
	UserService userService;
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == UserModel.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserModel user = (UserModel) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname", "NotEmpty.registerForm.fullname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.registerForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.registerForm.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "NotEmpty.registerForm.pass");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "re_pass", "NotEmpty.registerForm.re_pass");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.registerForm.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "NotEmpty.registerForm.birthday");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.registerForm.phone");
		System.out.println( "NotEmpty.registerForm.re_pass");
		if (!emailValidator.isValid(user.getEmail())) {
			// Lỗi trường email.
			errors.rejectValue("email", "Pattern.registerForm.email");
		}
		// Lỗi mật khẩu nhập lại không khớp với mật khẩu
		if (!user.getPass().equals(user.getRe_pass())) {
			errors.rejectValue("re_pass", "Pattern.registerForm.re_pass");
		}
		if (!userService.checkUser(user.getUsername()) && !user.getUsername().equals("")) {
			errors.rejectValue("username", "Pattern.registerForm.username");
		}
//		//Lỗi mật khẩu phải có ít nhất 1 số, 1 chữ thường , 1 chữ hoa
//		if (!user.getPass().matches("((?=.*d)(?=.*[a-z])(?=.*[A-Z]))")) {
//			errors.rejectValue("pass", "Pattern.registerForm.pass");
//		}
	}

}
