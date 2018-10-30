# Bind items with a selected index into `ViewPager`

Firstly, we define a data structure which has a bounds checking. This is to ensure that we make no mistake of passing a selected index which is out of bounds of the given `items`.

```kotlin
data class ItemsWithSelectedIndex<ItemType>(
  val items: List<ItemType> = emptyList(),
  val selectedIndex: Int = 0
) {
  init {
    require(selectedIndex >= 0 && selectedIndex <= items.lastIndex) {
      "selectedIndex $selectedIndex must be in range of 0 to ${items.lastIndex}"
    }
  }
}
```

Next, write a custom binding adapter:

```kotlin
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
```

## Usage

In your ViewModel, declare a `MutableLiveData<ItemsWithSelectedIndex<String>>` (as an example that the items here are a list of `String`):

```kotlin
class ItemsViewModel {
  val items = MutableLiveData<ItemsWithSelectedIndex<String>>().also {
    it.postValue(ItemsWithSelectedIndex(
      items = createNewItems(),
      selectedIndex = getNewSelectedIndex()
    ))
  }
}
```

Binding into layout can be done like:

```xml
<android.support.v4.view.ViewPager
  android:id="@+id/viewPager"
  android:layout_width="match_parent"
  android:layout_height="0dp"
  android:layout_weight="1"
  app:itemBinding="@{ItemBindings.create()}"
  app:itemsWithSelectedIndex="@{viewModel.items}" />
```

With `ItemBindings` that looks like:

```kotlin
object ItemBindings {
  @JvmStatic
  fun create(): ItemBinding<String> {
    return ItemBinding.of<String>(BR.viewModel, R.layout.item)
  }
}
```