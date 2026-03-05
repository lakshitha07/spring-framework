package aspects;

import org.springframework.stereotype.Component;

@Component
public class OperationImpl implements Operation {

    @Override
    public void beforeMethodCall() {
        System.out.println("invoked beforeMethodCall()");
    }

    @Override
    public String returnSomeValue() {
        return "this is returned value";
    }

    @Override
    public void throwAnException() throws Exception {
        throw new Exception("this is a mock exception!");
    }

    @Override
    public String returnAnything() throws Exception {
        final int number = 100 + (int)(Math.random() * 2);
        if(number == 101)
            throw new Exception("this is a mock exception!");
        return "this is returned value";
    }

    @Override
    public int manualHandling() {
        return 101;
    }
}
