package httpClient;

import java.io.IOException;


public class MainClient {

	public static void main(String[] args) throws IOException {

//		String host = args[0];
//		int port = Integer.parseInt(args[1]);
//		String command = args[2];
//		String path = args[3];

		String host = "localhost";
		int port = 80;
		String command = "GET";
		String path = "C:\\Users\\admind\\eclipse-workspace\\HTTPProtocol\\src\\index.html";
		
		// Method Check GET or PUT
		if ("GET".equals(command)) {
			Client.getMethod(host, port, path);
		} else if ("PUT".equals(command)) {
			Client.putMethod(host, port, path);
		}else if ("POST".equals(command)) {
			Client.postMethod(host, port, path);
		}
		else{
			//System.out.println("Check the HTTP command! It should be either GET or PUT");
			System.out.println("Method Not Support");
			return;
		}
		
	}

}
