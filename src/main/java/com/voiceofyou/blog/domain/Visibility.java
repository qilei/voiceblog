package com.voiceofyou.blog.domain;

import java.util.HashMap;
import java.util.Map;

public enum Visibility {
	all("所有人可见"),owner("仅自己可见");

	private String message;
	
	Visibility(String message){
		this.message=message;
	}
	
	public static Map<Visibility, String> options() {
        Map<Visibility, String> options = new HashMap<Visibility, String>();
        for (Visibility type : values()) {
            options.put(type, type.getMessage());
        }
        return options;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
