package base;

public abstract class F1<R, A> {

	public F0<R> curry(final A a) {
		final F1<R, A> that = this;
		return new F0<R>() {
			public R apply() {
				return that.apply(a);
			}
		};
	}

	public abstract R apply(A a);

}
