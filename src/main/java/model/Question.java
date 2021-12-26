package model;

public class Question {
    public final int id;
    public final int ownerID;
    public final String topic;
    public final String text;

    public Question(int id, int ownerID, String topic, String text) {
        this.id = id;
        this.ownerID = ownerID;
        this.topic = topic;
        this.text = text;
    }

    public Question(Question question, String topic, String text) {
        this.id = question.id;
        this.ownerID = question.ownerID;
        this.topic = topic;
        this.text = text;
    }
}