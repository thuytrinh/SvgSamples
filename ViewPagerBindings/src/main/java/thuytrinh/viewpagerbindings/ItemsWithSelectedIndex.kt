package thuytrinh.viewpagerbindings

data class ItemsWithSelectedIndex<ItemType>(
  val items: List<ItemType> = emptyList(),
  val selectedIndex: Int = 0
) {
  init {
    when {
      items.isEmpty() -> require(selectedIndex == 0) {
        "selectedIndex must be 0 (was $selectedIndex)"
      }
      else -> require(selectedIndex >= 0 && selectedIndex <= items.lastIndex) {
        "selectedIndex must be in range of 0 to ${items.lastIndex} (was $selectedIndex)"
      }
    }
  }
}
