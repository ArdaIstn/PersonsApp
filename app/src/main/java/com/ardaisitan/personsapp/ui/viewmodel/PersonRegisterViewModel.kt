package com.ardaisitan.personsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ardaisitan.personsapp.data.repo.PersonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonRegisterViewModel @Inject constructor(val pRepo: PersonsRepository) : ViewModel() {

    // var pRepo = PersonsRepository()  Bagimliliktir.Nesneyi disaridan isteyecegiz.

    fun save(personName: String, personNumber: String) {
        CoroutineScope(Dispatchers.Main).launch {
            pRepo.save(personName, personNumber)
        }
    }
}