package com.ardaisitan.personsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ardaisitan.personsapp.data.entity.Kisiler
import com.ardaisitan.personsapp.data.repo.PersonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class MainPageViewModel @Inject constructor(val pRepo: PersonsRepository) : ViewModel() {

    //val pRepo = PersonsRepository() Bagimliliktir.Nesneyi disaridan isteyecegiz.
    var personList =
        MutableLiveData<List<Kisiler>>() //Liste iceren,icerisinde kisiler nesnesi olan bir yapıdır.

    init {
        loadPersons()   // Bu classtan nesne olusturuldugunda ilk calisacak bloktur.
        // Bu sebeple kisileri sayfa ilk acildiginda yuklemek icin init bloguna yazdik.
    }

    fun delete(personid: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            pRepo.delete(personid)
            loadPersons()//Silme islemini yaptiktan sonra anasayfaya guncel verileri yuklememizi saglar.
        }
    }

    fun loadPersons() {
        CoroutineScope(Dispatchers.Main).launch {
            try { // Hiç veri gelmemesi durumda uygulamanin cokmemesini saglar.
                personList.value =
                    pRepo.loadPersons() // Bu bir liste getirdigi icin bu listeyi liveData ile anasayfada gostermem gerekir.
                // Disaridan bana gonderilen listeyi .value diyerek aktariyorum.

            } catch (_: Exception) {
            }

        }

    }

    fun search(kisi_ad: String) {

        CoroutineScope(Dispatchers.Main).launch {
            try { // Arama sonucunda bos bi sonuc gelmesi durumunda onlem aliriz.
                    personList.value =
                    pRepo.search(kisi_ad) // Su anlik sadece icerisinde 1 kisi olan bir liste doner.

            } catch (_: Exception){}

        }
    }


}