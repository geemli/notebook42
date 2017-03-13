package command.desccription;

/**
 * Created by dznor on 23.02.2017.
 */
public class Option {

    private String arg;
    private boolean required;
    private String description;
    private String valueType;

    public Option(String arg, boolean required, String description) {
        this.arg = arg;
        this.required = required;
        this.description = description;
    }

    public String getArg() {
        return arg;
    }

    public boolean isRequired() {
        return required;
    }

    public String getDescription() {
        return description;
    }
}
