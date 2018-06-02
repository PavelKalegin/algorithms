package application.greedy.models;

public class Command {
    private CommandType type;
    private int value;

    public Command() {
    }

    public Command(CommandType type, int value) {
        this.type = type;
        this.value = value;
    }

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
