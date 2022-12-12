package com.example.android.thejieyang

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MsgFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MsgFragment : Fragment(), View.OnClickListener {
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
        var view=inflater.inflate(R.layout.fragment_msg, container, false)
        val button = view.findViewById<Button>(R.id.tuichu)
        var version = view.findViewById<TextView>(R.id.version)
        var project = view.findViewById<TextView>(R.id.project)
        var github = view.findViewById<TextView>(R.id.github)
        button.setOnClickListener(this)
        version.setOnClickListener(this)
        project.setOnClickListener(this)
        github.setOnClickListener(this)
        return view
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MsgFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MsgFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tuichu->{
                Toast.makeText(activity,"退出成功！",Toast.LENGTH_SHORT).show()
                activity?.finish()
            }

            R.id.version->{
                Toast.makeText(activity,"当前版本为：v1.0",Toast.LENGTH_SHORT).show()
            }

            R.id.project->{
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://github.com/linXiao01/JieYang")
                startActivity(intent)
            }

            R.id.github->{
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://github.com/linXiao01/")
                startActivity(intent)
            }

        }
    }

}