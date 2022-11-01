package model;

public class Request {
    private String method;
    private String target;
    private String version = "HTTP/1.1";
    private String host;
    private String body = "";

    public Request(String method, String target, String host) {
        this.method = method;
        this.target = target;
        this.host = host;
    }

    public Request(String method, String target, String host, String body) {
        this.method = method;
        this.target = target;
        this.host = host;
        this.body = body;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getVersion() {
        return version;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public String requestMessage(){
        return method + " /" + target + " " + version + "\nUser-Agent: Mozilla/5.0\n\n" + body;
    }
}
