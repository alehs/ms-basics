package com.as.grpc.message.ports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.grpc.message.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {


}
