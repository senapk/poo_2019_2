package s14e02_observer;

import java.util.ArrayList;

public class Historico<V> implements Observer<V>{
	ArrayList<V> entradas;
	public Historico(Repository<Integer, V> rep) {
		entradas = new ArrayList<V>();
		rep.attach(this);
	}
	
	public void update(EventType type, V value) {
		if(type == EventType.add)
			entradas.add(value);
	}
	
	@Override
	public String toString() {
		return "" + entradas;
	}
}
