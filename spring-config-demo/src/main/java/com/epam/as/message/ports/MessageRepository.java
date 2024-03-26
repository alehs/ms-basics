package com.epam.as.message.ports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.as.message.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {


}
