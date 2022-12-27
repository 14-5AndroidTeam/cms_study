package com.nise.paste.UI.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import com.nise.paste.UI.ViewModel.ListModel
import com.nise.paste.R
import com.nise.paste.UI.Event
import com.nise.paste.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var binding :FragmentListBinding
    val formFragment = FormFragment()

    private var _form = MutableLiveData<Event<Boolean>>()

    val form : LiveData<Event<Boolean>> = _form

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter = Adapter()
        binding.recyclerview.adapter = adapter

        var viewmodel = ListModel()
        viewmodel.getList()

        binding.addButton.setOnClickListener{
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.layout,FormFragment())
                .commit()
        }
        viewmodel.setList.observe(viewLifecycleOwner, Observer {
            adapter.setList(it.peekContent().todos)
            adapter.notifyItemChanged(0,it.peekContent().total_post)
        })
    }
}