package aspects;

public interface Operation {

    void beforeMethodCall();
    String returnSomeValue();
    void throwAnException() throws Exception;
    String returnAnything() throws Exception;
    int manualHandling();
}
