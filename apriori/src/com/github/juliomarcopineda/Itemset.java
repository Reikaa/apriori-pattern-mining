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

import java.util.Set;

/**
 * Wrapper class for a single itemset object for pattern mining
 * 
 * @author Julio Pineda created on 2017-12-26
 * 
 */
public class Itemset<E> {
	private Set<E> items;
	private int size;
	private int support;
	
	public int getSupport() {
		return support;
	}
	
	public void setSupport(int support) {
		this.support = support;
	}
	
	public Set<E> getItems() {
		return items;
	}
	
	public void setItems(Set<E> items) {
		this.items = items;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Itemset other = (Itemset) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		}
		else if (!items.equals(other.items))
			return false;
		return true;
	}
}
