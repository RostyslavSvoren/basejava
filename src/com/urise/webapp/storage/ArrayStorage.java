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
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            if (count < storage.length) {
                storage[count] = resume;
                count++;
            } else {
                System.out.println("The resume is not saved, the archive is full!");
            }
        } else {
            System.out.println("The archive already contains this resume!");
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

    private  int getIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
