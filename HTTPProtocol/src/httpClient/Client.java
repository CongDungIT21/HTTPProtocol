package httpClient;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Client {
	private static final String CRLF = "\r\n";
	
	public static void getMethod(String host, int port, String fileName)
			throws IOException {
		// Opening Connection based on the port number 80(HTTP) and 443(HTTPS)
		Socket clientSocket = null;
		clientSocket = new Socket(host, port);
		System.out.println("======================================");
		System.out.println("Connected");
		System.out.println("======================================");

		// Declare a writer to this url
		PrintWriter request = new PrintWriter(clientSocket.getOutputStream(), true);

		// Declare a listener to this url
		BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		// Sending request to the server
		// Building HTTP request header
		//request.print("" + CRLF);
		request.print("GET /" + fileName + " HTTP/1.1" + CRLF); //GET /home.html HTTP/1.1
		request.print("Host: " + host + CRLF);//		Host: developer.mozilla.org
		request.print("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0" + CRLF);//		User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0
		request.print("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" + CRLF);//		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
		request.print("Accept-Language: en-US,en;q=0.5" + CRLF);//		Accept-Language: en-US,en;q=0.5
		request.print("Accept-Encoding: gzip, deflate, br" + CRLF);//		Accept-Encoding: gzip, deflate, br
		request.print("Referer: https://developer.mozilla.org/testpage.html" + CRLF);//		Referer: https://developer.mozilla.org/testpage.html
		request.print("Connection: keep-alive" + CRLF);//		Connection: keep-alive
		request.print("Upgrade-Insecure-Requests: 1" + CRLF);//		Upgrade-Insecure-Requests: 1
//		If-Modified-Since: Mon, 18 Jul 2016 02:36:04 GMT
//		If-None-Match: "c561c68d0ba92bbeb8b0fff2a9199f722e3a621a"
//		Cache-Control: max-age=0
		request.print(CRLF);
		request.flush();
		
		System.out.println("Request Sent!");
		System.out.println("======================================");

		// Receiving response from server
		String responseLine;
		while ((responseLine = response.readLine()) != null) {
			System.out.println(responseLine);
		}
		System.out.println("======================================");
		System.out.println("Response Recieved!!");
		System.out.println("======================================");

		response.close();
		request.close();
		
		clientSocket.close();
	}
	
	
	public static void headMethod(String host, int port, String fileName)
			throws IOException {
		// Opening Connection based on the port number 80(HTTP) and 443(HTTPS)
		Socket clientSocket = null;
		clientSocket = new Socket(host, port);
		System.out.println("======================================");
		System.out.println("Connected");
		System.out.println("======================================");

		// Declare a writer to this url
		PrintWriter request = new PrintWriter(clientSocket.getOutputStream(), true);

		// Declare a listener to this url
		BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		// Sending request to the server
		// Building HTTP request header
		//request.print("" + CRLF);
		request.print("HEAD /" + fileName + " HTTP/1.1" + CRLF); //GET /home.html HTTP/1.1
		request.print("Host: " + host + CRLF);//		Host: developer.mozilla.org
		request.print("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0" + CRLF);//		User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0
		request.print("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" + CRLF);//		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
		request.print("Accept-Language: en-US,en;q=0.5" + CRLF);//		Accept-Language: en-US,en;q=0.5
		request.print("Accept-Encoding: gzip, deflate, br" + CRLF);//		Accept-Encoding: gzip, deflate, br
		request.print("Referer: https://developer.mozilla.org/testpage.html" + CRLF);//		Referer: https://developer.mozilla.org/testpage.html
		request.print("Connection: keep-alive" + CRLF);//		Connection: keep-alive
		request.print("Upgrade-Insecure-Requests: 1" + CRLF);//		Upgrade-Insecure-Requests: 1
//		If-Modified-Since: Mon, 18 Jul 2016 02:36:04 GMT
//		If-None-Match: "c561c68d0ba92bbeb8b0fff2a9199f722e3a621a"
//		Cache-Control: max-age=0
		request.print(CRLF);
		request.flush();
		
		System.out.println("Request Sent!");
		System.out.println("======================================");

		// Receiving response from server
		String responseLine;
		while ((responseLine = response.readLine()) != null) {
			System.out.println(responseLine);
		}
		System.out.println("======================================");
		System.out.println("Response Recieved!!");
		System.out.println("======================================");

		response.close();
		request.close();
		
		clientSocket.close();
	}	
	
	
	public static void deleteMethod(String host, int port, String fileName)
			throws IOException {
		// Opening Connection based on the port number 80(HTTP) and 443(HTTPS)
		Socket clientSocket = null;
		clientSocket = new Socket(host, port);
		System.out.println("======================================");
		System.out.println("Connected");
		System.out.println("======================================");

		// Declare a writer to this url
		PrintWriter request = new PrintWriter(clientSocket.getOutputStream(), true);

		// Declare a listener to this url
		BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		// Sending request to the server
		// Building HTTP request header
		//request.print("" + CRLF);
		request.print("DELETE /" + fileName + " HTTP/1.1" + CRLF); //GET /home.html HTTP/1.1
		request.print("Host: " + host + CRLF);//		Host: developer.mozilla.org
		request.print("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0" + CRLF);//		User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0
		request.print("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" + CRLF);//		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
		request.print("Accept-Language: en-US,en;q=0.5" + CRLF);//		Accept-Language: en-US,en;q=0.5
		request.print("Accept-Encoding: gzip, deflate, br" + CRLF);//		Accept-Encoding: gzip, deflate, br
		request.print("Referer: https://developer.mozilla.org/testpage.html" + CRLF);//		Referer: https://developer.mozilla.org/testpage.html
		request.print("Connection: keep-alive" + CRLF);//		Connection: keep-alive
		request.print("Upgrade-Insecure-Requests: 1" + CRLF);//		Upgrade-Insecure-Requests: 1
//		If-Modified-Since: Mon, 18 Jul 2016 02:36:04 GMT
//		If-None-Match: "c561c68d0ba92bbeb8b0fff2a9199f722e3a621a"
//		Cache-Control: max-age=0
		request.print(CRLF);
		request.flush();
		
		System.out.println("Request Sent!");
		System.out.println("======================================");

		// Receiving response from server
		String responseLine;
		while ((responseLine = response.readLine()) != null) {
			System.out.println(responseLine);
		}
		System.out.println("======================================");
		System.out.println("Response Recieved!!");
		System.out.println("======================================");

		response.close();
		request.close();
		
		clientSocket.close();
	}	
	
	public static void connectMethod(String host, int port)
			throws IOException {
		// Opening Connection based on the port number 80(HTTP) and 443(HTTPS)
		Socket clientSocket = null;
		clientSocket = new Socket(host, port);
		System.out.println("======================================");
		System.out.println("Connected");
		System.out.println("======================================");

		// Declare a writer to this url
		PrintWriter request = new PrintWriter(clientSocket.getOutputStream(), true);

		// Declare a listener to this url
		BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		// Sending request to the server
		// Building HTTP request header
		//request.print("" + CRLF);
		request.print("CONNECT " + host + ":" + port + " HTTP/1.1" + CRLF); //GET /home.html HTTP/1.1
		request.print("Host: " + host + CRLF);//		Host: developer.mozilla.org
		request.print("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0" + CRLF);//		User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0
		request.print("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" + CRLF);//		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
		request.print("Accept-Language: en-US,en;q=0.5" + CRLF);//		Accept-Language: en-US,en;q=0.5
		request.print("Accept-Encoding: gzip, deflate, br" + CRLF);//		Accept-Encoding: gzip, deflate, br
		request.print("Referer: https://developer.mozilla.org/testpage.html" + CRLF);//		Referer: https://developer.mozilla.org/testpage.html
		request.print("Connection: keep-alive" + CRLF);//		Connection: keep-alive
		request.print("Upgrade-Insecure-Requests: 1" + CRLF);//		Upgrade-Insecure-Requests: 1
//		If-Modified-Since: Mon, 18 Jul 2016 02:36:04 GMT
//		If-None-Match: "c561c68d0ba92bbeb8b0fff2a9199f722e3a621a"
//		Cache-Control: max-age=0
		request.print(CRLF);
		request.flush();
		
		System.out.println("Request Sent!");
		System.out.println("======================================");

		// Receiving response from server
		String responseLine;
		while ((responseLine = response.readLine()) != null) {
			System.out.println(responseLine);
		}
		System.out.println("======================================");
		System.out.println("Response Recieved!!");
		System.out.println("======================================");

		response.close();
		request.close();
		
		clientSocket.close();
	}	

	public static void putMethod(String host, int port, String file)
			throws UnknownHostException, IOException {

		// Opening Connection based on the port number 80(HTTP) and 443(HTTPS)
		Socket clientSocket = null;
		clientSocket = new Socket(host, port);

		System.out.println("======================================");
		System.out.println("Connected");
		System.out.println("======================================");

		PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),
				true);
		BufferedReader response = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		// Sending request to the server
		// Building HTTP request header
		Path path = Paths.get(file);
		Long length = Files.size(path);
		request.print("PUT /" + file + "/ HTTP/1.1\r\n"); // "+path+"
		request.print("Host: " + host+"\r\n");
		request.print("Accept-Language: en-us\r\n");
		request.print("Connection: Keep-Alive\r\n");
		request.print("User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\r\n");
		request.print("Content-type: "+	Files.probeContentType(path)+"\r\n");
		request.print("Content-Length: "+length+"\r\n");
		request.print("\r\n");

		System.out.println("PUT Request Header Sent!");
		System.out.println("======================================");

		// Send the Data to be PUT
		String htmlContent = readHtmlFile(file);
		request.println(htmlContent);
		request.flush();

		System.out.println("PUT Data Sent!");
		System.out.println("======================================");

		// Receiving response from server
		String responseLine;
		while ((responseLine = response.readLine()) != null) {
			System.out.println(responseLine);
		}
		System.out.println("======================================");
		System.out.println("Response Recieved!!");
		System.out.println("======================================");
		request.close();
		response.close();
		clientSocket.close();
	}
	
	public static void postMethod(String host, int port, String folderName, String content)
			throws IOException {

		// Opening Connection based on the port number 80(HTTP) and 443(HTTPS)
		Socket clientSocket = null;
		clientSocket = new Socket(host, port);

		System.out.println("======================================");
		System.out.println("Connected");
		System.out.println("======================================");

		// Declare a writer to this url
		PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),
				true);

		// Declare a listener to this url
		BufferedReader response = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		// Sending request to the server
		// Building HTTP request header
		System.out.println(content);
		request.print("POST /" + folderName + "/ HTTP/1.1" + CRLF); // "+path+"
		request.print("Host: " + host + CRLF);
		request.print("Content-Type: application/json" + CRLF);
		request.print("Content-Length: " + content.length() + CRLF);
		request.print("Body: " + CRLF);
		request.print(content + CRLF);
		request.print(CRLF);
		request.flush();
		
		System.out.println("Request Sent!");
		System.out.println("======================================");

		// Receiving response from server
		String responseLine;
		while ((responseLine = response.readLine()) != null) {
			System.out.println(responseLine);
		}
		System.out.println("======================================");
		System.out.println("Response Recieved!!");
		System.out.println("======================================");

		response.close();
		request.close();
		clientSocket.close();
	}
	
	public static void putMethod(String host, int port, String fileName, String content)
			throws IOException {

		// Opening Connection based on the port number 80(HTTP) and 443(HTTPS)
		Socket clientSocket = null;
		clientSocket = new Socket(host, port);

		System.out.println("======================================");
		System.out.println("Connected");
		System.out.println("======================================");

		// Declare a writer to this url
		PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),
				true);

		// Declare a listener to this url
		BufferedReader response = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		// Sending request to the server
		// Building HTTP request header
		request.print("PUT /" + fileName + "/ HTTP/1.1" + CRLF); // "+path+"
		request.print("Host: " + host + CRLF);
		request.print("Content-Type: application/json" + CRLF);
		request.print("Content-Length: " + content.length() + CRLF);
		request.print("Body: " + CRLF);
		request.print(content + CRLF);
		request.print(CRLF);
		request.flush();
		
		System.out.println("Request Sent!");
		System.out.println("======================================");

		// Receiving response from server
		String responseLine;
		while ((responseLine = response.readLine()) != null) {
			System.out.println(responseLine);
		}
		System.out.println("======================================");
		System.out.println("Response Recieved!!");
		System.out.println("======================================");

		response.close();
		request.close();
		clientSocket.close();
	}	

	private static String readHtmlFile(String file) {
		
		BufferedReader reader;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			String ls = System.getProperty("line.separator");

			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			reader.close();
			
			
		} catch (FileNotFoundException e) {
			
			System.err.println(e.getMessage());
			System.out.println("Client side issue with file name");
			System.exit(1);
//			stringBuilder.setLength(0);
//			stringBuilder.append("Check the file name!");
//			return stringBuilder.toString();
			
		} catch (IOException e) {
			
			System.err.println(e.getMessage());
			System.exit(1);
//			stringBuilder.setLength(0);
//			stringBuilder.append("File has no text!");
//			return stringBuilder.toString();
		}
		return stringBuilder.toString();
	}
}
