/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        if (r != null) {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] == null || storage[i] == r) {
                    storage[i] = r;
                    break;
                }
            }
        }
    }

    Resume get(String uuid) {
        if (uuid != null) {
            for (Resume resume : storage) {
                if (resume != null && uuid.equals(resume.uuid)) {
                    return resume;
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (uuid != null) {
            int index = 0;
            while (index < storage.length) {
                if (uuid.equals(storage[index].uuid)) {
                    break;
                }
                index++;
            }
            int numMoved = this.size() - index - 1;
            if (numMoved > 0) {
                System.arraycopy(storage, index + 1, storage, index,
                        numMoved);
            }
            storage[this.size() - 1] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResumes = new Resume[this.size()];
        System.arraycopy(storage, 0, allResumes, 0,
                this.size());
        return allResumes;
    }

    int size() {
        int realSize = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                realSize++;
            }
        }
        return realSize;
    }
}