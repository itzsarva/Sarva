package com.sarva.bind;

import java.beans.PropertyEditorSupport;

public class AgeBinder extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.err.println("it is coming inside this okay??----->"+text);
		try {
			if ((Number) Integer.parseInt(text) instanceof Number && Integer.parseInt(text) < 100) {
				setValue(text);
			} else {
				throw new Exception("age is too high man");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Could not parse your AGE, Fng you cant be older " + "that 100 B!", e);
		}

	}

}
