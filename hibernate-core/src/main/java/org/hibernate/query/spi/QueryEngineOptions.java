/*
 * SPDX-License-Identifier: LGPL-2.1-or-later
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.query.spi;

import java.util.Map;

import org.hibernate.jpa.spi.JpaCompliance;
import org.hibernate.query.ImmutableEntityUpdateQueryHandlingMode;
import org.hibernate.query.criteria.ValueHandlingMode;
import org.hibernate.query.hql.HqlTranslator;
import org.hibernate.query.sqm.function.SqmFunctionDescriptor;
import org.hibernate.query.sqm.function.SqmFunctionRegistry;
import org.hibernate.query.sqm.mutation.spi.SqmMultiTableInsertStrategy;
import org.hibernate.query.sqm.mutation.spi.SqmMultiTableMutationStrategy;
import org.hibernate.query.sqm.sql.SqmTranslatorFactory;

/**
 * User configuration options related to the {@link QueryEngine}.
 *
 * @author Steve Ebersole
 */
public interface QueryEngineOptions {
	/**
	 * Translator for transforming HQL (as an Antlr parse tree) into an SQM tree.
	 *
	 * @see org.hibernate.query.hql
	 */
	HqlTranslator getCustomHqlTranslator();

	/**
	 * Factory for translators transforming an SQM tree into a different form.
	 * For standard ORM implementations this will generally be some form of SQL tree.
	 *
	 * @see org.hibernate.sql.ast.tree
	 */
	SqmTranslatorFactory getCustomSqmTranslatorFactory();

	/**
	 * User defined SQM functions available for use in HQL and Criteria.
	 * <p>
	 * Ultimately made available to the {@link SqmTranslatorFactory} for use
	 * in translating an SQM tree.
	 * <p>
	 * Can be used in conjunction with {@link #getCustomSqmFunctionRegistry()},
	 * but generally one or the other will be used.
	 */
	Map<String, SqmFunctionDescriptor> getCustomSqlFunctionMap();

	/**
	 * User supplied registry of SQM functions available for use in HQL and Criteria
	 * <p>
	 * Can be used in conjunction with {@link #getCustomSqlFunctionMap()}, but generally
	 * one or the other will be used.
	 */
	SqmFunctionRegistry getCustomSqmFunctionRegistry();

	/**
	 * Contract for handling SQM trees representing mutation (UPDATE or DELETE) queries
	 * where the target of the mutation is a multi-table entity.
	 */
	SqmMultiTableMutationStrategy getCustomSqmMultiTableMutationStrategy();

	/**
	 * Contract for handling SQM trees representing insertion (INSERT) queries where the
	 * target of the mutation is a multi-table entity.
	 */
	SqmMultiTableInsertStrategy getCustomSqmMultiTableInsertStrategy();

	JpaCompliance getJpaCompliance();

	ValueHandlingMode getCriteriaValueHandlingMode();

	default ImmutableEntityUpdateQueryHandlingMode getImmutableEntityUpdateQueryHandlingMode() {
		return ImmutableEntityUpdateQueryHandlingMode.WARNING;
	}

	/**
	 * @see org.hibernate.cfg.AvailableSettings#JSON_FUNCTIONS_ENABLED
	 */
	boolean isJsonFunctionsEnabled();

	/**
	 * @see org.hibernate.cfg.AvailableSettings#PORTABLE_INTEGER_DIVISION
	 */
	boolean isPortableIntegerDivisionEnabled();

	String getSessionFactoryName();

	String getUuid();
}
