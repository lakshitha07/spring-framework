package aspects;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Invoker {

    private final Operation operation;
    private final List<AdviceType> adviceTypes = List.of(
            AdviceType.BEFORE,
            AdviceType.AFTER_RETURNING,
            AdviceType.AFTER_THROWING,
            AdviceType.AFTER,
            AdviceType.AROUND
    );

    public Invoker(Operation operation) {
        this.operation = operation;
    }

    public void run() {
        adviceTypes.forEach(advice -> {
            switch (advice) {
                case BEFORE -> operation.beforeMethodCall();
                case AFTER_RETURNING -> operation.returnSomeValue();
                case AFTER_THROWING -> {
                    try {
                        operation.throwAnException();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                case AFTER -> {
                    try {
                        operation.returnAnything();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                case AROUND -> operation.manualHandling();
            }
            ;
        });
    }
}
