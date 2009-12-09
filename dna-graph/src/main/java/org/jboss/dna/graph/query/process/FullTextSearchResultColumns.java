/*
 * JBoss DNA (http://www.jboss.org/dna)
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * See the AUTHORS.txt file in the distribution for a full listing of 
 * individual contributors.
 *
 * JBoss DNA is free software. Unless otherwise indicated, all code in JBoss DNA
 * is licensed to you under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * JBoss DNA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.dna.graph.query.process;

import java.util.List;
import org.jboss.dna.common.util.CheckArg;
import org.jboss.dna.graph.Location;
import org.jboss.dna.graph.query.model.Column;

/**
 * A specialization of {@link QueryResultColumns} that can be used to represent results containing only the {@link Location} of
 * the node and the
 */
public class FullTextSearchResultColumns extends QueryResultColumns {

    private static final long serialVersionUID = 1L;

    public static final QueryResultColumns INSTANCE = new FullTextSearchResultColumns();

    /**
     * Create a new definition for the query results containing just the locations and the full-text search scores.
     */
    public FullTextSearchResultColumns() {
        super(true, NO_COLUMNS);
    }

    /**
     * Create a new definition for the query results given the supplied columns.
     * 
     * @param columns the columns that define the results; should never be modified directly
     */
    public FullTextSearchResultColumns( List<Column> columns ) {
        super(true, columns != null ? columns : NO_COLUMNS);
        CheckArg.isNotEmpty(columns, "columns");
    }

    /**
     * Get the index of a tuple's correct Location object.
     * 
     * @return the Location index that corresponds to the supplied column; never negative
     */
    public int getLocationIndex() {
        return getLocationIndex(DEFAULT_SELECTOR_NAME);
    }

    /**
     * Get the index of the tuple value containing the full-text search score for the node.
     * 
     * @return the index that corresponds to the {@link Double} full-text search score, or -1 if there is no full-text search
     *         score for the named selector
     */
    public int getFullTextSearchScoreIndex() {
        return getFullTextSearchScoreIndexFor(DEFAULT_SELECTOR_NAME);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.jboss.dna.graph.query.process.QueryResultColumns#hasFullTextSearchScores()
     */
    @Override
    public boolean hasFullTextSearchScores() {
        return true;
    }
}
