package me.study.core.singleton;

public class SingletonService {
    private static final SingletonService singletonService = new SingletonService();

    public static SingletonService getInstance() {
        return singletonService;
    }

    private SingletonService() {

    }
}
