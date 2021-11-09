package com.example.hw_product_recycleview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw_product_recycleview.databinding.FragmentInfoOfProductBinding


class InfoOfProductFragment : Fragment() {

    private var _binding: FragmentInfoOfProductBinding? = null
    private val binding get() = _binding!!

    // the first fun onCreate(): inflate layout and set content
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    // the second one is onCreateView()
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentInfoOfProductBinding.inflate(inflater, container, false)
        return binding.root
    }


    // the third and it's last one is onViewCreated()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // action_productListFragment_to_infoOfProductFragment

        arguments?.let {

            binding.phoneImage.setImageResource(it.getInt("image"))
            binding.nameOfProduct.text = it.getString("nameOfProduct")

        }

    }

    /**
     * Frees the binding object when the Fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}