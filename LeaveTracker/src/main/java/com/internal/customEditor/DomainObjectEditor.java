package com.internal.customEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.SimpleTypeConverter;

public class DomainObjectEditor extends PropertyEditorSupport {

	//private BaseDaoSupport dao;
	private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

	/*public DomainObjectEditor(BaseDaoSupport dao) {
		this.dao = dao;
	}*/

	@Override
	public String getAsText() {
		Object obj = getValue();
		if (obj == null) {
			return null;
		}

		if (obj instanceof DomainObject) {
			DomainObject domainObject = (DomainObject) obj;

			return typeConverter.convertIfNecessary(domainObject.getId(), String.class);
		}

		throw new IllegalArgumentException("Value must be a DomainObject");
	}

	@Override
	public void setAsText(String text) {
		if (text == null || 0 == text.length()) {
			setValue(null);
			return;
		}

		//setValue(dao.find(typeConverter.convertIfNecessary(text, Long.class)));
	}

}