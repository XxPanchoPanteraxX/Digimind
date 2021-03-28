package preciado.francisco.digimind_205371.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import preciado.francisco.digimind_205371.R
import preciado.francisco.digimind_205371.Reminder
import kotlinx.android.synthetic.main.reminder_item.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var reminderAdapter : ReminderAdapter? = null
    var lstReminders = ArrayList<Reminder>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val gvReminder = root.findViewById(R.id.gvReminders) as GridView

        lstReminders.add(Reminder("Everyday","17:00","Practice"))
        lstReminders.add(Reminder("Everyday","17:00","Practice"))
        lstReminders.add(Reminder("Everyday","17:00","Practice"))
        lstReminders.add(Reminder("Everyday","17:00","Practice"))
        lstReminders.add(Reminder("Everyday","17:00","Practice"))
        lstReminders.add(Reminder("Everyday","17:00","Practice"))
        lstReminders.add(Reminder("Everyday","17:00","Practice"))
        lstReminders.add(Reminder("Everyday","17:00","Practice"))
        lstReminders.add(Reminder("Everyday","17:00","Practice"))
        lstReminders.add(Reminder("Everyday","17:00","Practice"))
        lstReminders.add(Reminder("Everyday","17:00","Practice"))


        reminderAdapter = ReminderAdapter(requireContext(), lstReminders)

        gvReminder.adapter=reminderAdapter

        return root
    }
}

class ReminderAdapter : BaseAdapter {
    var lstReminders = ArrayList<Reminder>()
    var context: Context? = null

    constructor(context: Context, lstReminders: ArrayList<Reminder>) {
        this.context = context
        this.lstReminders = lstReminders
    }

    override fun getCount(): Int {
        return lstReminders.size
    }

    override fun getItem(p0: Int): Any {
        return lstReminders[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var reminder = lstReminders[p0]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = inflater.inflate(R.layout.reminder_item, null)

        view.tvTitle.setText(reminder.name)
        view.tvWhen.setText(reminder.days)
        view.tvTime.setText(reminder.time)

        return view
    }

}