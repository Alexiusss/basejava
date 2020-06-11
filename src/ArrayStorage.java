/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        storage = new Resume[10000];
    }

    void save(Resume r) {
        //TODO check if resume not present
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int count = 0;
        for (Resume r : storage) {
            if (r != null) {
                count++;
            }
        }
        Resume getall[] = new Resume[count];
        int count2 = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                getall[count2] = storage[i];
                count2++;
            }
        }
        return getall;
    }

    int size() {
        return size;
    }
}
