package ru.apzakharov.comfort_soft.demo.domain.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.apzakharov.comfort_soft.demo.application.exepction.UseCaseException;
import ru.apzakharov.comfort_soft.demo.domain.usecase.impl.GetMaxFromFileUCImpl;
import ru.apzakharov.comfort_soft.demo.ports.impl.LocalFilePortImpl;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class GetMaxFromFileUCTest {
    private static final String XSLX_FILE_PATH = "./src/main/resources/xlsx/sample_1.xlsx";

    private GetMaxFromFileUC useCase = new GetMaxFromFileUCImpl(new LocalFilePortImpl());

    @Test
    void getMaxFromFileUC() {
        int maxFromFileUC = useCase.getMaxFromFileUC(XSLX_FILE_PATH, 5);

        assertEquals(5, maxFromFileUC);
    }

    @Test
    void shouldRaiseException() {
        UseCaseException useCaseException = assertThrows(UseCaseException.class, () -> useCase.getMaxFromFileUC("", 5));
        assertEquals(useCaseException.getLayout(), UseCaseException.LAYER);
    }

}