package br.univille.observer;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("Subject: Attached an observer.");
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("Subject: Detached an observer.");
    }

    @Override
    public void notifyObservers() {
        System.out.println("Subject: Notifying observers...");
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

// Observer interface
interface Observer {
    void update(ConcreteSubject subject);
}

// Concrete Observer A
class ConcreteObserverA implements Observer {
    @Override
    public void update(ConcreteSubject subject) {
        if (subject.getState() < 5) {
            System.out.println("ConcreteObserverA: Reacted to the event.");
        }
    }
}

// Concrete Observer B
class ConcreteObserverB implements Observer {
    @Override
    public void update(ConcreteSubject subject) {
        if (subject.getState() >= 5) {
            System.out.println("ConcreteObserverB: Reacted to the event.");
        }
    }
}

// Main class to demonstrate the pattern
public class ObserverPattern {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserverA observerA = new ConcreteObserverA();
        ConcreteObserverB observerB = new ConcreteObserverB();

        subject.attach(observerA);
        subject.attach(observerB);

        System.out.println("\nChanging state to 3...");
        subject.setState(3);

        System.out.println("\nChanging state to 7...");
        subject.setState(7);

        System.out.println("\nDetaching ConcreteObserverA...");
        subject.detach(observerA);

        System.out.println("\nChanging state to 2...");
        subject.setState(2);
    }
}