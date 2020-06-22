package com.urise.webapp.storage;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }
//    @Test(expected = StorageException.class)
//    public void saveOverFlow() {
//        try {
//            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
//                storage.save(new Resume("Name1" + i));
//            }
//        } catch (StorageException e) {
//            Assert.fail();
//        }
//        storage.save(new Resume("Overflow"));
//    }

}