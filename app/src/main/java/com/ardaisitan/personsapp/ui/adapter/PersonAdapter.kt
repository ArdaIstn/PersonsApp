package com.ardaisitan.personsapp.ui.adapter

/**
 * Silme kısmı tek yonlu calisir.Herhangi donen veri olmaz.
 */

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ardaisitan.personsapp.R
import com.ardaisitan.personsapp.data.entity.Kisiler

import com.ardaisitan.personsapp.databinding.CardTasarimBinding
import com.ardaisitan.personsapp.ui.fragment.MainPageDirections
import com.ardaisitan.personsapp.ui.viewmodel.MainPageViewModel
import com.ardaisitan.personsapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

//Bu adapter classimiz card_tasarim'i temsil eder.
class PersonAdapter(var personList: List<Kisiler>, var viewModel: MainPageViewModel) :
    RecyclerView.Adapter<PersonAdapter.CardDesignHolder>() { // ViewHolder'i sinifa tanitmis olduk.

    class CardDesignHolder(var design: CardTasarimBinding) :
        RecyclerView.ViewHolder(design.root) {


    } // CardTasarimi temsil ediyor,icerisindeki gorsel nesnelere erisecegim yapi budur.Card uzerindeki her bir oge gorunumunu temsil eden viewHolder classdir.

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardDesignHolder { // Her bir oge gorunumunun nasıl olusturulacagini belirler.View holderi olusturur.
        val binding: CardTasarimBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.card_tasarim, parent,
            false
        )
        return CardDesignHolder(binding) // binding nesnesini aktardik.Viewbindingi adapterda tanimladik.

        //Her bir oge gorunumunun tasarimini viewBindingle olusturduk ve bu tasarimi iceren CardDesignHolder nesnesini dondurduk.Bu sayede recycleView,her bir oge gorunumunu
        // listelemek kullanabilir.

    }


    override fun onBindViewHolder(
        holder: CardDesignHolder,
        position: Int
        //ViewHolderi datalar ile ile  iskilendirmek icin calisir.
    ) { //position sirasiyla 0.,1.,2. seklinde calisir.Dongu gibi calisir.
        // Her bir oge gorunumunu gostermek,guncellemek icin kullanilir.
        // Belirli bir pozisyondaki veriyi gorunume baglamak icin cagrilir
        // CardDesignHolder sinifi icerisindeki CardTasarimBinding uzerinden gorunum ogelerine erisir ve  veriyi gunceller.
        val person = personList[position]

        val cardDesign = holder.design

        cardDesign.personObject = person

        cardDesign.cardView.setOnClickListener {
            val directon =
                MainPageDirections.mainToDetailPage(person) // Hangi carda tiklarsam onun bilgilerini aliriz ve aktarabiliriz.
            Navigation.gecisYap(it, directon)
        }

        cardDesign.imageDelete.setOnClickListener { it ->
            Snackbar.make(
                it,
                "${person.kisi_ad} delete?",
                Snackbar.LENGTH_SHORT
            ) // Kimi secersem onun name bilgisi gelir.
                .setAction("Yes") {
                    viewModel.delete(person.kisi_id) // Kimi sectiysek onun id'sine de ulasabilirim.Hem adini hem idsini almis olduk.
                    Snackbar.make(it, "Deleted", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }

    override fun getItemCount(): Int { //Kac adet item var onu doner.
        return personList.size
    }


}