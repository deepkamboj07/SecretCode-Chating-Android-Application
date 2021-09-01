package com.example.myapplication.Model;

public class Chat {

    private String sender;
    private String recevier;
    private String message;
    private String username;

    public Chat(String sender,String receiver,String message,String username){
        this.sender=sender;
        this.message=message;
        this.recevier=receiver;
        this.username=username;
    }
    public Chat(){

    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecevier() {
        return recevier;
    }

    public void setRecevier(String recevier) {
        this.recevier = recevier;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername()
    {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
