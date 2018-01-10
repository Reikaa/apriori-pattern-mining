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

import com.google.common.collect.Sets;

/**
 * add class description
 * 
 * @author Julio Pineda created on 2017-12-24
 * @param <E>
 * 
 */
public class AprioriPatternMining<E> {
	private int minSupport;
	private Collection<Transaction<E>> transactions;
	
	private Set<Itemset<E>> frequentItemsets;
	
	/**
	 * Empty class constructor
	 */
	public AprioriPatternMining() {
	}
	
	public AprioriPatternMining(int minSupport, Collection<Transaction<E>> transactions) {
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
	
	public void mineFrequentItemsets() {
		/**
		 * TODO steps to take
		 * 1) Scan database to calculate support of all itemsets of size 1.
		 * 2) Store itemsets that are >= minSupport.
		 * 3) Start building candidate itemsets of size k. Create method to build candidate itemsets.
		 * 4) For each itemset of size k, if itemset contains an item that is not in itemsets of size k-1 then remove itemset.
		 * 5) For each itemset of size k, remove any itemset with support < minSupport
		 * 6) Store frequent itemsets.
		 * 7) End when there is no more candidate itemsets.
		 * 
		 */
		
		Set<Itemset<E>> singleItemsets = findSingleItemsets();
		determineSupport(singleItemsets);
	}
	
	/**
	 * TODO add proper description
	 * - Need to compare each itemset to each other
	 * - Take the intersection of pair of itemsets
	 *     - If intersection has size 1, take the union of the pair and store in candidate results
	 *     - If not, ignore
	 * - Return candidate
	 * - The input itemsets need to have the same size.
	 * 
	 * @param itemsets
	 * @return
	 */
	private Set<Itemset<E>> generateCandiateItemsets(Set<Itemset<E>> itemsets) {
		
		Set<String> a = new HashSet<>();
		
		Sets.intersection(a, itemsets);
		
		return null;
	}
	
	private void determineSupport(Set<Itemset<E>> itemsets) {
		for (Transaction<E> transaction : this.transactions) {
			
		}
	}
	
	private Set<Itemset<E>> findSingleItemsets() {
		Set<Itemset<E>> singleItemsets = new HashSet<>();
		
		for (Transaction<E> transaction : this.transactions) {
			Set<E> items = transaction.getItems();
			
			for (E item : items) {
				Set<E> setOneItem = new HashSet<>();
				setOneItem.add(item);
				
				Itemset<E> singleItemset = new Itemset<>();
				singleItemset.setItems(setOneItem);
				
				singleItemsets.add(singleItemset);
			}
		}
		
		return singleItemsets;
	}
	
	/**
	 * Reads the transaction database file and stores the transactions in a list. This method automatically assigns
	 * an arbitrary transaction id per transaction.
	 * 
	 * The items/symbols in the transaction are space separated.
	 */
	private void processTransactionFile(String transactionDatabaseFile) {
		List<Transaction<E>> transactions = new ArrayList<>();
		
		try {
			// set up buffered reader to read text file
			BufferedReader reader = new BufferedReader(new FileReader(new File(transactionDatabaseFile)));
			
			String line;
			int id = 0;
			while ((line = reader.readLine()) != null) {
				Transaction<E> transaction = new Transaction<>();
				
				// set id and increment
				transaction.setId(id);
				id++;
				
				// parse text file and store items into a set
				Set<String> symbols = new HashSet<>();
				String[] symbolsArray = line.split(" ");
				for (int i = 0; i < symbolsArray.length; i++) {
					symbols.add(symbolsArray[i]);
				}
				// transaction.setSymbols(symbols);
				
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