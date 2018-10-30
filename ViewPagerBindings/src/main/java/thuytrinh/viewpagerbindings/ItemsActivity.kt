package thuytrinh.viewpagerbindings

import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import thuytrinh.viewpagerbindings.databinding.ActivityItemsBinding

class ItemsActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = setContentView<ActivityItemsBinding>(this, R.layout.activity_items)
    binding.viewModel = ItemsViewModel()
    binding.setLifecycleOwner(this)
  }
}
