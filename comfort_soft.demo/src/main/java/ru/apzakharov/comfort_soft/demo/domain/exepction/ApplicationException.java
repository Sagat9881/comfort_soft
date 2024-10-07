package ru.apzakharov.comfort_soft.demo.domain.exepction;

public abstract class ApplicationException extends RuntimeException {
    private final String layout;

    public ApplicationException(Exception e, String layout) {
        super(e);
        this.layout = layout;
    }

    @Override
    public String toString() {
        return "ApplicationException{" +
                "layout='" + layout + '\'' +
                "message='" + getMessage() + '\'' +
                '}';
    }
}
