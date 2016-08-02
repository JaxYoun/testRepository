package com.common.vo;

import java.io.Serializable;

public class ComboVo implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = 4450921468993479329L;

	private String value;
	
	private String displayValue;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
}
