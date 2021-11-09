package com.example.hw_product_recycleview

import android.os.Bundle
import android.view.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw_product_recycleview.adapter.ItemAdapter
import com.example.hw_product_recycleview.data.Datasource
import com.example.hw_product_recycleview.databinding.FragmentProductListBinding


class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    // the first fun onCreate()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // the second one is onCreateView()
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }
    // the third and it's last one is onViewCreated()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // send the Adapter parameter like main activity
        binding.recyclerView.adapter = ItemAdapter(this.requireContext(), Datasource().loadProduct())
        binding.recyclerView.setHasFixedSize(true)
    }

    /**
     * Frees the binding object when the Fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}