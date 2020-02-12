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
        public DinamicArray<Pairs<K, V>> elements;
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
                            Pairs<K,V> heye = old.get(i);
                            while(old.get(i) != null) {
                                    put(heye.key, heye.value);
                                    //ob = ob.next;

                                     heye = heye.next;
                            }
			}
		}
		
		Pairs<K, V> pairs = new Pairs<> (key, value, null);
		
		int element = getHash(key) % getElementSize();
                Pairs<K,V> heye = elements.get(element);
                if(heye==null){
                    heye = pairs;
                    return;
                }
                
                while(heye.next!= null){
                    heye = heye.next;
                }
                heye.next = pairs;
                
	}
	
    private int getElementSize() {
    return elements.size();
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }
    
    public V get(K key){
        V valee = null;
        int element = getHash(key) % getElementSize();
        Pairs<K,V> asd = elements.get(element);
        while(asd.next!= null){
            if(asd.getKey().equals(key)){
                valee = asd.getValue();
                break;
            }
        }
        
        return valee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < elements.size(); i++){
        
            sb.append("[");
            Pairs<K,V> heye  = elements.get(i);
            while (heye != null) {
                sb.append(heye);
                if (heye.next != null) {
                    sb.append(", ");
                }
                heye = heye.next;
            }
            sb.append("]");
        }
        return "{" + sb.toString() + "}";
    }

    public int size() {
        return size;
    }
}
	

	