package ru.apzakharov.comfort_soft.demo.domain.exepction;

public class UseCaseException extends ApplicationException {
    private static final String LAYER = "UseCase";

    public UseCaseException(Exception e) {
        super(e, LAYER);
    }
}
