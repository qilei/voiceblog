/**
 * 
 */
package com.voiceofyou.blog.domain;

/**
 * 博客的发布状态
 * @author Administrator
 *
 */
public enum PostStatus {
	publish("发布"), draft("草稿"), trash("回收站");
	
	private String description;
	
	PostStatus(String description){
		this.description=description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
