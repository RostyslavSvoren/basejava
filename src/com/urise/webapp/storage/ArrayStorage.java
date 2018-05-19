package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage{
    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }


    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("The archive already contains this resume!");
        } else if (count >= storage.length) {
            System.out.println("The resume is not saved, the archive is full!");
        } else {
            storage[count] = resume;
            count++;
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("This resume is not in the archive!");
        }
    }


    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("This resume is not in the archive!");
        return null;
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            count--;
            storage[index] = storage[count];
            storage[count] = null;
        } else {
            System.out.println("This resume is not in the archive!");
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }


    public int size() {
        return count;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
