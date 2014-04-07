package base;

public abstract class F3<R, A, B, C> {

	public F0<R> curry(final A a, final B b, final C c) {
		final F3<R, A, B, C> that = this;
		return new F0<R>() {
			public R apply() {
				return that.apply(a, b, c);
			}
		};
	}

	public F1<R, C> curry(final A a, final B b) {
		final F3<R, A, B, C> that = this;
		return new F1<R, C>() {
			public R apply(C c) {
				return that.apply(a, b, c);
			}
		};
	}

	public F2<R, B, C> curry(final A a) {
		final F3<R, A, B, C> that = this;
		return new F2<R, B, C>() {
			public R apply(B b, C c) {
				return that.apply(a, b, c);
			}
		};
	}

	public abstract R apply(A a, B b, C c);
}
