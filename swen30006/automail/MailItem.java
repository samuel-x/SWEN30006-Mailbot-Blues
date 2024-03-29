package automail;

import java.util.Map;
import java.util.TreeMap;

/** Represents a mail item. */
public class MailItem {
    // Provided code from LMS to ensure consistent hash codes.
    private static int count = 0;
    private static Map<Integer, Integer> hashMap = new TreeMap<>();

    /** Represents the destination floor to which the mail is intended to go */
    private final int destinationFloor;
    /** The mail identifier */
    private final String id;
    /** The time the mail item arrived */
    private final int arrivalTime;
    /** The weight in grams of the mail item */
    private final int weight;
    /** The priority level of the mail item */
    private final int priorityLevel;

    /**
     * Constructor for a MailItem
     * @param destinationFloor the destination floor intended for this mail item
     * @param arrivalTime the time that the mail arrived
     * @param weight the weight of this mail item
     */
    public MailItem(int destinationFloor, int arrivalTime, int weight, int priorityLevel) {
        this.destinationFloor = destinationFloor;
        this.id = String.valueOf(hashCode());
        this.arrivalTime = arrivalTime;
        this.weight = weight;
        this.priorityLevel = priorityLevel;
    }

    @Override
    public String toString() {
        String output = String.format("Mail Item:: ID: %11s | Arrival: %4d | Destination: %2d | Weight: %4d",
                this.id, this.arrivalTime, this.destinationFloor, this.weight);

        if (this.hasPriority()) {
            output += String.format(" | Priority: %3d", this.getPriorityLevel());
        }

        return output;
    }

    /**
     * @return the destination floor of the mail item
     */
    public int getDestFloor() {
        return this.destinationFloor;
    }
    
    /**
     * @return the ID of the mail item
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return the arrival time of the mail item
     */
    public int getArrivalTime() {
        return this.arrivalTime;
    }

    /**
    * @return the weight of the mail item
    */
    public int getWeight() {
        return this.weight;
    }

    public int getPriorityLevel() {
        return this.priorityLevel;
    }

    public boolean hasPriority() {
        return this.getPriorityLevel() > 0;
    }

    // Provided code from LMS to ensure consistent hash codes.
    @Override
    public int hashCode() {
        Integer hash0 = super.hashCode();
        Integer hash = hashMap.get(hash0);
        if (hash == null) {
            hash = count++; hashMap.put(hash0, hash);
        }
        return hash;
    }
}
