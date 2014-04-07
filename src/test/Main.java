package test;

import java.util.Arrays;
import java.util.List;

import base.F0;
import base.F1;
import base.F2;
import base.FJ;
import base.Lists;
import base.Prelude;

public class Main {

	public static String foo() {
		return "foo";
	}

	public String bar() {
		return "bar";
	}

	public static void main(String[] args) {
		List<Integer> tmp = Arrays.asList(1, 2, 3, 4, 5);
		F2<Integer, Integer, Integer> add = new F2<Integer, Integer, Integer>() {
			public Integer apply(Integer a, Integer b) {
				return a - b;
			}
		};
		System.out.println(Prelude.foldr(add, tmp, 0));

		F1<Double, Double> sq = FJ.mkF1(Math.class, "sqrt", double.class);
		List<Double> l = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
		System.out.println(Prelude.map(sq, l));

		F0<String> a = FJ.mkF0(Main.class, "foo");
		System.out.println("a() = " + a.apply());
		F0<String> b = FJ.mkF0(new Main(), "bar");
		System.out.println("b() = " + b.apply());

		F2<Integer, Integer, Integer> f = new F2<Integer, Integer, Integer>() {
			public Integer apply(Integer a, Integer b) {
				return a * b;
			}
		};

		F1<Integer, Integer> twice = new F1<Integer, Integer>() {
			public Integer apply(Integer a) {
				return 2 * a;
			}
		};

		List<Integer> t = Arrays.asList(1, 2, 3, 4);
		List<Integer> u = Arrays.asList(5, 6, 7, 8);
		System.out.println(Lists.concat(t, u));
		System.out.println(Prelude.map(twice, t));

		int x = 2;
		F1<Integer, Integer> g = f.curry(x);
		F0<Integer> h = f.curry(x).curry(7);
		int y = g.apply(5);
		System.out.println(y);
		System.out.println(h.apply());
	}
}
