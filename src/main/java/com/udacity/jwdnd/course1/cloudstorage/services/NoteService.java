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
     * @return Note
     */
    public Note getNote(Integer noteId) {
        return noteMapper.getNote(noteId);
    }

    /**
     * Get note
     *
     * @return List Note display table
     */
    public List<Note> getNotes(Integer userId) {
        return noteMapper.getNotes(userId);
    }

    /**
     * Create note
     *
     * @return noteId
     */
    public Integer create(Note note) {
        return noteMapper.createNote(note);
    }

    /**
     * Update note
     *
     * @return noteId
     */
    public Integer update(Note note) {
        return noteMapper.update(note);
    }

    /**
     * delete note
     *
     */
    public void delete(Integer noteId) {
        noteMapper.delete(noteId);
    }
}
