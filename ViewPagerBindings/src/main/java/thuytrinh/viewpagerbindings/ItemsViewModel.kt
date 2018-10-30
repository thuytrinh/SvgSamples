package thuytrinh.viewpagerbindings

import android.arch.lifecycle.MutableLiveData
import java.util.*

class ItemsViewModel {
  val items = MutableLiveData<List<String>>().also {
    it.postValue(emptyList())
  }
  val defaultSelectedIndex = 1

  fun refresh() {
    val size = (5..10).random()
    items.postValue((0..size).map { it.toString() })
  }

  private fun IntRange.random(): Int {
    return Random().nextInt((endInclusive + 1) - start) + start
  }
}
