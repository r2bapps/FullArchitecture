package r2b.apps.gnome.data.strategy;


import java.util.List;

public interface CachingStrategy<T> {
    boolean isValid(T data);
    boolean isValid(List<T> data);
}
