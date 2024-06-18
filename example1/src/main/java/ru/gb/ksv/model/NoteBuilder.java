package ru.gb.ksv.model;

import java.util.HashMap;
import java.util.Map;

public class NoteBuilder {
    Map<String, String> deskMap = new HashMap<String, String>();


    public NoteBuilder setHeader(String header) {
        deskMap.put("header", header);
        return this;
    }

    public NoteBuilder setContent(String content) {
        deskMap.put("content", content);
        return this;
    }

    public Note build() {
        Note note = new Note();
        note.setHeader(deskMap.get("header"));
        note.setContent(deskMap.get("content"));
        return note;
    }

}
