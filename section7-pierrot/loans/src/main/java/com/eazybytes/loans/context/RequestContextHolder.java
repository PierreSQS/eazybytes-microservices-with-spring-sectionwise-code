package com.eazybytes.loans.context;

public class RequestContextHolder {

	private static final ThreadLocal<RequestContext> requestContext = new ThreadLocal<>();

	private RequestContextHolder() {
	}

	public static RequestContext getContext() {
		RequestContext context = requestContext.get();

		if (context == null) {
			context = createEmptyContext();
			requestContext.set(context);

		}
		return requestContext.get();
	}

	public static void setContext(RequestContext context) {
		requestContext.set(context);
	}

	public static RequestContext createEmptyContext() {
		return new RequestContext();
	}

}
