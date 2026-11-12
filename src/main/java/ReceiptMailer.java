public class ReceiptMailer {
    private final EmailClient client;

    public ReceiptMailer(EmailClient client) {
        this.client = client;
    }

    public void send(String email, double total) {
        client.send(email,"Your total is" + total);
    }
}
