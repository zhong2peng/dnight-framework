package com.dnight.base.framework.common.interceptor;

import com.dnight.base.framework.common.annotation.NoAuth;
import com.dnight.base.framework.common.annotation.NoLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 登录校验拦截器
 *
 * @author Jiangkui
 * @date 2018年11月06日
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationInterceptor.class);

//    @Autowired
//    private IAuthorizationService authorizationService;
//
//
//    @Autowired
//    private EstimatorService estimatorService;
//
//    @Autowired
//    private AccountIdentityService accountIdentityService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class<?> clazz = handlerMethod.getBeanType();
        Method m = handlerMethod.getMethod();
        //无论是否免登陆先set-Cookie
        HttpSession session = request.getSession();
        //免登陆
        if ( clazz.isAnnotationPresent(NoLogin.class) || m.isAnnotationPresent(NoLogin.class)) {
            LOGGER.info("standard.account.login.immediate cause:{}", NoLogin.class);
            return true;
        }
//        Object loginStateAttribute = session.getAttribute(SessionVisitor.SESSION_LOGIN_STATE);
//        if (loginStateAttribute == null) {
//            final String msg = "standard.account.login.loginState.fail";
//            LOGGER.error(msg);
//            throw new UnauthorizedException(msg);
//
//        } else if (!SessionVisitor.checkIsLogin((Integer) loginStateAttribute)) {
//            final String msg = String.format("standard.account.login.loginState.fail  loginStateAttribute:%s not correct", loginStateAttribute);
//            LOGGER.error(msg);
//            throw new AccessForbiddenException(msg);
//        }
//
//        Object accountAttribute = session.getAttribute(SessionVisitor.SESSION_ACCOUNT);
//        if (accountAttribute == null) {
//            final String msg = "standard.account.login.account.fail accountAttribute is null  ";
//            LOGGER.error(msg);
//            throw new UnauthorizedException(msg);
//        }
//
//        Long account = Long.valueOf(String.valueOf(accountAttribute));
//        SessionVisitor visitor = authorizationService.getVisitor(account);
//        if (visitor == null) {
//            final String msg = String.format("standard.account.login.account.fail visitor is null account:%s", account);
//            LOGGER.error(msg);
//            throw new UnauthorizedException(msg);
//        }
//
//        UserThreadContext.putSessionVisitor(visitor);
//        if(accountIdentityService.currentAccountIsEstimator()) {
//            AccountEstimatorDto accountEstimatorDto = estimatorService.findEstimatorById(UserThreadContext.getSessionVisitor().getAccountId());
//            EstimatorContext.putEstimator(accountEstimatorDto);
//        }
        //权限校验
        if (clazz.isAnnotationPresent(NoAuth.class) || m.isAnnotationPresent(NoAuth.class)) {
            LOGGER.info("standard.account.login.immediate cause:{}", NoAuth.class);
            return true;
        }
        return true;

//        return authorizationService.checkAuthorization(account, request);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
