package h2;

import java.util.ArrayList;

public class Bus {

    public ArrayList<Passenger> passengers;

    public Bus() {
        passengers = new ArrayList<Passenger>();
    }

    public void enterBus(Passenger p) {
        passengers.add(p);
    }

    private void exitBus() {
        int i = 0;
        while (i < passengers.size()) {
            Passenger p = passengers.get(i);
            if (p.visited == p.planned) {
                passengers.remove(i); 
            } else {
                i++;
            }
        }
    }
    
    public void nextStop(Passenger[] boarding) {

        for (int i = 0; i < passengers.size(); i++) {
            passengers.get(i).visited = passengers.get(i).visited + 1;
        }

        exitBus();

        for (int i = 0; i < boarding.length; i++) {
            enterBus(boarding[i]);
        }
    }

    public void nextStop() {
        Passenger[] boarding = new Passenger[0];
        nextStop(boarding);
    }

    public ArrayList<Passenger> findPassengersWithoutTickets() {

        ArrayList<Passenger> removed = new ArrayList<Passenger>();

        int i = 0;
        while (i < passengers.size()) {
            Passenger p = passengers.get(i);
            if (p.ticket == false) {
                removed.add(p);
                passengers.remove(i); 
            } else {
                i++;
            }
        }

        return removed;
    }

    public void transferPassengers(Bus otherBus, String[] passengerNames) {

        int i = 0;
        while (i < passengers.size()) {
            Passenger p = passengers.get(i);

            if (containsName(passengerNames, p.name)) {
                passengers.remove(i);
                otherBus.enterBus(p); 
            } else {
                i++;
            }
        }
    }

 
    private boolean containsName(String[] names, String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}