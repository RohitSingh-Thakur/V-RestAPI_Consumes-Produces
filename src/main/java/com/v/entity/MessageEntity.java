package com.v.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageEntity {

	private Integer messageId;
	private String message;
	private String timeStamp;
	
	public MessageEntity() {
		// TODO Auto-generated constructor stub
	}

	public MessageEntity(Integer messageId, String message, String timeStamp) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	@XmlElement
	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@XmlElement
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@XmlElement
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "MessageEntity [messageId=" + messageId + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}
}
