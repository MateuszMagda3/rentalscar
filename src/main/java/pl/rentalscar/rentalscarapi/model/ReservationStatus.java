package pl.rentalscar.rentalscarapi.model;

public enum ReservationStatus {
    SUBMITTED("submitted"),
    CONFIRMED("confirmed"),
    IN_PROGRESS("in progress"),
    COMPLETED("completed");

    private final String description;

    ReservationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
