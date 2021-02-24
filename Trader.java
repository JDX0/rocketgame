import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trader extends Actor
{
    private String question;
    private String response;
    private int job;
    
    public Trader(String question, int job)
    {
        this.question = question;
        this.job = job;
        this.response = response;
    }
    public String getQuestion()
    {
        return this.question;
    }
    public void setResponse(String response)
    {
        this.response = response;
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
