package ru.apzakharov.comfort_soft.demo.adapters;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "XLSX", description = "Конроллер для работы с XLSX")
@RequestMapping("/xlsx")
public interface XlsxController {

    @GetMapping(value = "/{bound}")
    @Operation(summary = "Получение максимального значения из файла",tags = "XLSX")
    int getMaxFromFile(@Parameter(description = "Путь к файлу") @RequestParam(name = "path") String path,
                       @Parameter(description = "Ограничение выборки") @PathVariable(name = "bound") int bound);
}
