package model;

public class Response {
    private String version = "HTTP/1.1";
    private int statusCode;
    private String statusPhrase;
    private String body = "";

    public Response() {
    }

    public Response(int statusCode, String statusPhrase, String body) {
        this.statusCode = statusCode;
        this.statusPhrase = statusPhrase;
        this.body = body;
    }
    
    public Response(int statusCode, String statusPhrase) {
        this.statusCode = statusCode;
        this.statusPhrase = statusPhrase;
    }

    public String getVersion() {
        return version;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusPhrase() {
        return statusPhrase;
    }

    public void setStatusPhrase(String statusPhrase) {
        this.statusPhrase = statusPhrase;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public String responseMessage() {
        return version + " " + statusCode + " " + statusPhrase + "\nServer: WebServer\nContent-Type: text/html\nContent-Length: " + body.length() + "\n" + body;
    }
}

