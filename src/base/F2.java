package base;

public abstract class F2<R, A, B> {

	public F0<R> curry(final A a, final B b) {
		final F2<R, A, B> that = this;
		return new F0<R>() {
			public R apply() {
				return that.apply(a, b);
			}
		};
	}

	public F1<R, B> curry(final A a) {
		final F2<R, A, B> that = this;
		return new F1<R, B>() {
			public R apply(B b) {
				return that.apply(a, b);
			}
		};
	}

	public abstract R apply(A a, B b);
}
