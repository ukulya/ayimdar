package com.kay.progayim

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.kay.progayim.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val githubApi get() = Injector.githubApi
    private val database get() = Injector.database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        githubApi.getCharacters()
            .subscribeOn(Schedulers.io())
            .map {
                Thread.sleep(5000)
                it
            }
            .map {
                val listEp = mutableListOf<CharacterEntity>()
                it.results.forEach {
                    val character = CharacterEntity(
                        id = it.id,
                        name = it.name,
                        status = it.status,
                        species = it.species,
                        type = it.type,
                        gender = it.gender,
                        image = it.image,
                        url = it.url,
                        created = it.created,
                        episode = it.episode,
                    )
                    listEp.add(character)
                }
                listEp.toList()
            }
            .map {
                database.characterDao().insertList(it)

            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                Log.e("TAG", "Result= $it")
            }
            .subscribe()

        database.characterDao().getAll().observe(this, {
            it[0].episode.forEach {
                Log.e("TAG", "episode = $it")
            }
        })
    }
}