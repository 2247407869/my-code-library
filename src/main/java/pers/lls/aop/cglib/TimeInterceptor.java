package pers.lls.aop.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimeInterceptor implements MethodInterceptor {

    private Object target;

    public TimeInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object proxy,
                            Method method,
                            Object[] args,
                            MethodProxy invocation
    ) throws Throwable {
        System.out.println("方法之前："+System.currentTimeMillis());
        Object ret = invocation.invoke(target, args); 
        System.out.println("方法之后："+System.currentTimeMillis());
        
        return ret;
    }
}