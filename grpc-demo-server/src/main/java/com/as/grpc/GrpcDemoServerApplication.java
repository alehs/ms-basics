package com.as.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.as.grpc.server.GRPCMessageServer;

@SpringBootApplication
public class GrpcDemoServerApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(GrpcDemoServerApplication.class, args);
		GRPCMessageServer server = new GRPCMessageServer();
		server.start();
		server.blockUntilShutdown();
	}

}
