package com.axa.gnome.data.strategy.cache;

import java.util.List;

import com.axa.gnome.data.strategy.CachingStrategy;


public class TimeCachingStrategy<T extends Cached> implements CachingStrategy<T> {

    private final long delayMilliseconds;

    public TimeCachingStrategy(long delayMilliseconds) {

        // PRECONDITIONS
        if (delayMilliseconds < 0) {
            throw new IllegalArgumentException("The delay must be a positive number");
        }

        this.delayMilliseconds = delayMilliseconds;
    }

    @Override
    public boolean isValid(T data) {
        return (data.getCurrentPersistedTime() + delayMilliseconds) > System.currentTimeMillis();
    }

    @Override
    public boolean isValid(List<T> data) {
        for(T t : data) {
            if(!isValid(t)) {
                return false;
            }
        }
        return true;
    }

}
