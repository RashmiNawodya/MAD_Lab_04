package com.example.todo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.Note
import com.example.todo.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel (app: Application, private val noteteRepository: NoteRepository): AndroidViewModel(app){

    fun addNote(note: Note) =
        viewModelScope.launch {
            noteteRepository.insertNote(note)
        }

    fun deleteNote(note: Note) =
        viewModelScope.launch {
            noteteRepository.deleteNote(note)
        }

    fun updateNote(note: Note) =
        viewModelScope.launch {
            noteteRepository.updateNote(note)
        }

    fun getAllNotes() = noteteRepository.getAllNotes()

    fun searchNote(query: String?) =
        noteteRepository.searchNote(query)
}