package com.sora.observer;

import com.sora.subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ManagerObServer
 * @Description CEO
 * @Date 2024/08/29 10:59
 * @Author by Sora33
 */
public class CEOObServer implements Observer {

    private List<Subject> observers = new ArrayList<>();

    @Override
    public void addSubject(Subject subject) {
        observers.add(subject);
    }

    @Override
    public void removeSubject(Subject subject) {
        observers.remove(subject);
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(data -> data.update(message));
    }
}
