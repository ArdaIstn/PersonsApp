package com.ardaisitan.personsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ardaisitan.personsapp.R
import com.ardaisitan.personsapp.databinding.FragmentPersonDetailBinding
import com.ardaisitan.personsapp.ui.viewmodel.PersonDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Register kısmında oldugu gibi burada da tek yonlu islem gerceklestirilir.
 * Yani geriye bir donus olmaz.
 * Bu durumda viewmodelde liveData kullanmamiza gerek yoktur.
 */

@AndroidEntryPoint
class PersonDetail : Fragment() {
    private lateinit var binding: FragmentPersonDetailBinding
    private val viewModel: PersonDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /**
         * DataBinding'e cevirirken toolbar basligini,gelen nesne icin person nesnesini ve butona tıklanılma olayları için onclick olusturduk.
         */

        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_person__detail,
            container,
            false
        )

        binding.personDetailToolbarTitle = "Person Detail"
        binding.personDetailObject = this

        val bundle: PersonDetailArgs by navArgs()
        val getPerson = bundle.person // Nesneyi gondermistik,bu sekilde gonderilen nesneyi aliriz.

        binding.personClassObjectt = getPerson // Data bindingle kullandik.Gelen nesneyi xml tarafindaki nesneye atadik.


        return binding.root
    }

    fun buttonUpdate(id: Int, updatedName: String, updatedNumber: String) {
        viewModel.update(id, updatedName, updatedNumber)
    }


}