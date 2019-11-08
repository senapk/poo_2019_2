package s14e02_observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

enum EventType{
	add, rm;
}

interface Observer<V>{
	public void update(EventType type, V value);
}

class Repository<K, V>{
	String typename;
	Map<K, V> data = new TreeMap<K, V>();
	List<Observer<V>> observers;
	public Repository(String typename) {
		this.typename = typename;
		this.observers = new ArrayList<Observer<V>>();
	}
	public void attach(Observer<V> observer) {
		this.observers.add(observer);
	}
	
	boolean exists(K k) {
		return this.data.get(k) != null;
	}
	
	void add(K k, V v) {
		V value = this.data.get(k);
		if(value != null)
			throw new RuntimeException(this.typename + " " + k + " ja existe");
		this.data.put(k, v);
		notity(EventType.add, v);
	}
	
	private void notity(EventType type, V v) {
		for(Observer<V> observer : observers)
			observer.update(type, v);
		
	}
	
	V get(K k) {
		V value = this.data.get(k);
		if(value == null)
			throw new RuntimeException(this.typename + " " + k + " nao existe");
		return value;
	}
	
	V remove(K k) {
		V value = this.data.remove(k);
		if(value == null)
			throw new RuntimeException(this.typename + " " + k + " nao existe");
		return value;
	}
	Collection<V> getAll(){
		return this.data.values();
	}
	public String toString() {
		String saida = "[ ";
		for(K key : this.data.keySet())
			saida += key + " ";
		return saida + "]";
	}
}







