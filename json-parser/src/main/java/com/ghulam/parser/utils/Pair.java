package com.ghulam.parser.utils;

public class Pair<T, U> {
    private T key;
    private U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public Pair<T, U> of(T key, U value) {
        return new Pair<>(key, value);
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }
}
