/**
 * com.urise.webapp.model.Resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    String uuid;

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume o) {
        if (this.uuid == o.uuid)
            return 0;

        if (this.uuid == null) {
            return -1;
        }
        if (o.uuid == null) {
            return 1;
        }

        return this.uuid.compareTo(o.uuid);
    }
}
