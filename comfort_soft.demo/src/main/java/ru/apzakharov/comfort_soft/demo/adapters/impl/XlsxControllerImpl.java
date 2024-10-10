package ru.apzakharov.comfort_soft.demo.adapters.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.apzakharov.comfort_soft.demo.adapters.XlsxController;
import ru.apzakharov.comfort_soft.demo.domain.usecase.GetMaxFromFileUC;

import java.util.Optional;

@RequiredArgsConstructor
@RestController(value = "/xlsx")
@RequestMapping(path = "/xlsx")
public class XlsxControllerImpl implements XlsxController {

    @Autowired
    private GetMaxFromFileUC getMaxFromFileUC;

    @Override
    public Integer getMaxFromFile(String path, Integer bound) {
        return getMaxFromFileUC.getMaxFromFileUC(path, bound);
    }
}
