package com.example.strikers_tr.utils.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.airbnb.lottie.LottieAnimationView

@BindingAdapter("imageResource")
fun loadImage(view: ImageView, image: Int) {
    view.setImageResource(image)
}

@BindingAdapter("loaderStatus")
fun showAnimation(view: LottieAnimationView, isPlay: MutableLiveData<Boolean>) {
    isPlay.observeForever {
        if (it) {
            view.playAnimation()
        } else {
            view.pauseAnimation()
        }
    }

}