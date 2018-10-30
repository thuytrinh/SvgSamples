package thuytrinh.viewpagerbindings

import me.tatarka.bindingcollectionadapter2.ItemBinding

object ItemBindings {
  @JvmStatic
  fun create(): ItemBinding<String> {
    return ItemBinding.of<String>(BR.viewModel, R.layout.item)
  }
}
