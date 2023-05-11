package com.example.lesson7_2.domain.usecase

import com.example.lesson7_2.domain.models.Note
import com.example.lesson7_2.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {

    fun delete(note: Note) = repository.deleteNote(note)
}