package thuytrinh.viewpagerbindings

import android.arch.lifecycle.MutableLiveData
import java.util.*

class ItemsViewModel {
  val items = MutableLiveData<ItemsWithSelectedIndex<String>>().also {
    it.postValue(ItemsWithSelectedIndex())
  }

  init {
    generateItems()
  }

  fun refresh() {
    generateItems()
  }

  private fun generateItems() {
    val size = (5..10).random()
    val newItems = (0..size).map { it.toString() }
    val newSelectedIndex = (1..newItems.lastIndex).random()

    items.postValue(ItemsWithSelectedIndex(items = newItems, selectedIndex = newSelectedIndex))
  }

  private fun IntRange.random(): Int {
    return Random().nextInt((endInclusive + 1) - start) + start
  }
}
