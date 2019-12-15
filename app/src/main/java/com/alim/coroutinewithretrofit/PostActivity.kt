package com.alim.coroutinewithretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import com.alim.coroutinewithretrofit.di.DaggerPostComponent
import com.alim.coroutinewithretrofit.di.Injector
import com.alim.coroutinewithretrofit.network.ApiGateway
import kotlinx.android.synthetic.main.activity_post.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostActivity : AppCompatActivity() {

    @Inject
    lateinit var apiGateway: ApiGateway

    @Inject
    lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        posts.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postsAdapter
            addItemDecoration(DividerItemDecoration(context, VERTICAL))
        }
        loadPosts()
    }

    private fun loadPosts() {
        MainScope().launch {
            val response = apiGateway.getPosts()
            postsAdapter.posts = response
            postsAdapter.notifyDataSetChanged()
        }
    }

    private fun injectDependencies() {
        DaggerPostComponent.builder()
            .applicationComponent(Injector.baseComponent)
            .build()
            .inject(this)
    }
}
