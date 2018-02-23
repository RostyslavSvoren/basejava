import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int count = 0;

    void clear() {
        Arrays.fill(storage, null);
        count = 0;
    }


    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (null == storage[i]) {
                storage[i] = r;
                count++;
                break;
            }
        }
    }


    Resume get(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (null != storage[i] && uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }


    void delete(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (null != storage[i] && uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                System.arraycopy(storage, i + 1, storage, i, storage.length - i - 1);
                count--;
                break;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, count);
    }


    int size() {
        return count;
    }
}
