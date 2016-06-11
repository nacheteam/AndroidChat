package edu.galileo.android.androidchat.lib;

/**
 * Created by nacheteam on 10/06/16.
 */
public interface EventBus {

    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);

}
