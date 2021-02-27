import greenfoot.*;

public class Trader extends Actor {
    private String question;
    private String response;
    private int job;
    
    public Trader(String question, int job) {
        this.question = question;
        this.job = job;
        this.response = response;
    }
    
    public String getQuestion() { return this.question; }
    public void setResponse(String response) { this.response = response; } 
}
