package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }


    public void save(Resume resume) {
        if (null == storage[count] && count < storage.length) {
            storage[count] = resume;
            count++;
        }
    }

    public void update(Resume resume) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                //Update method test
                resume.setUuid("testUuid");
                storage[i] = resume;
            }
        }
    }


    public Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }


    public void delete(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                count--;
                storage[i] = storage[count];
                storage[count] = null;
                break;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, count);
    }


    public int size() {
        return count;
    }
}
