package httpClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainClient {

	public static void main(String[] args) throws IOException {
//		String host = args[0];
//		int port = Integer.parseInt(args[1]);
//		String command = args[2];
//		String path = args[3];

		String host = "localhost";
		int port = 80;
		String command = "PUT";
		String path = "C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\HTML\\index.html";
		
		// Method Check GET or PUT
		if ("GET".equals(command)) {
			String fileName = "index.html";
			Client.getMethod(host, port, fileName);
		} 
		else if("HEAD".equals(command)) {
			String fileName = "index.html";
			Client.headMethod(host, port, fileName);
		}
		else if("DELETE".equals(command)) {
			String fileName = "deleteTest.html";
			Client.deleteMethod(host, port, fileName);
		}
		else if ("POST".equals(command)) {
			String folderName = "JSON";
			String content = "{"
					+ "\r\n"
					+ "  \"Id\": 1,\r\n"
					+ "  \"Customer\": \"Cong Dung\"\r\n"
					+ "}";
			Client.postMethod(host, port, folderName, content);
		}
		
		else if ("PUT".equals(command)) {
			String fileNamePut = "JSON\\testPost.txt";
			String content = "{"
					+ "\r\n"
					+ "  \"Id\": 1,\r\n"
					+ "  \"Customer\": \"Cong Dung Update\"\r\n"
					+ "}";
			Client.putMethod(host, port, fileNamePut, content);
		}
		else{
			//System.out.println("Check the HTTP command! It should be either GET or PUT");
			System.out.println("Method Not Support");
			return;
		}
		
	}

}
