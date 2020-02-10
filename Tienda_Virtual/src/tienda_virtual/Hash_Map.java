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
public class Hash_Map <K, V> {
	
	//private Pairs<K, V>[] elements;
        private DinamicArray<Pairs<K, V>> elements;
	private int capacity;
	private int size = 0;
	private double lf = 0.80;
	
	
	public Hash_Map() {
		this (1000);
	}
	
	public Hash_Map(int capacity) {
		this.capacity = capacity;
		//this.elements = new Pairs[this.capacity];
                this.elements = new DinamicArray<>();
        }
	
	public void put(K key, V value) {
		
		if (size == (lf*capacity)) {
			//Pairs<K, V>[] old = elements;
                        DinamicArray<Pairs<K,V>> old = elements;
			capacity *=2;
			size = 0;
			//elements = new Pairs[capacity];
			elements = new DinamicArray<>();
                        for(int i = 0; i < old.size(); i++){
				while(old.get(i) != null) {
					put(old.get(i).key, old.get(i).value);
					//ob = ob.next;
                                        old.get(i).next = old.get(i);
				}
			}
		}
		
		Pairs<K, V> pairs = new Pairs<> (key, value, null);
		
		int element = getHash(key) % getElementSize();
	}
	
	private int getElementSize() {
        return elements.size();
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < elements.size(); i++){
        
            sb.append("[");
            
            while (elements.get(i) != null) {
                sb.append(elements.get(i));
                if (elements.get(i).next != null) {
                    sb.append(", ");
                }
                elements.get(i).next = elements.get(i);
            }
            sb.append("]");
        }
        return "{" + sb.toString() + "}";
    }

    public int size() {
        return size;
    }
}
	

	