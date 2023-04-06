package it.exolab.bean.validators;

import java.util.regex.Pattern;

import javax.faces.validator.FacesValidator;

@FacesValidator("emailValidator")
public class EmailValidator extends RegexValidator {

	private static final String regex = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$";

	private static final Pattern EMAIL_PATTERN = Pattern.compile(regex);

	@Override
	protected String getValidationErrorString() {
		return "email non valida";
	}

	@Override
	protected Pattern getRegexPattern() {
		return EMAIL_PATTERN;
	}

}
