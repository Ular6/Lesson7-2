package com.example.lesson7_2.data.repository

import com.example.lesson7_2.data.local.NoteDao
import com.example.lesson7_2.data.mappers.toNote
import com.example.lesson7_2.data.mappers.toNoteEntity
import com.example.lesson7_2.domain.models.Note
import com.example.lesson7_2.domain.repository.NoteRepository
import com.example.lesson7_2.domain.utils.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun getAllNotes() = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.getAllNotes().map {
                it.toNote()
            }
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.localizedMessage ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun deleteNote(note: Note) = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.delete(note.toNoteEntity())
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.localizedMessage ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun createNote(note: Note) = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.create(note.toNoteEntity())
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.localizedMessage ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun updateNote(note: Note) = flow{
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.update(note.toNoteEntity())
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.localizedMessage ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)
}