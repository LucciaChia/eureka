package com.profesorp.capitalsservice;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CapitalsBean {
	private String countryShortcut;
	private String name;
	private String capital;
	private int port;	
}
