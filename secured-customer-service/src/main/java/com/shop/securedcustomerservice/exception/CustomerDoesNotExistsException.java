/**
 * 
 */
package com.shop.securedcustomerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Arnaud
 *
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Custome does not exist.")
public class CustomerDoesNotExistsException extends Exception {

	private static final long serialVersionUID = 487091092384105093L;
	
	public CustomerDoesNotExistsException(String message) {
		super(message);
	}
}
