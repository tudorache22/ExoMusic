package it.exolab.bean.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public abstract class RegexValidator implements Validator {

	@Override
	public void validate(FacesContext fc, UIComponent component, Object o) throws ValidatorException {
		// No value is not ok
		if (o == null || "".equals(o)) {
			FacesMessage msg = new FacesMessage(getValidatorMessage(component), null);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

		String input = (String) o;

		Matcher matcher = getRegexPattern().matcher(input);

		if (!matcher.matches()) {
			FacesMessage msg = new FacesMessage(getValidatorMessage(component), null);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

	private String getValidatorMessage(UIComponent component) {
		String validatorMessage = ((UIInput) component).getValidatorMessage();

		return validatorMessage != null ? validatorMessage : getValidationErrorString();
	}

	protected abstract String getValidationErrorString();

	protected abstract Pattern getRegexPattern();

}