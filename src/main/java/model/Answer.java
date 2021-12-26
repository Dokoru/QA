package model;

public class Answer {
    public final int id;
    public final int questionID;
    public final int ownerID;
    public final String text;

    public Answer(int id, int questionID, int ownerID, String text) {
        this.id = id;
        this.questionID = questionID;
        this.ownerID = ownerID;
        this.text = text;
    }

    public Answer(Answer answer, String text) {
        this.id = answer.id;
        this.questionID = answer.questionID;
        this.ownerID = answer.ownerID;
        this.text = text;
    }
}