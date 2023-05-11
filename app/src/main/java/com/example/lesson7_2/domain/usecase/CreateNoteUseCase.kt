package com.example.lesson7_2.domain.usecase

import com.example.lesson7_2.domain.models.Note
import com.example.lesson7_2.domain.repository.NoteRepository

class CreateNoteUseCase(private val repository: NoteRepository) {

    fun create(note: Note) = repository.createNote(note)
}