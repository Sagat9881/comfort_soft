package ru.apzakharov.comfort_soft.demo.application.exepction;

public class UseCaseException extends ApplicationException {
    public static final String LAYER = "UseCase";

    public UseCaseException(Exception e) {
        super(e, LAYER);
    }
}
