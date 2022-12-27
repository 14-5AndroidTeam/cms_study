package com.nise.paste.UI.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nise.paste.Data.DTO.ToDoList
import com.nise.paste.Data.Repository
import com.nise.paste.UI.Event


class ListModel:androidx.lifecycle.ViewModel() {
    val repo = Repository()

    private var _submit = MutableLiveData<Event<Boolean>>()
    val submit: LiveData<Event<Boolean>> = _submit

    private var _setList = MutableLiveData<Event<ToDoList>>()
    val setList: LiveData<Event<ToDoList>> = _setList

    fun getList(){
        repo.getList(object : Repository.GetDataCallback<ToDoList>{
            override fun onSuccess(data: ToDoList?) {
                if(data != null) _setList.postValue(Event(data))
            }

            override fun onFailure(throwable: Throwable) {
            }
        })
    }
}