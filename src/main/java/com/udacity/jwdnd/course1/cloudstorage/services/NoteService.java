package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    /**
     * Get note
     *
     * @return List Note
     */
    public List<Note> getNotes(int userid){
        return noteMapper.getNotes(userid);
    }

    /**
     * Create note
     *
     */
    public void addNote(Note note, int userId){
        Note newNote = new Note();
        newNote.setUserid(userId);
        newNote.setNotedescription(note.getNotedescription());
        newNote.setNotetitle(note.getNotetitle());

        noteMapper.insertNote(newNote);
    }

    /**
     * Update note
     *
     */
    public void updateNote(Note note) {
        noteMapper.updateNote(note);
    }

    /**
     * Delete note
     *
     * @return noteId
     */
    public void deleteNote(int noteid){
        noteMapper.deleteNote(noteid);
    }
}