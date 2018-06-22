package com.internal.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.internal.customAnnotations.EmployeeExists;

import lombok.Data;

@Data
public class FindEmployee {

	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(1000)
	@EmployeeExists
	private long employeeId;

}
