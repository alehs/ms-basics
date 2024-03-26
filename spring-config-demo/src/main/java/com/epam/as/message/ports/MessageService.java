package com.epam.as.message.ports;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.as.message.domain.Message;

@Component
public class MessageService {

	private final MessageRepository messageRepository;

	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public Message echoMessage(Message message) {
		addMessage(message);
		return new Message("Echo: " + message.getText());
	}

	public Message addMessage(Message message) {
		return messageRepository.save(message);
	}

	public List<Message> listMessages() {
		return messageRepository.findAll();
	}
}
