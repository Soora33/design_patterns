package com.sora.observer;

import com.sora.subject.Subject;

/**
 * @Classname Observer
 * @Description 被观察接口
 * @Date 2024/08/29 10:57
 * @Author by Sora33
 */
public interface Observer {
    void addSubject(Subject subject);

    void removeSubject(Subject subject);

    void notifyObservers(String message);
}
