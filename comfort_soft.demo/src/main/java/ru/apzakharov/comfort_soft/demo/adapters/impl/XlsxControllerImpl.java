package ru.apzakharov.comfort_soft.demo.adapters.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.apzakharov.comfort_soft.demo.adapters.XlsxController;
import ru.apzakharov.comfort_soft.demo.domain.usecase.GetMaxFromFileUC;

@RequiredArgsConstructor
public class XlsxControllerImpl implements XlsxController {

    @Autowired
    private GetMaxFromFileUC getMaxFromFileUC;

    @Override
    public int getMaxFromFile(String path, int bound) {
        return getMaxFromFileUC.getMaxFromFileUC(path, bound);
    }
}
