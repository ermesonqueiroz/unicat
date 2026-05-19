package com.github.ermesonqueiroz.unicat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.github.ermesonqueiroz.unicat.adapters.CatAdapter
import com.github.ermesonqueiroz.unicat.domain.Cat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserCatListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserCatListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_cat_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvCats = view.findViewById<RecyclerView>(R.id.rvCats)

        val catList = listOf<Cat>(
            Cat("Mingau", "📍 Bloco C", "🐱", "#E8F0FB"),
            Cat("Pretinha", "📍 Biblioteca", "🐈", "#1A1A2E"),
            Cat("Tigrão", "📍 Lagoa", "🦁", "#FEF3C7")
        )

        val catAdapter = CatAdapter(catList) { cat ->
            Toast.makeText(requireContext(), "Clicou em: ${cat.name}", Toast.LENGTH_SHORT).show()
        }

        rvCats.adapter = catAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserCatListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserCatListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}