package cse2010.hw3;

import java.io.IOException;

public class Exeptions {

    static void checked() throws IOException {
        throw new IOException("oops");
    }

    static void idonotknow_how_to_handle() {
        try {
            checked(); // 여기선 그냥 부를 수 있음, throws 가 있기 때문에
        } catch (IOException e) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 그냥 checked를 부르면 안 됨.
        try {
            checked();
        } catch (IOException e) {
            System.out.println("E");
        }

        idonotknow_how_to_handle();

    }
}
