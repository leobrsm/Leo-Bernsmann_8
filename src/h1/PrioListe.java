package h1;

import java.util.ArrayList;

public class PrioListe {

	   
	    public ArrayList<Patient> myList;

	    public PrioListe() {
	        myList = new ArrayList<Patient>();
	    }

	    public void addPatient(Patient p) {

	        if (myList.size() == 0) {
	            myList.add(p);
	            return;
	        }

	        int index = 0;
	        while (index < myList.size() && myList.get(index).prio < p.prio) {
	            index++;
	        }
	        
	        myList.add(index, p);
	    }

	    public Patient getNextPatient() {
	        if (myList.size() == 0) {
	            return null; 
	        }
	        Patient first = myList.get(0);
	        myList.remove(0);
	        return first;
	    }

	    public int getPosition(Patient p) {
	        for (int i = 0; i < myList.size(); i++) {
	            if (myList.get(i) == p) { 
	                return i;
	            }
	        }
	        return -1;
	    }
}


