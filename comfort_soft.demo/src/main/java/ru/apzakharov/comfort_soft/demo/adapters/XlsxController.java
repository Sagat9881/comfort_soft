package ru.apzakharov.comfort_soft.demo.adapters;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "XLSX", description = "Контроллер для работы с XLSX")
public interface XlsxController {

    @GetMapping(path = "/{bound}")
    @Operation(summary = "Получение максимального значения из файла", tags = "XLSX")
    Integer getMaxFromFile(@Parameter(description = "Путь к файлу") @RequestParam(name = "path") String path,
                                           @Parameter(description = "Ограничение выборки") @PathVariable(name = "bound") Integer bound);
}
