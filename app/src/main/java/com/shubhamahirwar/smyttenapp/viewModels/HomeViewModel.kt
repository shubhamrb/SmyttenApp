package com.shubhamahirwar.smyttenapp.viewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.shubhamahirwar.smyttenapp.models.ContentModel
import com.shubhamahirwar.smyttenapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    private val _contentModel = MutableLiveData<ContentModel>()
    val contentModel: LiveData<ContentModel> get() = _contentModel

    fun loadJsonFile(context: Context) {
        viewModelScope.launch {
            try {
                val json: String = withContext(Dispatchers.IO) {
                    context.assets.open("smytten.json").bufferedReader().use { it.readText() }
                }
                val contentModel = Gson().fromJson(json, ContentModel::class.java)
                _contentModel.postValue(contentModel)
            } catch (e: Exception) {
                Log.e(Constants.TAG, "Error loading JSON file", e)
            }
        }
    }
}