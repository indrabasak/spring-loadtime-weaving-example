package com.basaki.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@code FilterCallerAnnotationAspect} intercepts {@code
 * com.basaki.service.UselessService.sayHello} a
 * method if the calling method is {@code com.basaki.service.BookService.read}.
 * <p>
 *
 * @author Indra Basak
 * @since 02/10/18
 */
@Aspect
public class FilterCallerMethodAspect {

    private static final Logger
            log = LoggerFactory.getLogger(FilterCallerMethodAspect.class);

    @Before("call(* com.basaki.service.UselessService.sayHello(..))" +
            "  && cflow(execution(* com.basaki.service.BookService.read(..)))")
    public void inspectMethod(JoinPoint jp,
            JoinPoint.EnclosingStaticPart esjp) {
        log.info(
                "Entering FilterCallerMethodAspect.inspectMethod() in class "
                        + jp.getSignature().getDeclaringTypeName()
                        + " - method: " + jp.getSignature().getName());
    }
}
