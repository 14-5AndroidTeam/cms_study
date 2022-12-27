package com.nise.paste.UI.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nise.paste.Data.DTO.Form
import com.nise.paste.Data.Repository
import com.nise.paste.UI.Event

class FormModel:androidx.lifecycle.ViewModel() {
    val repo = Repository()
    private var _submit = MutableLiveData<Event<Boolean>>()
    val submit:LiveData<Event<Boolean>> = _submit

    fun postForm(content:String,id:String){
        var form = Form(
            content = content,
            id = id,
            isCompleted = true
        )
        repo.postForm(form)
        _submit.postValue(Event(true))
    }

}