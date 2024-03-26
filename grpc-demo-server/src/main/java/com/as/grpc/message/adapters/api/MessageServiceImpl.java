package com.as.grpc.message.adapters.api;

import io.grpc.stub.StreamObserver;

public class MessageServiceImpl extends MessageServiceGrpc.MessageServiceImplBase {

	@Override
	public void echoMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
		MessageResponse response = MessageResponse.newBuilder()
			.setText("Echo from server: " + request.getText())
			.setId(1)
			.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
