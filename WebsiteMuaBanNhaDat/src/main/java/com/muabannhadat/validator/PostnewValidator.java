package com.muabannhadat.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.muabannhadat.model.UserModel;
//TODO
@Component
public class PostnewValidator implements Validator {
	private EmailValidator emailValidator = EmailValidator.getInstance();
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == UserModel.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserModel user = (UserModel) target;
		ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.registerForm.name");
		ValidationUtils.rejectIfEmpty(errors, "email", "NotEmpty.registerForm.email");
		ValidationUtils.rejectIfEmpty(errors, "pass", "NotEmpty.registerForm.pass");
		ValidationUtils.rejectIfEmpty(errors, "re_pass", "NotEmpty.registerForm.re_pass");
		ValidationUtils.rejectIfEmpty(errors, "address", "NotEmpty.registerForm.address");
		ValidationUtils.rejectIfEmpty(errors, "birthday", "NotEmpty.registerForm.birthday");
		ValidationUtils.rejectIfEmpty(errors, "phone", "NotEmpty.registerForm.phone");

		if (!emailValidator.isValid(user.getEmail())) {
			// Lỗi trường email.
			errors.rejectValue("email", "Pattern.registerForm.email");
		}
		// Lỗi mật khẩu nhập lại không khớp với mật khẩu
		if (!user.getPass().equals(user.getRe_pass())) {
			errors.rejectValue("re_pass", "Pattern.registerForm.re_pass");
		}
//		//Lỗi mật khẩu phải có ít nhất 1 số, 1 chữ thường , 1 chữ hoa
//		if (!user.getPass().matches("((?=.*d)(?=.*[a-z])(?=.*[A-Z]))")) {
//			errors.rejectValue("pass", "Pattern.registerForm.pass");
//		}
	}

}
