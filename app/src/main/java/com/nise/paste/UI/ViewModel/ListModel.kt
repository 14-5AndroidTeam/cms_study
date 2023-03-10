package com.nise.paste.UI.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nise.paste.Data.DTO.ToDoList
import com.nise.paste.Data.Repository
import com.nise.paste.UI.Event


class ListModel:androidx.lifecycle.ViewModel() {
    /*val repo = Repository()

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
    }*/

    val repo = Repository()

    private var _submit = MutableLiveData<Event<Boolean>>()
    val submit: LiveData<Event<Boolean>> = _submit

    private var _setList = MutableLiveData<Event<ToDoList>>()
    val setList: LiveData<Event<ToDoList>> = _setList

    fun getList(){
        repo.getList(object :Repository.GetDataCallback<ToDoList>{
            override fun onSuccess(data: ToDoList?) {
                /**응답받은 데이터 내용을 LiveData로 할당한다*/
                if(data != null) _setList.postValue(Event(data))
            }

            override fun onFailure(throwable: Throwable) {
                /**throwable 매개변수를 가공을 해서 UI단에 에러메세지로 넘겨줄 수 있겠다....*/
            }
        })
    }
}



