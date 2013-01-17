package com.voiceofyou.blog.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="entry")
public class Entry implements Serializable {
	private int id;
	private String subject;
	private String body;
	private DateTime postDate;
	private Visibility visibility;
	private PostStatus postStatus;
	private int commentCount;
	private int viewCount;
	
	private Category category;
	private Set<Comment> comments;
	private Set<EntryAttachment> attachments;
	

	public Entry() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Column(name="POST_DATE")
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(iso=ISO.DATE)
//	@Temporal(value=TemporalType.DATE)
	public DateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(DateTime postDate) {
		this.postDate = postDate;
	}
	
	@Transient
	public String getPostDateString() {
		return org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd").print(postDate);
	}

	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@OneToMany(mappedBy="entry",fetch=FetchType.EAGER)
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(mappedBy="entry",fetch=FetchType.LAZY)
	public Set<EntryAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<EntryAttachment> attachments) {
		this.attachments = attachments;
	}

	@Enumerated(EnumType.STRING)
	public Visibility getVisibility() {
		return this.visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="post_status")
	public PostStatus getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(PostStatus postStatus) {
		this.postStatus = postStatus;
	}
	
	@Column(name="comment_count")
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Column(name="view_count")
	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	
}
