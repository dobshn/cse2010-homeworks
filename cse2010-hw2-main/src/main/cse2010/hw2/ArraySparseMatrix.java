package cse2010.hw2;

import java.lang.reflect.Array;

public class ArraySparseMatrix implements SparseMatrix {

    private Entry[] elements = new Entry[0];

    public ArraySparseMatrix(int capacity) {
        elements = new Entry[capacity];
    }

    // SparseMatrix를 double[][]로 바꾸는 함수
    public double[][] to() {
        int row = this.elements[0].getRow(), col = this.elements[0].getCol();
        double[][] result = new double[row][col];

        // 0으로 채워넣기
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = 0;
            }
        }

        // SparseMatrix 정보 이용하여 result 채우기
        // i=0 에는 정보가 있으므로 1부터 시작
        for (int i = 1; i < this.elements.length; i++) {
            result[this.elements[i].getRow()][this.elements[i].getCol()] = this.elements[i].getValue();
        }

        return result;
    }

    // SparseMatrix의 i, j번째 elements를 바꾸는 함수
    public void Swap(int i, int j) {
        Entry temp = this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = temp;
    }

    // SparseMatrix를 행 우선, 같으면 열 우선으로 정렬
    public void Sort() {
        // i=0에는 정보가, i=1은 정렬되어 있다고 가정하여 i=2부터 시작
        for (int i = 2; i < this.elements.length; i++) {
            // row 먼저 비교하고
            if (this.elements[i].getRow() == this.elements[i - 1].getRow()) {
                // row가 같으면 col비교해서 i가 i-1보다 작으면 스왑
                if (this.elements[i].getCol() < this.elements[i - 1].getCol()) {
                    this.Swap(i-1, i);
                }
            } else {
                //row가 다르면 row 비교해서 i가 i-1보다 작으면 스왑
                if (this.elements[i].getRow() < this.elements[i - 1].getRow()) {
                    this.Swap(i-1, i);
                }
            }

        }
    }

    // double[][]를 SparseMatrix로 바꾸는 함수
    public static SparseMatrix from(double[][] aMatrix) {

        int row = aMatrix.length, col = aMatrix[0].length, cnt = 0;

        // aMatrix에서 0이 아닌 값의 갯수 새기
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (aMatrix[i][j] != 0) {
                    cnt++;
                }
            }
        }

        // ArraySparseMatrix 타입의 result 변수를 0이 아닌 값의 갯수 +1의 크기로 생성
        // 0번째에는 정보가 와야하기 때문에
        ArraySparseMatrix result = new ArraySparseMatrix(cnt + 1);

        // 0이 아닌 값을 찾으면 ++cnt 칸에 Entry로 행, 열, 값 만들어서 저장
        cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (aMatrix[i][j] != 0) {
                    result.elements[++cnt] = new Entry(i, j, aMatrix[i][j]);
                }
            }
        }

        // 0번째 칸에는 매트릭스의 정보 입력
        result.elements[0] = new Entry(row, col, cnt);

        return result;
    }

    // 각 element의 행과 열을 바꾼 후 재정렬
    @Override
    public SparseMatrix transpose() {
        ArraySparseMatrix result = new ArraySparseMatrix(this.elements.length);

        for (int i = 0; i < this.elements.length; i++) {
            result.elements[i] = new Entry(this.elements[i].getCol(), this.elements[i].getRow(), this.elements[i].getValue());
        }

        result.Sort();

        return result;
    }

    // 두 SparseMatrix를 double[][]로 바꾼 후 덧셈 수행 후 결과를 SparseMatrix로 저장
    @Override
    public SparseMatrix add(SparseMatrix other) {
        if (this.getRowCount() != other.getRowCount() || this.getColumnCount() != other.getColumnCount())
            throw new IllegalArgumentException("Matrix size doesn't match");

        double[][] a, b, result;

        // a: this를 2차원 배열로
        // b: 더할 매트릭스를 2차원 배열로
        a = this.to();
        b = ((ArraySparseMatrix) other).to(); // 이부분이 확실하지 않음.


        int row = a.length, col = a[0].length;

        // result 2차원 배열 생성
        result = new double[a.length][a[0].length];

        // result에 a + b 연산 결과 저장
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        // result를 SparseMatrix로 변환하여 return
        return ArraySparseMatrix.from(result);
    }

    @Override
    public SparseMatrix multiply(SparseMatrix other) {
        throw new IllegalStateException("Not implemented");
    }

    public Entry[] getElements() {
        return this.elements;
    }

    @Override
    public int getRowCount() { return this.elements[0].getRow(); }

    @Override
    public int getColumnCount() { return this.elements[0].getCol(); }

    @Override
    public int getElemCount() { return (int) this.elements[0].getValue(); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ArraySparseMatrix other)) return false;

        if (getRowCount() != other.getRowCount()
                || getColumnCount() != other.getColumnCount()
                || getElemCount() != other.getElemCount())
            return false;

        for (int i = 0; i < elements.length; i++) {
            if (!elements[i].equals(other.elements[i])) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        // print meta
        builder.append(elements[0].getRow() + "\t" + elements[0].getCol() + "\t" + (int) elements[0].getValue() + "\n");

        // print elements
        for (int i = 1; i <= getElemCount(); i++)
            builder.append(elements[i] + "\n");

        return builder.toString();
    }
}
