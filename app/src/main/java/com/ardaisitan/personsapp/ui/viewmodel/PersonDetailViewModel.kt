package com.ardaisitan.personsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ardaisitan.personsapp.data.repo.PersonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(val pRepo: PersonsRepository) : ViewModel() {

    //  val pRepo = PersonsRepository()  Bagimliliktir.Nesneyi disaridan isteyecegiz.

    fun update(id: Int, updatedName: String, updatedNumber: String) {
        CoroutineScope(Dispatchers.Main).launch {
            pRepo.update(id, updatedName, updatedNumber)
        }
    }


}