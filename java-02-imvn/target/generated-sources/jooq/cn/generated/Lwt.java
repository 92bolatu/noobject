/**
 * This class is generated by jOOQ
 */
package cn.generated;


import cn.generated.tables.Books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Lwt extends SchemaImpl {

	private static final long serialVersionUID = -2055790035;

	/**
	 * The reference instance of <code>lwt</code>
	 */
	public static final Lwt LWT = new Lwt();

	/**
	 * No further instances allowed
	 */
	private Lwt() {
		super("lwt");
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			Books.BOOKS);
	}
}
