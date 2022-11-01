package httpServer;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHandler implements Runnable {

	private Socket client;

	public ClientHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread started with name:" + Thread.currentThread().getName());
			readResponse();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void readResponse() throws IOException, InterruptedException {
		System.out.println("a: ReadReponse() Run");
		try {
			BufferedReader request = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			BufferedWriter response = new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream()));
			
			
	            
			String putDataFromClient = "";
			String requestHeader = "";
			String requestBody = "";
			String temp = ".";
			while (!temp.equals("")) {
				temp = request.readLine();
				if(temp.contains("Body:")) {
					while (!temp.equals("")) {
						temp = request.readLine();
						requestBody += temp + "\n";
					}
					break;
				}
				requestHeader += temp + "\n";
			}
//			System.out.println("requestHeader: " + requestHeader);
//			System.out.println("requestBody: " + requestBody);
			
			// Get the method from HTTP header
			StringBuilder sb = new StringBuilder();
			String fileName = requestHeader.split("\n")[0].split(" ")[1].split("/")[1];
			String method = requestHeader.split("\n")[0];
			String pathLocationInServerSaveData = "C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\HTML\\";
			
			System.out.println("file 01: " + fileName);
			if (method.contains("GET")) {
				System.out.println("method.contains(\"GET\")");
				System.out.println("checkURL()" + pathLocationInServerSaveData + fileName);
				if((new File(pathLocationInServerSaveData + fileName)).exists()) {
				// Get the correct page
				constructResponseHeader(200, sb);
				System.out.println("sb.toString() " + sb.toString());
				response.write(sb.toString());
				response.write(getData(pathLocationInServerSaveData + fileName));
				sb.setLength(0);
				response.flush();
				System.out.println("======================================");
				}
				else {
					System.out.println("Note Found");
					constructResponseHeader(404, sb);
					response.write(sb.toString());
					sb.setLength(0);
					response.flush();
				}
			} 
			else if (method.contains("HEAD")) {
				System.out.println("method.contains(\"HEAD\")");
				System.out.println("checkURL()" + pathLocationInServerSaveData + fileName);
				if((new File(pathLocationInServerSaveData + fileName)).exists()) {
					// Get the correct page
					constructResponseHeader(200, sb);
					
					System.out.println("sb.toString() " + sb.toString());
				}
				else {
					System.out.println("Note Found");
					constructResponseHeader(404, sb);
				}	
				response.write(sb.toString());
				sb.setLength(0);
				response.flush();
				System.out.println("======================================");
			}
			else if (method.contains("DELETE")) {
				System.out.println("method.contains(\"DELETE\")");
				System.out.println("checkURL()" + pathLocationInServerSaveData + fileName);
				if((new File(pathLocationInServerSaveData + fileName)).exists()) {
				// Get the correct page
					constructResponseHeader(200, sb);
					System.out.println("sb.toString() " + sb.toString());
					System.out.println(deleteFile(pathLocationInServerSaveData + fileName));
					deleteFile(pathLocationInServerSaveData + fileName);		
				}
				else {
					System.out.println("Note Found");
					constructResponseHeader(404, sb);
				}	
				response.write(sb.toString());
				sb.setLength(0);
				response.flush();
				System.out.println("======================================");
			}
			else if (method.contains("POST")) {
				System.out.println("method.contains(\"POST\")");
				String folderName = requestHeader.split("\n")[0].split(" ")[1];
				if((new File("C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\" + folderName)).exists()) {
				// Get the correct page
					constructResponseHeader(200, sb);
					System.out.println("sb.toString() " + sb.toString());
//					System.out.println("Content \n" + requestBody);
					String pathFileSave = "C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\" + folderName + "\\testPost.txt";
					try {
					    BufferedWriter writerData = new BufferedWriter(new FileWriter(pathFileSave));
					    writerData.write(requestBody);
					    writerData.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Note Found");
					constructResponseHeader(404, sb);
				}	
				response.write(sb.toString());
				sb.setLength(0);
				response.flush();
				System.out.println("======================================");
			}
			else if (method.contains("PUT")) {
				System.out.println("method.contains(\"PUT\")");
				String fileNamePut = requestHeader.split("\n")[0].split(" ")[1];
				System.out.println("fileNamePut: " + fileNamePut);
				if((new File("C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\" + fileNamePut)).exists()) {
				// Get the correct page
					constructResponseHeader(200, sb);
					System.out.println("sb.toString() " + sb.toString());
//					System.out.println("Content \n" + requestBody);
					String pathFileSave = "C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\" + fileNamePut;
					try {
					    BufferedWriter writerData = new BufferedWriter(new FileWriter(pathFileSave));
					    writerData.write(requestBody);
					    writerData.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Note Found");
					constructResponseHeader(404, sb);
				}	
				response.write(sb.toString());
				sb.setLength(0);
				response.flush();
				System.out.println("======================================");
			}		
			else {
				constructResponseHeader(404, sb);
				response.write(sb.toString());
				sb.setLength(0);
				response.flush();
			}

			request.close();
			response.close();

			client.close();
			return;
		} catch (Exception e) {
		}

	}

	// Check the URL from the Request header to the server's database
	private static boolean checkURL(String file) {

		File myFile = new File(file);
		return myFile.exists() && !myFile.isDirectory();

	}

	// Construct Response Header
	private static void constructResponseHeader(int responseCode,
			StringBuilder sb) {

		String CRLF = "\r\n";
		if (responseCode == 200) {	
			sb.append("200 OK" + CRLF);
			sb.append("Access-Control-Allow-Origin: *" + CRLF);
			sb.append("Connection: Keep-Alive" + CRLF);
			sb.append("Content-Encoding: gzip" + CRLF);
			sb.append("Content-Type: text/html; charset=utf-8" + CRLF);
			sb.append("Date:" + getTimeStamp() + CRLF);
			sb.append("Etag: \"c561c68d0ba92bbeb8b0f612a9199f722e3a621a\"" + CRLF);
			sb.append("Keep-Alive: timeout=5, max=997" + CRLF);
			sb.append("Last-Modified: Mon, 18 Jul 2016 02:36:04 GMT" + CRLF);
			sb.append("Server: localhost" + CRLF);
			sb.append("Set-Cookie: mykey=myvalue; expires=Mon, 17-Jul-2017 16:06:00 GMT; Max-Age=31449600; Path=/; secure" + CRLF);
			sb.append(CRLF);
		} else if (responseCode == 404) {
			System.out.println("responseCode == 404");
			sb.append("HTTP/1.1 404 Not Found" + CRLF);
			sb.append("Date:" + getTimeStamp() + CRLF);
			sb.append("Server:localhost" + CRLF);
			sb.append("\r\n");
		} else if (responseCode == 304) {
			sb.append("HTTP/1.1 304 Not Modified\r\n");
			sb.append("Date:" + getTimeStamp() + "\r\n");
			sb.append("Server:localhost\r\n");
			sb.append("\r\n");
		}
	}

	// PUT data to file ServerIndex.htm
	private static int putData(String putDataFromClient, String file)
			throws IOException {

		return writeHtmlFile(putDataFromClient, file);
	}

	private static String getData(String file) {

		File myFile = new File(file);
		String responseToClient = "";
		BufferedReader reader;

		// System.out.println(myFile.getAbsolutePath());

		try {
			reader = new BufferedReader(new FileReader(myFile));
			String line = null;
			while (!(line = reader.readLine()).contains("</html>")) {
				responseToClient += line + "\n";
			}
			responseToClient += line;
			// System.out.println(responseToClient);
			reader.close();

		} catch (Exception e) {

		}
		return responseToClient;
	}

	// Write the data to server - Helper method for putData method
	private static int writeHtmlFile(String putDataFromClient, String file) {

		File myFile = new File(file);
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(myFile));
			writer.write(putDataFromClient);
			writer.close();
			return 200;
		} catch (IOException e) {
			return 304;
		}
	}

	// TimeStamp
	private static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
	
	
	private static String deleteFile(String filePath) {
        try {
            Files.deleteIfExists(Paths.get(filePath));
        }
        catch (NoSuchFileException e) {
        	return "No such file/directory exists";
        }
        catch (DirectoryNotEmptyException e) {
        	return "Directory is not empty.";
        }
        catch (IOException e) {
            return "Invalid permissions.";
        }
 
        return "Deletion successful.";
	}
}
