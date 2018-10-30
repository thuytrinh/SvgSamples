package thuytrinh.viewpagerbindings

import android.databinding.BindingAdapter
import android.support.v4.view.ViewPager
import me.tatarka.bindingcollectionadapter2.BindingCollectionAdapters
import me.tatarka.bindingcollectionadapter2.ItemBinding

@BindingAdapter(value = ["itemsWithSelectedIndex", "itemBinding"])
fun <ItemType> ViewPager.setItemsWithSelectedIndex(
  x: ItemsWithSelectedIndex<ItemType>?,
  itemBinding: ItemBinding<ItemType>
) {
  x?.let {
    BindingCollectionAdapters.setAdapter(this, itemBinding, it.items, null, null)
    setCurrentItem(it.selectedIndex, false)
  }
}
