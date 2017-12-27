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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		processTransactionFile(transactionDatabaseFile);
	}
	
	/**
	 * Reads the transaction database file and stores the transactions in a list. This method automatically assigns
	 * an arbitrary transaction id per transaction.
	 * 
	 * The items/symbols in the transaction are space separated.
	 */
	private void processTransactionFile(String transactionDatabaseFile) {
		List<Transaction> transactions = new ArrayList<>();
		
		try {
			// set up buffered reader to read text file
			BufferedReader reader = new BufferedReader(new FileReader(new File(transactionDatabaseFile)));
			
			String line;
			int id = 0;
			while ((line = reader.readLine()) != null) {
				Transaction transaction = new Transaction();
				
				// set id and increment
				transaction.setId(id);
				id++;
				
				// parse text file and store items into a set
				Set<String> symbols = new HashSet<>();
				String[] symbolsArray = line.split(" ");
				for (int i = 0; i < symbolsArray.length; i++) {
					symbols.add(symbolsArray[i]);
				}
				transaction.setSymbols(symbols);
				
				// add transaction to list
				transactions.add(transaction);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.transactions = transactions;
	}
	
}
