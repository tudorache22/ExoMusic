package it.exolab.bean.validators;

import java.util.regex.Pattern;

import javax.faces.validator.FacesValidator;

@FacesValidator("passwordValidator")
public class PasswordValidator extends RegexValidator {

	public static final String PASSWORD_FINAL = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
	public static final Pattern pattern = Pattern.compile(PASSWORD_FINAL);

	@Override
	protected String getValidationErrorString() {
		return "La password deve contenere: " + "\n 1.Minimo 8 caratteri(massimo 20) " + "\n 2.Una lettera maiuscola "
				+ "\n 3.Un numero " + "\n 4.Un carattere speciale";
	}

	@Override
	protected Pattern getRegexPattern() {
		return pattern;
	}

}
