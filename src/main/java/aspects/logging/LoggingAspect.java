package aspects.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Pointcut("@annotation(aspects.logging.Log)")
    public void logAnnotation() {
    }

    @Pointcut("execution(* controller.*.*(..))")
    public void controllerExecutions() {
    }

    @Before("logAnnotation()")
    public void logAnnotationAdvice(JoinPoint joinPoint) {
        log.info("@Log Method called: " + joinPoint.getSignature().getName());
        log.info(createJoinPointForLogs(joinPoint));
    }

    @Before("controllerExecutions()")
    public void controllerExecutionsAdvice(JoinPoint joinPoint) {
        log.info("Controller methods, method called: " + joinPoint.getSignature().getName());
        log.info(createJoinPointForLogs(joinPoint));
    }

    private String createJoinPointForLogs(JoinPoint joinPoint) {
        if (joinPoint.getArgs().length < 1) {
            return joinPoint.getSignature().getName().concat(" method don`t have parameters");
        }
        Object[] obj = joinPoint.getArgs();
        StringBuilder requestValue = new StringBuilder();
        Arrays.stream(obj).forEach(x -> {
            requestValue.append(x.toString());
            requestValue.append("\r\n");
        });
        requestValue.append("\r\n============= =======" + "====== =============");
        return requestValue.toString();
    }
}
