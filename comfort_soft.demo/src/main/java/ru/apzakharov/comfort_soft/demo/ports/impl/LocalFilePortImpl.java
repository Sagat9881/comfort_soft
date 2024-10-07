package ru.apzakharov.comfort_soft.demo.ports.impl;

import ru.apzakharov.comfort_soft.demo.ports.LocalFilePort;

import java.io.File;

public class LocalFilePortImpl implements LocalFilePort {

    @Override
    public File getFromPath(String path) {

        return path.isBlank() ? null : new File(path);
    }
}
