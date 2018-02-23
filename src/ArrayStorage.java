import java.util.Arrays;

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
        if(null == storage[count] && count < storage.length){
                storage[count] = r;
                count++;
        }
    }


    Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (null != storage[i] && uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }


    void delete(String uuid) {
        for (int i = 0; i < count; i++) {
            if (null != storage[i] && uuid.equals(storage[i].uuid)) {
                storage[i] = storage[count-1];
                storage[count-1] = null;
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
