package com.example.loadingcomponenttesting

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.contains
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

abstract class BaseActivity : AppCompatActivity() {

    private enum class LoadingType {
        SWIPE_REFRESH,
        PROGRESS_BAR
    }

    private var view: ViewGroup? = null
    private lateinit var loadingView: View
    private var loadingType: LoadingType = LoadingType.PROGRESS_BAR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = (window.decorView.rootView as? ViewGroup)
        loadingView = View.inflate(this, R.layout.loading, null)

    }

    fun setSwipeRefreshLoading(swipeView: SwipeRefreshLayout, contentView: View) {
        loadingType = LoadingType.SWIPE_REFRESH

        view?.removeView(loadingView)
        loadingView = swipeView
        swipeView.addView(contentView)

    }

    fun setLoadingLayout(@LayoutRes layoutRes: Int) {
        loadingView = View.inflate(this, layoutRes, null)
    }

    fun showLoading(isLoading: Boolean) {

        when (loadingType) {
            LoadingType.SWIPE_REFRESH ->
            else -> showLoadingProgressBar(isLoading)
        }
    }

    private fun showLoadingSwipeRefresh(isLoading: Boolean) {
        view?.let { view ->
            (loadingView as SwipeRefreshLayout).isRefreshing = isLoading
        }
    }

    private fun showLoadingProgressBar(isLoading: Boolean) {
        view?.let { view ->
            if (isLoading) {
                view.addView(loadingView)
            } else {
                view.removeView(loadingView)
            }
        }
    }


}