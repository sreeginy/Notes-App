package com.example.thenotesapp.viewModel

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.thenotesapp.repository.NoteRepository

class NoteViewModelFactory(val app: Application, private val noteRespository: NoteRepository) : ViewModelProvider.{
}