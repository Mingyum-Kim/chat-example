package com.example.chatexample.domain;

public class ChatMessage {
	private String content;
	private String sender;
	private MessageType type;

	public enum MessageType {
		CHAT, LEAVE, JOIN
	}

	public String getContent() {
		return content;
	}

	public String getSender() {
		return sender;
	}

	public MessageType getType() {
		return type;
	}
}
