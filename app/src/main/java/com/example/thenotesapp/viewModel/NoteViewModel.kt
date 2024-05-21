// NoteViewModel.kt
package com.example.thenotesapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.thenotesapp.model.Note
import com.example.thenotesapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(application: Application, private val noteRepository: NoteRepository) : AndroidViewModel(application) {

    val allNotes: LiveData<List<Note>> = noteRepository.getAllNotes()

    fun addNote(note: Note) =
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }

    fun updateNote(note: Note) =
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }

    fun deleteNote(note: Note) =
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }

    fun searchNote(query: String): LiveData<List<Note>> {
        return noteRepository.searchNote(query)
    }
}
