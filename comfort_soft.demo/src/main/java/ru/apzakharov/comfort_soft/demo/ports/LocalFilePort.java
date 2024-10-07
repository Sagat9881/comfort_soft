package ru.apzakharov.comfort_soft.demo.ports;

import ru.apzakharov.comfort_soft.demo.application.annotation.Port;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Port
public interface LocalFilePort {

    File getFromPath(String path);

    default FileInputStream fileStream(String path) throws FileNotFoundException {
        return new FileInputStream(getFromPath(path));
    }
}
