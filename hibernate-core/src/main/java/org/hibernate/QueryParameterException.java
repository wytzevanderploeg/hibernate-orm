/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate;

/**
 * Indicates a problem with the runtime arguments bound to query parameters.
 * 
 * @author Emmanuel Bernard
 */
public class QueryParameterException extends QueryException {
	/**
	 * Constructs a {@code QueryParameterException} using the supplied exception message.
	 *
	 * @param message The message explaining the exception condition
	 */
	public QueryParameterException(String message) {
		super( message );
	}

	/**
	 * Constructs a {@code QueryParameterException}
	 *
	 * @param message The message explaining the exception condition
	 * @param queryString The query that led to the exception
	 * @param cause The underlying cause
	 */
	public QueryParameterException(String message, String queryString, Exception cause) {
		super( message, queryString, cause );
	}

	/**
	 * Constructs a {@code QueryParameterException}
	 *
	 * @param message The message explaining the exception condition
	 * @param queryString The query that led to the exception
	 */
	public QueryParameterException(String message, String queryString) {
		super( message, queryString );
	}
}
