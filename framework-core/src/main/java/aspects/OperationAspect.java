package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class OperationAspect {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Before("execution(void aspects.Operation.beforeMethodCall())")
    public void trackBeforeMethodCall(JoinPoint jp) {
        logger.info(" method call" + jp.getSignature() + "is about to happen!");
    }

    @AfterReturning(value = "execution(String aspects.Operation.returnSomeValue())", returning = "value")
    public void trackReturnSomeValue(JoinPoint jp, String value) {
        logger.info("method call " + jp.getSignature() + "returned: " + value);
    }

    @AfterThrowing(value = "execution(void aspects.Operation.throwAnException())", throwing = "exc")
    public void trackThrowAnException(JoinPoint jp, Throwable exc) {
        logger.info("method call " + jp.getSignature() + "threw an exception:" + exc.toString());
    }

    @After("execution(String aspects.Operation.returnAnything())")
    public void trackReturnAnything(JoinPoint jp) {
        logger.info("method call " + jp.getSignature() + "invoked. This is from advice");
    }

    //we have to return the value from the original method
    //since we manually call the original method through the proxy,
    // spring expects us to return the value in advice method
    @Around("execution(int aspects.Operation.manualHandling())")
    public int trackManualHandling(ProceedingJoinPoint pjp) {
        logger.info("method call " + pjp.getSignature());
        int value = 0;
        try {
            // here, we need to manually call the method
            value = (int) pjp.proceed();
            logger.info("returned value : " + value);
        } catch (Throwable e) {
            logger.info(e.toString());
        }
        return value;
    }

}
