/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

/**
 *
 * @author Usuario
 */


public class Pairs<K, V> {
	
	public K key;
	V value;
	public Pairs<K, V> next;
	
	public Pairs(K key, V value, Pairs<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}

	// getters 
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public Pairs<K, V> getNext() {
		return next;
	}
	
	 @Override
     public boolean equals(Object obj) {
         if (obj == this) return true;

         if (obj instanceof Pairs) {
             Pairs pairs = (Pairs) obj;

             return key.equals(pairs.getKey()) &&
                     value.equals(pairs.getValue());
         }
         return false;
     }

     @Override
     public int hashCode() {
         int hash = 13;
         hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
         hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
         return hash;
     }

     @Override
     public String toString() {
         return "{" + key + ", " + value + "}";
     }
	
	

}

