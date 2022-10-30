package httpServer;

import java.io.IOException;

class Server {

	/**
	 * Creates a SocketServer object and starts the server.
	 */
	
	public static void main(String[] args) throws InterruptedException {
		//int portNumber = Integer.parseInt(args[0]);

		int portNumber = 80;
		try {
			// initializing the Socket Server
			MultiThreadedServer socketServer = new MultiThreadedServer(portNumber);
			socketServer.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
