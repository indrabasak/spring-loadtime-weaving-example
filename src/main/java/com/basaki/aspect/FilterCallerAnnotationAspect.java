package com.basaki.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@code FilterCallerAnnotationAspect} intercepts {@code
 * com.basaki.service.UselessService.sayHello} a
 * method if the calling method is marked with annotaion
 * {@code org.springframework.transaction.annotation.Transactional}.
 * <p>
 *
 * @author Indra Basak
 * @since 02/10/18
 */
@Aspect
public class FilterCallerAnnotationAspect {

    private static final Logger
            log = LoggerFactory.getLogger(FilterCallerAnnotationAspect.class);

    @Before("call(* com.basaki.service.UselessService.sayHello(..))" +
            "  && cflow(@annotation(trx))")
    public void inspectMethod(JoinPoint jp,
            JoinPoint.EnclosingStaticPart esjp, Transactional trx) {
        log.info(
                "Entering FilterCallerAnnotationAspect.inspectMethod() in class "
                        + jp.getSignature().getDeclaringTypeName()
                        + " - method: " + jp.getSignature().getName());
    }
}
