package base;

import java.util.LinkedList;
import java.util.List;

public class Lists {

	public static <R> List<R> concat(List<R> a, List<R> b) {
		List<R> result = new LinkedList<R>(a);
		result.addAll(b);
		return result;
	}

}
