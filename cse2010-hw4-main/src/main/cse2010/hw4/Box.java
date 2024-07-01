package cse2010.hw4;

import java.util.Arrays;
import java.util.Random;

public class Box {
    // 각 인덱스에서의 오른쪽, 왼쪽 이동 여부 저장
    private boolean[][] flags;

    private static final int DEFAULT_TARGET_INDEX = 0;

    private int[] boxes;

    private int startIndex;
    private int targetIndex = DEFAULT_TARGET_INDEX;

    public Box(int size) {
        this(size, size - 1, DEFAULT_TARGET_INDEX);
    }

    public Box(int size, int start, int target) {
        startIndex = start;
        targetIndex = target;
        getBuckets(size, new Random(System.currentTimeMillis()));
    }

    private void getBuckets(int size, Random gen) {
        boxes = new int[size];
        for (int i = 0; i < size; i++) {
            int value = 0;
            while ((value = Math.abs(gen.nextInt())) % size == 0)
                ;
            boxes[i] = value % size;
        }
        boxes[targetIndex] = 0;

        initFlags(size);
    }

    private void initFlags(int size) {
        flags = new boolean[size][2];
        for (int i = 0; i < size; i++) {
            flags[i] = new boolean[]{false, false};
        }
    }

    public boolean move(int current) {
        // 종료 조건: 지금 값이 0
        if (boxes[current] == 0) return true;

        // 왼쪽으로 이동: 이동한적 없고, 이동할 수 있으면
        if (!(flags[current][0]) && current - boxes[current] >= 0) {
            flags[current][0] = true;
            if (move(current - boxes[current])) return true;
        }

        // 오른쪽으로 이동: 이동한적 없고, 이동할 수 있으면
        if (!(flags[current][1]) && current + boxes[current] < boxes.length) {
            flags[current][1] = true;
            if (move(current + boxes[current])) return true;
        }

        return false;
    }

    public boolean start() {
        return move(startIndex);
    }

    public int[] getBoxes() {
        return boxes;
    }

    public Box(int[] buckets) {
        this(buckets, buckets.length - 1, DEFAULT_TARGET_INDEX);
    }

    public Box(int[] buckets, int start, int target) {
        this.boxes = buckets;
        startIndex = start;
        targetIndex = target;

        initFlags(buckets.length);
    }

    public Box(int size, Random gen) {
        this(size, size - 1, DEFAULT_TARGET_INDEX, gen);
    }

    public Box(int size, int start, int target, Random gen) {
        startIndex = start;
        targetIndex = target;
        getBuckets(size, gen);
    }

    public static void main(String... args) {
        Box puzzle = new Box(5);
        System.out.println(Arrays.toString(puzzle.getBoxes()));
        System.out.println(puzzle.start());

        Box puzzle2 = new Box(5, 0, 4);
        System.out.println(Arrays.toString(puzzle2.getBoxes()));
        System.out.println(puzzle2.start());

        Box puzzle3 = new Box(5, new Random(1569));
        System.out.println(Arrays.toString(puzzle3.getBoxes()));
        System.out.println(puzzle3.start());

        Box puzzle4 = new Box(5, new Random(1569));
        System.out.println(Arrays.toString(puzzle3.getBoxes()));
        System.out.println(puzzle4.start());
    }
}
