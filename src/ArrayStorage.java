/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (r != null) {
            int i = -1;
            while (i < size) {
                if (storage[++i] == null || r.equals(storage[i])) {
                    storage[i] = r;
                    size++;
                    break;
                }
            }
        }
    }

    Resume get(String uuid) {
        if (uuid != null) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (uuid != null) {
            int index = 0;
            while (index < size) {
                if (uuid.equals(storage[index].uuid)) {
                    break;
                }
                index++;
            }
            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(storage, index + 1, storage, index, numMoved);
            }
            storage[--size] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResumes = new Resume[size];
        System.arraycopy(storage, 0, allResumes, 0, size);
        return allResumes;
    }

    int size() {
        return size;
    }
}