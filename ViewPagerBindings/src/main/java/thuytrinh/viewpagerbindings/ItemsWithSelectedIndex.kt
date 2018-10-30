package thuytrinh.viewpagerbindings

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
