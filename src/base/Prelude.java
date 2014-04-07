package base;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Prelude {

	/**
	 * This is the <code>map</code function defined as a Function object F2.
	 * Usually you probably want to use the convenience method
	 * {@link Prelude#map(F1, Collection)} instead of the real Function object,
	 * however this one is needed if you really want the 'Function', e.g. if you
	 * need to curry it.
	 *
	 * @see Prelude#map(F1, Collection)
	 *
	 * @param <R>
	 *            Type of the elements in the resulting List.
	 * @param <A>
	 *            Type of the elements in the argument list.
	 * @return The <code>map</code> Function object, where you need to call
	 *         <code>apply</code> with arguments in order to actually get the
	 *         result.
	 */
	public static <R, A> F2<List<R>, F1<R, A>, Collection<A>> map() {
		return new F2<List<R>, F1<R, A>, Collection<A>>() {
			public List<R> apply(F1<R, A> f, Collection<A> c) {
				List<R> result = new LinkedList<R>();
				for (A t : c) {
					result.add(f.apply(t));
				}
				return result;
			}
		};
	};

	/**
	 * Directly apply the <code>map</code> 'function' with the given arguments.
	 * This is more or less just a convenience 'function' for the real Function
	 * object, which automatically calls the apply method.
	 *
	 * @param <R>
	 *            Type of the elements in the resulting list.
	 * @param <A>
	 *            Type of elements in the argument list.
	 * @param f
	 *            'Function' to apply.
	 * @param c
	 *            Collection to which elements the 'function' is applied.
	 * @return A new List r = [f(c[0]), f(c[1]), ...]
	 */
	public static <R, A> List<R> map(F1<R, A> f, Collection<A> c) {
		F2<List<R>, F1<R, A>, Collection<A>> map = Prelude.map();
		return map.apply(f, c);
	};

	public static <R> F2<List<R>, F1<Boolean, R>, Collection<R>> filter() {
		return new F2<List<R>, F1<Boolean, R>, Collection<R>>() {
			public List<R> apply(F1<Boolean, R> f, Collection<R> c) {
				List<R> result = new LinkedList<R>();
				for (R r : c) {
					if (f.apply(r)) {
						result.add(r);
					}
				}
				return result;
			}
		};
	};

	public static <R> List<R> filter(F1<Boolean, R> f, Collection<R> c) {
		F2<List<R>, F1<Boolean, R>, Collection<R>> filter = Prelude.filter();
		return filter.apply(f, c);
	}

	public static <R, A> F3<R, F2<R, A, R>, Collection<A>, R> foldr() {
		return new F3<R, F2<R, A, R>, Collection<A>, R>() {
			public R apply(F2<R, A, R> f, Collection<A> b, R c) {
				R result = c;
				for (A t : b) {
					result = f.apply(t, result);
				}
				return result;
			}
		};
	};

	public static <R, A> R foldr(F2<R, A, R> f, Collection<A> c, R i) {
		F3<R, F2<R, A, R>, Collection<A>, R> reduce = Prelude.foldr();
		return reduce.apply(f, c, i);
	}

}
