package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeleteElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    @Override
    protected void insertElement(Resume r, int index) {
        // http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        //arrayCopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx); // - My attempt to inmplement a method.
        storage[insertIdx] = r;
    }

    @Override
    protected int getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
       return Arrays.binarySearch(storage, 0, size, searchKey);
    }

//    public void arrayCopy(Object [] src, int srcPos, Object [] dest, int destPos, int lenth){
//
//
//        for (int i = 0; i < lenth; i++){
//            dest[destPos] = src[srcPos];
//            destPos++;
//            srcPos++;
//        }
//
//    }


}
