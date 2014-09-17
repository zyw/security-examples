package cn.v5cn.security.shiro_spring.annotation;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if(parameter.hasParameterAnnotation(CurrentUser.class)){
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,ModelAndViewContainer mavContainer, NativeWebRequest webRequest,WebDataBinderFactory binderFactory) throws Exception {
		CurrentUser currentUser = parameter.getParameterAnnotation(CurrentUser.class);
		return webRequest.getAttribute(currentUser.value(), NativeWebRequest.SCOPE_REQUEST);
	}

}
