package org.jamee.learn.algorithm.sort;

import java.util.*;

/**
 * 堆排序
 */
public class HeapSort {
    /**
     * 堆
     * <li>大顶堆可以按从小到大排序，可以取最小的 K 个元素</li>
     * <li>小顶堆可以按从大到小排序，可以取最大的 K 个元素</li>
     * @param <V> 可以比较大小的类型实现 Comparable
     */
    private static class Heap<V extends Comparable<V>> {
        // 存储元素的堆
        private final List<V> heap;
        // 是否是最大堆
        private final boolean maxHeap;

        private Heap(int capacity, boolean maxHeap) {
            this.maxHeap = maxHeap;
            this.heap = new ArrayList<>(capacity + 1);
            // 为了构建树简单，第一个位置不使用
            this.heap.add(null);
        }

        private Heap(Collection<V> collection, boolean maxHeap) {
            this.maxHeap = maxHeap;
            this.heap = new ArrayList<>(collection.size() + 1);
            // 为了构建树简单，第一个位置不使用
            this.heap.add(null);
            this.heap.addAll(collection);
        }

        private void swap(int firstIndex, int secondIndex) {
            V first = heap.get(firstIndex);
            V second = heap.get(secondIndex);
            heap.set(firstIndex, second);
            heap.set(secondIndex, first);
        }

        /**
         * 获取堆大小
         *
         * @return 堆大小
         */
        private int getSize() {
            // 由于 index = 0，不用，因此堆大小是 heap.size() - 1;
            return heap.size() - 1;
        }

        private boolean firstLtSecond(int firstIndex, int secondIndex) {
            V first = heap.get(firstIndex);
            V second = heap.get(secondIndex);
            return first.compareTo(second) < 0;
        }

        private void sink(int k, int n) {
            // k 还有子节点
            while (2 * k <= n) {
                int left = 2 * k;
                int right = 2 * k + 1;
                int childIdx = left;
                // k 没有右子节点，退出
                // 大顶堆：左子节点小于右子节点
                if (maxHeap) {
                    if (right <= n && firstLtSecond(left, right)) {
                        childIdx = right;
                    }
                    // 大顶堆：当前节点小于子节点则下沉
                    if (firstLtSecond(k, childIdx)) {
                        swap(k, childIdx);
                        k = childIdx;
                    } else {
                        break;
                    }
                } else {
                    // 小顶堆：左子节点大于右子节点
                    if (right <= n && firstLtSecond(right, left)) {
                        childIdx = right;
                    }
                    // 小顶堆：当前节点大于子节点则下沉
                    if (firstLtSecond(childIdx, k)) {
                        swap(k, childIdx);
                        k = childIdx;
                    } else {
                        break;
                    }
                }
            }
        }

        private void swim(int k) {
            // index 不是根元素
            while (k > 1) {
                if (maxHeap) {
                    // 大顶堆：且当前节点比父节点大，则上浮
                    if (firstLtSecond(k / 2, k)) {
                        swap(k, k / 2);
                        k = k / 2;
                    } else {
                        break;
                    }
                } else {
                    // 小顶堆：且当前节点比父节点小，则上浮
                    if (firstLtSecond(k, k / 2)) {
                        swap(k, k / 2);
                        k = k / 2;
                    } else {
                        break;
                    }
                }
            }
        }

        public List<V> get() {
            this.heap.remove(0);
            return this.heap;
        }

        private V getRootElement() {
            return this.heap.get(1);
        }

        private void setRootElement(V element) {
            this.heap.set(1, element);
        }

        private void add(V element) {
            this.heap.add(element);
        }
    }

    /**
     * 获取集合中最小的 K 个元素
     * @param elements 集合
     * @param k k 个元素
     * @param <T> 元素类型，要可以比较大小，需要实现 Comparable
     * @return K 个最小的元素
     */
    public static <T extends Comparable<T>> List<T> minK(Collection<T> elements, int k) {
        Heap<T> heapSort = new Heap<>(k, true);

        for (T element : elements) {
            int size = heapSort.getSize();
            // 还未到达最大堆大小
            if (size < k) {
                // 追加元素并上浮排序
                heapSort.add(element);
                heapSort.swim(size + 1);
            } else {
                T max = heapSort.getRootElement();
                // 当前元素比堆最大元素小
                if (element.compareTo(max) < 0) {
                    // 则把当前元素放到根节点
                    heapSort.setRootElement(element);
                    // 下沉根节点
                    heapSort.sink(1, size);
                }
            }
        }
        return heapSort.get();
    }

    /**
     * 获取集合中最小的 K 个元素
     * @param elements 集合
     * @param k k 个元素
     * @param <T> 元素类型，要可以比较大小，需要实现 Comparable
     * @return K 个最小的元素
     */
    public static <T extends Comparable<T>> List<T> topK(Collection<T> elements, int k) {
        Heap<T> heapSort = new Heap<>(k, false);

        for (T element : elements) {
            int size = heapSort.getSize();
            // 还未到达最大堆大小
            if (size < k) {
                // 追加元素并上浮排序
                heapSort.add(element);
                heapSort.swim(size + 1);
            } else {
                T min = heapSort.getRootElement();
                // 当前元素比堆最小元素大
                if (element.compareTo(min) > 0) {
                    // 则把当前元素放到根节点
                    heapSort.setRootElement(element);
                    // 下沉根节点
                    heapSort.sink(1, size);
                }
            }
        }
        return heapSort.get();
    }

    /**
     * 从小到大排序，堆排序实现
     *
     * @param elements 待排序集合
     * @param <T> 元素类型，要可以比较大小，需要实现 Comparable
     * @return 从小到大排序后的结果
     */
    public static <T extends Comparable<T>> List<T> sort(Collection<T> elements, boolean asc) {
        Heap<T> heapSort = new Heap<>(elements, asc);

        // 通过下沉的方式构造最大堆
        int n = heapSort.getSize();
        // 只需floor(N/2)次"下沉"即可将堆构建完成，因为一个大小为N的完全二叉树，叶子节点的数量至少为N/2个
        for (int i = n / 2; i > 0; i--) {
            heapSort.sink(i, n);
        }

        // 堆排序, 升序排列
        while (n > 1) {
            // 把最大的元素移动到最后
            heapSort.swap(1, n);
            // 减小堆大小
            n--;
            // 新堆下沉有序化
            heapSort.sink(1, n);
        }
        return heapSort.get();
    }

    public static void main(String[] args) {
        List<Integer> arrays = new ArrayList<>();
        int size = 20;
        for (int i = 0; i < size; i++) {
            arrays.add(i);
        }
        Collections.shuffle(arrays);
        System.out.println("before sort: " + arrays);
        System.out.println("asc sort: " + HeapSort.sort(arrays, true));
        System.out.println("desc sort: " + HeapSort.sort(arrays, false));
        System.out.println("Min 5: " + HeapSort.minK(arrays, 5));
        System.out.println("Max 5: " + HeapSort.topK(arrays, 5));
    }
}
