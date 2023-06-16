package com.artemiod.challengeandroidkotlinalkemy.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.artemiod.challengeandroidkotlinalkemy.LoginActivity
import com.artemiod.challengeandroidkotlinalkemy.R
import com.artemiod.challengeandroidkotlinalkemy.domain.SelectedListener
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SelectedListener {
    private var btnLogout: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogout = findViewById(R.id.homeExit)
        btnLogout?.setOnClickListener(View.OnClickListener {
            FirebaseAuth.getInstance().signOut()
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        })
    }

    override fun onSelected(id: Int) {
        val bundle = Bundle()
        bundle.putInt("id", id)

        val detailsFragment = DetailsFragment()
        detailsFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, detailsFragment)
            .addToBackStack(null)
            .commit()
    }

}