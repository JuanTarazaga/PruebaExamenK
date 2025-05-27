package com.example.pruebaexamenk.ui.screens.pantallaInicial

import androidx.lifecycle.ViewModel
import com.example.pruebaexamenk.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PantallaInicialViewModel @Inject constructor (
    private val Reposoitory: Repository
) : ViewModel() {

}