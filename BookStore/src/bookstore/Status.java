package bookstore;

/**
 *
 * @author hasu
 */
public enum Status {
    Available("Available"),
    NOT_Available("NOT_Available");

    public static Status parseStatus(String value) {
        if (value != null) {
            try {
                return Status.valueOf(value.trim().replaceAll("\\s", "_").toUpperCase());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    private final String status;

    public String getStatus() {
        return status;
    }

    private Status(String label) {
        this.status = label;
    }
}
