
package com.wallfacers.data.platform.executor;

import com.wallfacers.data.platform.executor.service.DataxServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class DataTransformExecutorApplication {

	private static final Logger LOGGER = Logger.getLogger(DataTransformExecutorApplication.class.getName());

	private Server server;

	private void start() throws IOException {
		int port = 50051;
		server = ServerBuilder.forPort(port)
				.addService(new DataxServiceImpl())
				.build()
				.start();
		LOGGER.info("Server started, listening on " + port);
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.err.println("*** shutting down gRPC server since JVM is shutting down");
			try {
				DataTransformExecutorApplication.this.stop();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LOGGER.info("*** server shut down");
		}));
	}

	private void stop() throws InterruptedException {
		if (server != null) {
			server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
		}
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	/**
	 * Main launches the server from the command line.
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		final DataTransformExecutorApplication server = new DataTransformExecutorApplication();
		server.start();
		server.blockUntilShutdown();
	}
}