package com.albertogfv.snack_truck.ui.orderList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import com.albertogfv.snack_truck.R
import com.albertogfv.snack_truck.data.db.entities.OrderItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.dialog_send_order_item.view.*


@AndroidEntryPoint
class SendOrderItemDialog(item: List<OrderItem>): DialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.dialog_send_order_item,container,false)

        val arrayAdapter: ArrayAdapter<*>
        rootView.lvSend = items

        rootView.btnCancel.setOnClickListener {
            dismiss()
        }

        rootView.btnSend.setOnClickListener {
            dismiss()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}