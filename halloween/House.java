package halloween;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class House {

    private List<Kid> data;
    private int capacity;

    public House(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void addKid(Kid kid) {

        if (this.data.size() < this.capacity) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {

        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public Kid getKid(String street) {

        return this.data.stream().filter(e -> e.getStreet().equals(street)).findFirst().orElse(null);
    }

    public int getAllKids() {

        return this.data.size();
    }

    public String getStatistics() {

        StringJoiner sj = new StringJoiner("\n");
        sj.add("Children who visited a house for candy:");
        for (Kid kid : data) {
            sj.add(String.format("%s from %s street", kid.getName(), kid.getStreet()));
        }
        return sj.toString();
    }


}
