package com.axa.gnome.data.strategy;


import java.util.List;

public interface SyncStrategy<T> {
    T apply(T retrieved, T stored);
    List<T> apply(List<T> retrieved, List<T> stored);
}
