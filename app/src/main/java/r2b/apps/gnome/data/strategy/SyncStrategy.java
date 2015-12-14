package r2b.apps.gnome.data.strategy;


import java.util.List;

public interface SyncStrategy<T> {
    T apply(T retrieved, T stored);
    List<T> apply(List<T> retrieved, List<T> stored);
}
