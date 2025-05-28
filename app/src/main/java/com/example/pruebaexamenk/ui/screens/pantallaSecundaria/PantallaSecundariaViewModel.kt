package com.example.pruebaexamenk.ui.screens.pantallaSecundaria

import androidx.lifecycle.ViewModel
import com.example.pruebaexamenk.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PantallaSecundariaViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

}
