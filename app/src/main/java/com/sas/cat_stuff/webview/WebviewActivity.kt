package com.sas.cat_stuff.webview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sas.cat_stuff.R
import com.sas.cat_stuff.common.bundlemanager.BundleManager
import com.sas.cat_stuff.databinding.ActivityWebviewBinding

class WebviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebviewBinding

    @SuppressLint("SetJavaScriptEnabled")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = ""

        val url = BundleManager().from(this).extractUrl()

        binding = DataBindingUtil.setContentView<ActivityWebviewBinding>(this, R.layout.activity_webview).apply {
            lifecycleOwner = this@WebviewActivity
        }

        binding.webview.apply {
            webViewClient = WebViewClient()
            settings.apply {
                javaScriptEnabled = true
            }

            loadUrl(url)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun openActivity(
            context: Context,
            url: String
        ) = context.startActivity(Intent(context, WebviewActivity::class.java).apply {
            BundleManager().attachUrl(url).into(this)
        })
    }
}