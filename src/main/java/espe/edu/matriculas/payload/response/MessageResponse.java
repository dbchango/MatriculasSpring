package espe.edu.matriculas.payload.response;

public class MessageResponse {
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageResponse(String message) {
        super();
        this.message = message;
    }

    public MessageResponse() {
        super();
    }
}
