package com.springapp.mvc.hanlder;


import com.alibaba.fastjson.JSON;
import com.springapp.mvc.pojo.Animal;
import org.springframework.core.MethodParameter;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by chj on 2016/1/29.
 */
public class HandleReturn implements HandlerMethodReturnValueHandler {
    /**
     * Whether the given {@linkplain MethodParameter method return type} is
     * supported by this handler.
     *
     * @param returnType the method return type to check
     * @return {@code true} if this handler supports the supplied return type;
     * {@code false} otherwise
     */
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return true;

       //return returnType.getParameterType().isAssignableFrom(Animal.class);
    }

    /**
     * Handle the given return value by adding attributes to the model and
     * setting a view or setting the
     * {@link ModelAndViewContainer#setRequestHandled} flag to {@code true}
     * to indicate the response has been handled directly.
     *
     * @param returnValue  the value returned from the handler method
     * @param returnType   the type of the return value. This type must have
     *                     previously been passed to
     *                     {@link #supportsReturnType(MethodParameter)}
     *                     and it must have returned {@code true}
     * @param mavContainer the ModelAndViewContainer for the current request
     * @param webRequest   the current request
     * @throws Exception if the return value handling results in an error
     */
    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {

        HttpServletResponse rsp=webRequest.getNativeResponse(HttpServletResponse.class);

        System.out.println("fast json ");
        rsp.setContentType("application/json;charset=UTF-8");
        rsp.getWriter().write(JSON.toJSONString(returnValue));
        mavContainer.setRequestHandled(true);
    }
}
