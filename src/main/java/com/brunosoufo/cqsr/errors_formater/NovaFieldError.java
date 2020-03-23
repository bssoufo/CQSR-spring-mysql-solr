package com.brunosoufo.cqsr.errors_formater;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.support.WebExchangeBindException;

import lombok.Data;

/**
 * FieldError
 */
@Data
public class NovaFieldError {

    private String field;
    private String code;
    private String message;

    public NovaFieldError(String field, String code, String message) {
		this.field = field;
		this.code = code;
		this.message = message;
	}

    @Override
	public String toString() {
		return "FieldError {field=" + field + ", code=" + code + ", message=" + message + "}";
	}


	/**
	 * Converts a set of ConstraintViolations
	 * to a list of FieldErrors
	 * 
	 * @param constraintViolations
	 */
	public static List<NovaFieldError> getErrors(
			Set<ConstraintViolation<?>> constraintViolations) {
		
		return constraintViolations.stream()
				.map(NovaFieldError::of).collect(Collectors.toList());	
	}
	

	public static Collection<NovaFieldError> getErrors(ExplicitConstraintViolationException ex) {
		
		return ex.getConstraintViolations().stream()
			.map(constraintViolation ->
				new NovaFieldError(
						constraintViolation.getPropertyPath().toString(),
						constraintViolation.getMessageTemplate(),
						constraintViolation.getMessage()))
		    .collect(Collectors.toList());	
	}

	/**
	 * Converts a ConstraintViolation
	 * to a FieldError
	 */
	private static NovaFieldError of(ConstraintViolation<?> constraintViolation) {
		
		// Get the field name by removing the first part of the propertyPath.
		// (The first part would be the service method name)
		String field = StringUtils.substringAfter(
				constraintViolation.getPropertyPath().toString(), ".");
		
		return new NovaFieldError(field,
				constraintViolation.getMessageTemplate(),
				constraintViolation.getMessage());		
	}

	public static List<NovaFieldError> getErrors(WebExchangeBindException ex) {
		
		List<NovaFieldError> errors = ex.getFieldErrors().stream()
			.map(NovaFieldError::of).collect(Collectors.toList());
		
		errors.addAll(ex.getGlobalErrors().stream()
			.map(NovaFieldError::of).collect(Collectors.toSet()));
		
		return errors;
	}

	private static NovaFieldError of(FieldError fieldError) {
		
		return new NovaFieldError(fieldError.getObjectName() + "." + fieldError.getField(),
				fieldError.getCode(), fieldError.getDefaultMessage());
	}

	public static NovaFieldError of(ObjectError error) {
		
		return new NovaFieldError(error.getObjectName(),
				error.getCode(), error.getDefaultMessage());
	}

    
    
}