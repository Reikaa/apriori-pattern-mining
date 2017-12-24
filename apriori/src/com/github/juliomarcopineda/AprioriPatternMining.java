/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.juliomarcopineda;

import java.util.Collection;

/**
 * add class description
 * 
 * @author Julio Pineda created on 2017-12-24
 * 
 */
public class AprioriPatternMining {
	private int minSupport;
	private Collection<Transaction> transactions;
	
	/**
	 * Empty class constructor
	 */
	public AprioriPatternMining() {
	}
	
	public AprioriPatternMining(int minSupport, Collection<Transaction> transactions) {
		this.minSupport = minSupport;
		this.transactions = transactions;
	}
	
	/**
	 * Constructor that accepts minimum support and the file name for the transaction database.
	 * 
	 * @param minSupport
	 * @param transactionDatabaseFile
	 */
	public AprioriPatternMining(int minSupport, String transactionDatabaseFile) {
		this.minSupport = minSupport;
		
		//TODO process transaction database file
	}
}
