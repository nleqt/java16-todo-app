package sorting.object.type;

import java.util.Arrays;

import common.Item;
import common.NullOption;
import utils.ArrayUtils;

public class Ex03BubbleSortWithItemAndNthComparable {
	public static void main(String[] args) {

		Item[] items = getItems();
		ArrayUtils.printf("sorted items", items);
		System.out.println("========");
		bubbleSort(items);
		ArrayUtils.printf("sorted items", items);
	}

	// bubble sort with default is NULL_FIRST
	private static void bubbleSort(Item[] elements) {
		bubbleSort(elements, NullOption.NULL_FIRST);
	}

	private static void bubbleSort(Item[] elements, NullOption no) {
		for (int round = 0; round < elements.length; round++) {
			for (int i = 0; i < elements.length - round - 1; i++) {
				Item i1 = elements[i];
				Item i2 = elements[i + 1];
				// step 1 --> handle null values --> null first
				if (NullOption.NULL_FIRST.equals(no)) {
					if (i1 == null) {
						continue;
					}
					if (i2 == null) {
						Item temp = elements[i];
						elements[i] = elements[i + 1];
						elements[i + 1] = temp;
						continue;
					}
				} else if (NullOption.NULL_LAST.equals(no)) {

					if (i1 == null && i2 != null) {
						Item temp = elements[i];
						elements[i] = elements[i + 1];
						elements[i + 1] = temp;
						continue;
					}
					if (i2 == null) {
						continue;
					}
				}
				// step 1 --> end

				// step 2 --> handle non-null values --> ASC

				/*if (i1.getStoreId() - i2.getStoreId() < 0) {
					// swap
					Item temp = elements[i];
					elements[i] = elements[i + 1];
					elements[i + 1] = temp;

				} else if (i1.getStoreId() - i2.getStoreId() == 0) {
					if (i1.getId() - i2.getId() > 0) {
						Item temp = elements[i];
						elements[i] = elements[i + 1];
						elements[i + 1] = temp;
					}
				}*/
				if (compareTo(i1, i2) > 0) {
					Item temp = elements[i];
					elements[i] = elements[i + 1];
					elements[i + 1] = temp;
				}
			}
		}
	}

	// storeId(DESC), itemId(ASC)
	public static int compareTo(Item i1, Item i2) {
		if (i1.getStoreId() < i2.getStoreId() ) {
			return 1;
		}
		else if (i1.getStoreId() > i2.getStoreId()) {
			return -1;
		} else {
			// storeId1 = storeId2
			return i1.getId() - i2.getId();
		}
	}

	private static Item[] getItems() {
		return new Item[] { new Item(1, "Item 1", 350, 101), new Item(8, "Item 8", 540, 102),
				new Item(2, "Item 2", 690, 101), new Item(5, "Item 5", 220, 102), new Item(9, "Item 9", 160, 102) };

	}

}
