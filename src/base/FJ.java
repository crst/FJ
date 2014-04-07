package base;

import java.lang.reflect.Method;

public class FJ {

	public static <R> F0<R> mkF0(final Class<?> c, String methodName) {
		try {
			final Method m = c.getMethod(methodName);
			return new F0<R>() {
				@SuppressWarnings("unchecked")
				public R apply() {
					R result = null;
					try {
						result = (R) m.invoke(null);
					} catch (Exception e) {
					}
					return result;
				}
			};
		} catch (Exception e) {
			return null;
		}
	}

	public static <R> F0<R> mkF0(final Object o, String methodName,
			Class<?>... argTypes) {
		try {
			final Method m = o.getClass().getMethod(methodName, argTypes);
			return new F0<R>() {
				@SuppressWarnings("unchecked")
				public R apply() {
					R result = null;
					try {
						result = (R) m.invoke(o);
					} catch (Exception e) {
					}
					return result;
				}
			};
		} catch (Exception e) {
			return null;
		}
	}

	public static <R, A> F1<R, A> mkF1(final Class<?> c, String methodName,
			Class<?>... argTypes) {
		try {
			final Method m = c.getMethod(methodName, argTypes);
			return new F1<R, A>() {
				@SuppressWarnings("unchecked")
				public R apply(A a) {
					R result = null;
					try {
						result = (R) m.invoke(null, a);
					} catch (Exception e) {
					}
					return result;
				}
			};
		} catch (Exception e) {
			return null;
		}
	}

	public static <R, A> F1<R, A> mkF1(final Object o, String methodName,
			Class<?>... argTypes) {
		try {
			final Method m = o.getClass().getMethod(methodName, argTypes);
			return new F1<R, A>() {
				@SuppressWarnings("unchecked")
				public R apply(A a) {
					R result = null;
					try {
						result = (R) m.invoke(o, a);
					} catch (Exception e) {
					}
					return result;
				}
			};
		} catch (Exception e) {
			return null;
		}
	}

	public static <R, A, B> F2<R, A, B> mkF2(final Class<?> c,
			String methodName, Class<?>... argTypes) {
		try {
			final Method m = c.getMethod(methodName, argTypes);
			return new F2<R, A, B>() {
				@SuppressWarnings("unchecked")
				public R apply(A a, B b) {
					R result = null;
					try {
						result = (R) m.invoke(null, a, b);
					} catch (Exception e) {
					}
					return result;
				}
			};
		} catch (Exception e) {
			return null;
		}
	}

	public static <R, A, B> F2<R, A, B> mkf2(final Object o, String methodName,
			Class<?>... argTypes) {
		try {
			final Method m = o.getClass().getMethod(methodName, argTypes);
			return new F2<R, A, B>() {
				@SuppressWarnings("unchecked")
				public R apply(A a, B b) {
					R result = null;
					try {
						result = (R) m.invoke(o, a, b);
					} catch (Exception e) {
					}
					return result;
				}
			};
		} catch (Exception e) {
			return null;
		}
	}
}
