package mate.academy.hw07;

import mate.academy.hw07.di.Injector;
import mate.academy.hw07.handler.ConsoleHandler;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Injector.injectDependency();
        ConsoleHandler.handler();
    }
}
