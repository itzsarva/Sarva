package com.sarva.annotation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Payload;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sarva.annotation.Severity.BigError;

@RestController
public class NameTest {

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@RequestMapping(value = "/getNameDTO", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON)
	public NameDTO getDTO() {
		return new NameDTO("Sarva", "25", "mm", "641021");
	}

	@RequestMapping(value = "/firstOne", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON)
	public Response validateOne(@Validated(NameDTO.Forfew.class) @RequestBody NameDTO dto) {
		Set<ConstraintViolation<NameDTO>> constraints = validator.validate(dto, NameDTO.ForOtherFew.class);
		int size = constraints.size();
		if (size == 0) {
			return Response.status(Status.ACCEPTED).entity(dto).build();
		} else {
			for (ConstraintViolation<NameDTO> violation : constraints) {
				Set<Class<? extends Payload>> payloads = violation.getConstraintDescriptor().getPayload();
				for (Class<? extends Payload> payload : payloads) {
					if (payload == BigError.class) {
						System.out.println("Error: " + violation.getPropertyPath() + " " + violation.getMessage());
					}
				}
			}
			return Response.status(Status.BAD_REQUEST).entity(dto).build();
		}
	}

	@RequestMapping(value = "/second", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON)
	public Response validateTwo(@Validated(NameDTO.ForOtherFew.class) NameDTO dto) {
		return Response.status(Status.ACCEPTED).entity(dto).build();
	}

}
