package com.urise.webapp.storage.serializer;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.util.Collection;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {

    //TODO remove dublication code

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            Map<ContactType, String> contacts = r.getContacts();
            writeCollection(dos, contacts.entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt(); // Считываем стоп маркер
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }

            //TODO implement sections
//            while (dis.available() != -1) {
//                if (dis.readUTF().contains("StartTextSection")) {
//                    resume.addSection(SectionType.valueOf(dis.readUTF()), new TextSection(dis.readUTF()));
//                }
//                if (dis.readUTF().contains("StartListSection")) {
//                    String typeSection = dis.readUTF();
//                    List<String> list = new ArrayList<>();
//                    while (dis.readUTF() != "EndListSection") {
//                        list.add(dis.readUTF());
//                    }
//                    resume.addSection(SectionType.valueOf(typeSection), new ListSection(list));
//                }
//                if (dis.readUTF().contains("StartOrganizationSection")) {
//
//                    String typeSection = dis.readUTF();
//                    Link link = new Link(dis.readUTF(), dis.readUTF());
//                    while (dis.readUTF() != "EndListSection"){
//
//
//
//                    }
//
//                }
//            }
//
            return resume;
        }

    }

    private interface ElementWriter<T> {
        void write(T t) throws IOException;
    }

    private <T> void writeCollection(DataOutputStream dos, Collection<T> collection, ElementWriter<T> writer) throws IOException {
        dos.writeInt(collection.size());
        for (T item : collection) {
            writer.write(item);
        }

    }
}
