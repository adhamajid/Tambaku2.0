package com.example.tambaku_

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.tambaku_.IUmum.Kadaluarsa
import com.example.tambaku_.IUmum.Kemasan
import com.example.tambaku_.IUmum.Obat
import com.example.tambaku_.IUmum.Pembuangan
import com.example.tambaku_.IUmum.Pemilihan
import com.example.tambaku_.IUmum.Penggolongan
import com.example.tambaku_.IUmum.Penggunaan
import com.example.tambaku_.IUmum.Swamedikasi
import com.example.tambaku_.IUmum.Swaprevensi
import com.example.tambaku_.Navigation.Konsul
import com.example.tambaku_.Navigation.Tentang
import com.example.tambaku_.Slide.SliderAdapter
import com.smarteist.autoimageslider.SliderView


class MainActivity : AppCompatActivity() {

    private var drawerLayout: DrawerLayout? = null

    lateinit var imageUrl: ArrayList<Int>
    lateinit var sliderView: SliderView
    lateinit var sliderAdapter: SliderAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.main)
        sliderView = findViewById(R.id.slider)
        imageUrl = ArrayList()

        imageUrl.add(R.drawable.utami2)
        imageUrl.add(R.drawable.utami1)
        imageUrl.add(R.drawable.utama)

        sliderAdapter = SliderAdapter(imageUrl)
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 4
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()

        // on below line we are adding data to our image url array list.
        /*imageUrl =
            (imageUrl + "https://practice.geeksforgeeks.org/_next/image?url=https%3A%2F%2Fmedia.geeksforgeeks.org%2Fimg-practice%2Fbanner%2Fdsa-self-paced-thumbnail.png&w=1920&q=75") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://practice.geeksforgeeks.org/_next/image?url=https%3A%2F%2Fmedia.geeksforgeeks.org%2Fimg-practice%2Fbanner%2Fdata-science-live-thumbnail.png&w=1920&q=75") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://practice.geeksforgeeks.org/_next/image?url=https%3A%2F%2Fmedia.geeksforgeeks.org%2Fimg-practice%2Fbanner%2Ffull-stack-node-thumbnail.png&w=1920&q=75") as ArrayList<String>*/

    }


    //open drawer {
    fun ClickMenu(view: View?) {
        openDrawer(drawerLayout)
    }

    fun ClickLogo(view: View?) {  //close drawer di navbar
        //Close drawer
        closeDrawer(drawerLayout)
    }

    fun ClickHome(view: View?) {
        recreate()
    }

    fun ClickTentang(view: View?) {
        redirectActivity(this, Tentang::class.java)
    }

    fun ClickKonsul(view: View?) {
        redirectActivity(this, Konsul::class.java)
    }

    fun ClickKeluar(view: View?) {
        Keluar(this)
    }

    override fun onPause() {
        super.onPause()
        closeDrawer(drawerLayout)
    }
    //drawer Layout }



    //Button halaman utama {
    fun ClickSwamedikasi(view: View?) {
        redirectActivity(this, Swamedikasi::class.java)
    }

    fun ClickSwaprevensi(view: View?) {
        redirectActivity(this, Swaprevensi::class.java)
    }

    fun ClickObat(view: View?) {
        redirectActivity(this, Obat::class.java)
    }

    fun ClickKadaluarsa(view: View?) {
        redirectActivity(this, Kadaluarsa::class.java)
    }

    fun ClickPenggolongan(view: View?) {
        redirectActivity(this, Penggolongan::class.java)
    }

    fun ClickKemasan(view: View?) {
        redirectActivity(this, Kemasan::class.java)
    }

    fun ClickPemilihan(view: View?) {
        redirectActivity(this, Pemilihan::class.java)
    }

    fun ClickPenggunaan(view: View?) {
        redirectActivity(this, Penggunaan::class.java)
    }

    fun ClickPembuangan(view: View?) {
        redirectActivity(this, Pembuangan::class.java)
    }
    // Halaman Utama }


    //Macam-macam Obat
    fun ClickBatuk(view: View?) {
        redirectActivity(this, Batuk::class.java)
    }

    fun ClickFlu(view: View?) {
        redirectActivity(this, Flu::class.java)
    }

    fun ClickDemam(view: View?) {
        redirectActivity(this, Demam::class.java)
    }

    fun ClickDiare(view: View?) {
        redirectActivity(this, Diare::class.java)
    }

    fun ClickSembelit(view: View?) {
        redirectActivity(this, Sembelit::class.java)
    }

    fun ClickMaag(view: View?) {
        redirectActivity(this, Maag::class.java)
    }

    companion object {
        fun openDrawer(drawerLayout: DrawerLayout?) {
            //Open drawer layout
            drawerLayout?.openDrawer(GravityCompat.START)
        }

        fun closeDrawer(drawerLayout: DrawerLayout?) {
            //close drawer layout
            //check condition
            if (drawerLayout?.isDrawerOpen(GravityCompat.START) == true) {
                //when drawer is open
                //close drawer
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }
        fun Keluar(activity: Activity) {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Exit")
            builder.setMessage("Yakin Anda Keluar ?")
            builder.setPositiveButton("Iya") { dialog, which -> //Finish
                activity.finishAffinity()
                System.exit(0)
            }
            builder.setNegativeButton("Tidak") { dialog, which -> dialog.dismiss() }
            builder.show()
        }
        fun redirectActivity(activity: Activity, aClass: Class<*>?) {
            //initialize intent
            val intent = Intent(activity, aClass)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            activity.startActivity(intent)
        }
    }
}