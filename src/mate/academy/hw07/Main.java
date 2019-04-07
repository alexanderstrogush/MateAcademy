package hw07;

import hw07.di.Injector;
import hw07.handler.ConsoleHandler;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Injector.injectDependency();
        ConsoleHandler.handler();
    }
}
