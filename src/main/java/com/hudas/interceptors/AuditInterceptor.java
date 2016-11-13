package com.hudas.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by Ignas on 2016-11-12.
 */

@Audit
@Interceptor
public class AuditInterceptor {

    @AroundInvoke
    public Object audit(InvocationContext context) throws Exception {

        // Audits which method was invoked at which time etc.

        return context.proceed();
    }


}
