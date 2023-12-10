import matplotlib.pyplot as plt
import pandas as pd

data = pd.read_csv("data.csv", delimiter=" ")
data = data.set_index("InputSize")

data[["InsertionSort", "QuickSort", "RadixSort", "HeapSort"]].plot(linewidth=4)

plt.savefig("algs_unsorted_input.png")

data[["InsertionSortSorted", "QuickSortSorted", "RadixSortSorted", "HeapSortSorted"]].plot(linewidth=4)

plt.savefig("algs_sorted_input.png")

data[["QuickSort", "RadixSort", "HeapSort"]].plot(linewidth=4)

plt.savefig("algs_no_insertion_unsorted.png")

data[["InsertionSortSorted", "RadixSortSorted", "HeapSortSorted"]].plot(linewidth=4)

plt.savefig("algs_no_quick_sorted.png")

small = data[:20]

small[["InsertionSort", "QuickSort", "RadixSort", "HeapSort"]].plot(linewidth=4)

plt.savefig("up_to_hundred_unsorted.png")

small[["InsertionSortSorted", "QuickSortSorted", "RadixSortSorted", "HeapSortSorted"]].plot(linewidth=4)

plt.savefig("up_to_hundred_sorted.png")
