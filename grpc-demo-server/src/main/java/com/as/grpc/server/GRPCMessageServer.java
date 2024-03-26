package com.as.grpc.server;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import com.as.grpc.message.adapters.api.MessageServiceImpl;


public class GRPCMessageServer {

	private static final Logger logger = Logger.getLogger(GRPCMessageServer.class.getName());
	private Server server;

	public void start() {
		int port = 50051;
		logger.info("Starting server...");
		try {
			server = ServerBuilder.forPort(port).addService(new MessageServiceImpl()).build().start();

			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					logger.info("Shutting down server...");
					try {
						GRPCMessageServer.this.stop();
					} catch (InterruptedException e) {
						logger.log(java.util.logging.Level.SEVERE, "Server did not shut down!", e);
					}
					logger.info("Server shut down!");
				}
			});

		} catch (IOException e) {
			logger.log(java.util.logging.Level.SEVERE, "Server did not start!", e);
		}
		logger.info("Server started!");
	}

	public void stop() throws InterruptedException {
		if (server != null) {
			server.shutdown().awaitTermination(30, java.util.concurrent.TimeUnit.SECONDS);
		}
	}

	public void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}
}
