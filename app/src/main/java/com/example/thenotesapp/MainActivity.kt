package com.example.thenotesapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notesroompractice.R
import com.example.thenotesapp.database.NoteDatabase
import com.example.thenotesapp.repository.NoteRepository
import com.example.thenotesapp.viewModel.NoteViewModel
import com.example.thenotesapp.viewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {


    lateinit var noteViewModel: NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setupViewModel()
        }

    private fun setupViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
    }
