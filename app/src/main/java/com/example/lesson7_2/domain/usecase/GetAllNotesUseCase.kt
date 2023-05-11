package com.example.lesson7_2.domain.usecase

import com.example.lesson7_2.domain.repository.NoteRepository

class GetAllNotesUseCase(private val repository: NoteRepository) {

    fun getAllNotes() = repository.getAllNotes()
}