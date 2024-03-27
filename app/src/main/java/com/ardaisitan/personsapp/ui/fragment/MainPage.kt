package com.ardaisitan.personsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.ardaisitan.personsapp.R
import com.ardaisitan.personsapp.databinding.FragmentMainPageBinding
import com.ardaisitan.personsapp.ui.adapter.PersonAdapter
import com.ardaisitan.personsapp.ui.viewmodel.MainPageViewModel
import com.ardaisitan.personsapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

/**
 *  Anasayfada kisileri yuklerken ve arama yaparken iki yonlu calisiriz,arayuze veri getirmemiz gerekir.
 *  Burda liveData ve coroutine kullanarak geri donuslu fonksiyonlar olustururuz.
 *  Arama isleminde de data sourceye gidip verileri alıp bize geri dondurecektir.
 */
@AndroidEntryPoint
class MainPage : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private val viewModel: MainPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main__page, container, false)
        /**
         * Databinding icin title icin string bir degisken,fabButton icin bir onClick,adapter nesnesini olusturduk.
         */

        binding.mainPageObject = this
        binding.mainPageToolbarTitle = "Main Page"

        viewModel.personList.observe(viewLifecycleOwner) {
            val personAdapter = PersonAdapter(it, viewModel)
            binding.personsAdapter = personAdapter // RecycleView'a adapteri atadik.
            // Bu sayede RecyclerView'da görüntülenecek verileri sağladik ve görünümün tasarımı ile bu verilerin nasıl ilişkilendirileceğini ayarladik.
            // RecycleView verileri goruntuler,adapter ise bilgileri duzenler.
        }


        // binding.recycleView.layoutManager = Data binding icin artik bu kullanima gerek kalmaz.
        // LinearLayoutManager(requireContext())// RecycleView icindeki ogeler  nasıl gozukecek onu belirler.
        // Alt alta bir gorunum elde ederiz.

        //binding.recycleView.layoutManager = GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)


        // binding.recycleView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        // spanCount : Sutun sayisini belirler
        // Vertical :  Dikey yonde scroll yapabilmemi saglar.
        // Horizontal: Yatat yonde scroll yapabilmemi saglar.


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean { // Arama sorgusu her degistiginde tetiklenir.Arama sorgusu degistiginde yapilacak islemleri icerir.
                viewModel.search(newText)

                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean { // Kullanici arama sorgusunu gonderdiginde tetiklenir.Arama sorgusu gonderildiginde yapılacak islemleri icerir.

                viewModel.search(query)

                return true
            }


        })

        return binding.root
    }

    fun clickFab(it: View) { // it icin view nesnesini disaridan veriyoruz.
        Navigation.gecisYap(it, R.id.mainToRegisterPage)
    }

    override fun onResume() {
        super.onResume() // Diger sayfalardan geri dondugum zaman calisan fonksiyondur.
        viewModel.loadPersons() // Bu sayede  guncelleme veya kayit islemlerini yapip anasayfaya geri dondugum zaman veriler guncel olarak anasayfada gozukur.
    }


}


