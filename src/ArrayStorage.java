import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }


    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (null == storage[i]) {
                storage[i] = r;
                break;
            }
        }
    }


    Resume get(String uuid) {

        Resume r = null;
        for (int i = 0; i < storage.length; i++) {
            if (null != storage[i] && uuid.equals(storage[i].uuid)) {
                r = storage[i];
                break;
            }
        }

        return r;
    }


    void delete(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (null != storage[i] && uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                System.arraycopy(storage, i + 1, storage, i, storage.length - i - 1);
                break;
            }
        }

        //        Arrays.sort(storage, new Comparator<Resume>() {
//
//            @Override
//            public int compare(Resume o1, Resume o2) {
//                if (o1 == o2)
//                    return 0;
//
//                if (o1 == null) {
//                    return 1;
//                }
//                if (o2 == null) {
//                    return -1;
//                }
//
//                return o1.compareTo(o2);
//
//            }
//        });

    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

//        int count = size();
//
//        Resume[] r = new Resume[count];
//
//        int j = 0;
//
//        for (int i = 0; i < storage.length; i++) {
//            if (null != storage[i] && j < r.length) {
//                r[j] = storage[i];
//                j++;
//            } else {
//                break;
//            }
//        }
//
//        return r;

        return  Arrays.copyOfRange(storage, 0, size());
    }


    int size() {

        int count = 0;

        for (int i = 0; i < storage.length; i++) {
            if (null != storage[i]) count++;
            else break;
        }
        return count;
    }
}
