package robot.challenge.model;

public enum CommandEnum {
    PLACE("PLACE") , MOVE("MOVE") , LEFT("LEFT") , RIGHT("RIGHT") , REPORT("REPORT"), ROBOT("ROBOT");

    String description;

    CommandEnum(String description){
        this.description = description;
    }

    public String toString(){
        return this.description;
    }
}