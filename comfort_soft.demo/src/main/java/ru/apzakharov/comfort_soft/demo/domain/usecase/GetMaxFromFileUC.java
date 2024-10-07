package ru.apzakharov.comfort_soft.demo.domain.usecase;

import ru.apzakharov.comfort_soft.demo.application.annotation.UseCase;

@UseCase
public interface GetMaxFromFileUC {

    int getMaxFromFileUC(String path, int boundary);
}
