package com.nise.paste.UI.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nise.paste.R
import com.nise.paste.UI.Event
import com.nise.paste.UI.ViewModel.FormModel
import com.nise.paste.databinding.FragmentFormBinding


class FormFragment : Fragment() {
    private lateinit var binding: FragmentFormBinding

    private var _cancel = MutableLiveData<Event<Boolean>>()
    val cancel: LiveData<Event<Boolean>> = _cancel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var viewmodel = FormModel()
        binding.cancelBtn.setOnClickListener {
            //_cancel.postValue(Event(true))
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.layout, ListFragment())
                .commit()
        }
        binding.submitBtn.setOnClickListener {
            if(binding.inputContent.text.isEmpty() or binding.inputDeadline.text.isEmpty()){
            }
            else{
                viewmodel.postForm(binding.inputContent.text.toString(), binding.inputDeadline.text.toString())
            }
            viewmodel.submit.observe(viewLifecycleOwner, Observer {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.layout, ListFragment())
                    .commit()
            })
        }
    }
}