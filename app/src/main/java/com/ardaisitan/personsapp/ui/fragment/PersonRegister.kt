package com.ardaisitan.personsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ardaisitan.personsapp.R
import com.ardaisitan.personsapp.databinding.FragmentPersonRegisterBinding
import com.ardaisitan.personsapp.ui.viewmodel.PersonRegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Burada aktarim tek yonlu olacaktir.
 * Burda sayfama data sourceden bir veri aktarimi gerceklesmedigi icin viewmodelde liveData kullanmamiza gerek yoktur
 * Sadece kayit islemi vardir.
 */
@AndroidEntryPoint
class PersonRegister : Fragment() {
    private lateinit var binding: FragmentPersonRegisterBinding
    private val viewModel: PersonRegisterViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_person__register,
            container,
            false
        )

        binding.personRegisterObject = this //Yetkilendirmis olduk.
        binding.personRegisterToolbarTitle = "Person Register"

        return binding.root
    }

    fun buttonSave(personName: String, personNumber: String) {
        viewModel.save(personName, personNumber)
    }

}
