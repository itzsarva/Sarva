package com.internal.customEditor;

import java.io.Serializable;

public class DomainObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected long id;

	public boolean isTransient() {
		return getId() == 0;
	}

	public boolean isPersistent() {
		return !isTransient();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof DomainObject))
			return false;

		DomainObject that = (DomainObject) o;

		if (id != that.id)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}

	@Override
	public String toString() {
		return "DomainObject{" + "id=" + id + '}';
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}