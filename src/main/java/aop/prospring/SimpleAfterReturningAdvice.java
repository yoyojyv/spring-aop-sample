package aop.prospring;

import aop.proxy.hello.MessageWriter;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by yoyojyv on 2014. 2. 27..
 */
public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        // create the proxy
        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(new SimpleAfterReturningAdvice());
        pf.setTarget(target);

        MessageWriter proxy = (MessageWriter) pf.getProxy();

        // write the messages
        proxy.writeMessage();
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("");
        System.out.println("After method: " + method.getName());
    }
}
