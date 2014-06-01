package project.recovery;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import project.transaction.bean.Flight;
import project.transaction.bean.Reservation;

public class RedoReservation {
	
	private ConcurrentHashMap<String, HashSet<Reservation>> table;
	
	public RedoReservation(ConcurrentHashMap<String, HashSet<Reservation>> input){
		table = input;
	}
	
	public void insert(String key) {
		Flight value = new Flight(key,0,0,0);
		table.put(key, value);
	}

	public void delete(String key) {
		table.remove(key);
	}

	public void updatePrice(String key, int price) {
		Flight value = table.get(key);
		value.setPrice(price);
	}

	public void updateNumAvail(String key, int numAvail) {
		Flight value = table.get(key);
		value.setNumAvail(numAvail);
	}

	public void updateNumSeats(String key, int numSeats) {
		Flight value = table.get(key);
		value.setNumSeats(numSeats);
	}
	
}
