package ir.maktabsharif101.oopjdbc;

import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException, InterruptedException {

        long start = System.currentTimeMillis();
        System.out.println();
        System.out.println(
                getDashboardInfo()
        );
        long end = System.currentTimeMillis();

        System.out.println((end - start));

    }

    public static DashboardInformation getDashboardInfo() throws InterruptedException {
        DashboardInformation information = new DashboardInformation();
        setFirstNumber(information);
        setSecondNumber(information);
        setThirdNumber(information);
        setFourthNumber(information);
        setFifthNumber(information);
        setSixthNumber(information);
        return information;
    }

    private static void setFirstNumber(DashboardInformation information) throws InterruptedException {
        int firstFieldWaitTime = ThreadLocalRandom.current().nextInt(500, 1500);
        System.out.println(
                "firstFieldWaitTime: " + firstFieldWaitTime
        );
        Thread.sleep(firstFieldWaitTime);
        information.setFirstNumber(
                ThreadLocalRandom.current().nextInt(10, 50)
        );
    }

    private static void setSecondNumber(DashboardInformation information) throws InterruptedException {
        int secondFieldWaitTime = ThreadLocalRandom.current().nextInt(2000, 3000);
        System.out.println(
                "secondFieldWaitTime: " + secondFieldWaitTime
        );
        Thread.sleep(secondFieldWaitTime);
        information.setSecondNumber(
                ThreadLocalRandom.current().nextInt(10, 50)
        );
    }

    private static void setThirdNumber(DashboardInformation information) throws InterruptedException {
        int thirdFieldWaitTime = ThreadLocalRandom.current().nextInt(2000, 3000);
        System.out.println(
                "thirdFieldWaitTime: " + thirdFieldWaitTime
        );
        Thread.sleep(thirdFieldWaitTime);
        information.setSecondNumber(
                ThreadLocalRandom.current().nextInt(10, 50)
        );
        Thread.sleep(
                ThreadLocalRandom.current().nextInt(500, 1500)
        );
        information.setThirdNumber(
                ThreadLocalRandom.current().nextInt(10, 50)
        );
    }

    private static void setFourthNumber(DashboardInformation information) throws InterruptedException {
        int fourthFieldWaitTime = ThreadLocalRandom.current().nextInt(100, 200);
        System.out.println(
                "fourthFieldWaitTime: " + fourthFieldWaitTime
        );
        Thread.sleep(fourthFieldWaitTime);
        Thread.sleep(
                ThreadLocalRandom.current().nextInt(500, 1500)
        );
        information.setFourthNumber(
                ThreadLocalRandom.current().nextInt(10, 50)
        );
    }

    private static void setFifthNumber(DashboardInformation information) throws InterruptedException {
        int fifthFieldWaitTime = ThreadLocalRandom.current().nextInt(400, 500);
        System.out.println(
                "fifthFieldWaitTime: " + fifthFieldWaitTime
        );
        Thread.sleep(fifthFieldWaitTime);
        Thread.sleep(
                ThreadLocalRandom.current().nextInt(500, 1500)
        );
        information.setFifthNumber(
                ThreadLocalRandom.current().nextInt(10, 50)
        );
    }

    private static void setSixthNumber(DashboardInformation information) throws InterruptedException {
        int sixthFieldWaitTime = ThreadLocalRandom.current().nextInt(100, 200);
        System.out.println(
                "sixthFieldWaitTime: " + sixthFieldWaitTime
        );
        Thread.sleep(sixthFieldWaitTime);
        Thread.sleep(
                ThreadLocalRandom.current().nextInt(500, 1500)
        );
        information.setSixthNumber(
                ThreadLocalRandom.current().nextInt(10, 50)
        );
    }


    private static class DashboardInformation {
        private int firstNumber;
        private int secondNumber;
        private int thirdNumber;
        private int fourthNumber;
        private int fifthNumber;
        private int sixthNumber;

        @Override
        public String toString() {
            return "DashboardInformation{" +
                    "firstNumber=" + firstNumber +
                    ", secondNumber=" + secondNumber +
                    ", thirdNumber=" + thirdNumber +
                    ", fourthNumber=" + fourthNumber +
                    ", fifthNumber=" + fifthNumber +
                    ", sixthNumber=" + sixthNumber +
                    '}';
        }

        public int getFirstNumber() {
            return firstNumber;
        }

        public void setFirstNumber(int firstNumber) {
            this.firstNumber = firstNumber;
        }

        public int getSecondNumber() {
            return secondNumber;
        }

        public void setSecondNumber(int secondNumber) {
            this.secondNumber = secondNumber;
        }

        public int getThirdNumber() {
            return thirdNumber;
        }

        public void setThirdNumber(int thirdNumber) {
            this.thirdNumber = thirdNumber;
        }

        public int getFourthNumber() {
            return fourthNumber;
        }

        public void setFourthNumber(int fourthNumber) {
            this.fourthNumber = fourthNumber;
        }

        public int getFifthNumber() {
            return fifthNumber;
        }

        public void setFifthNumber(int fifthNumber) {
            this.fifthNumber = fifthNumber;
        }

        public int getSixthNumber() {
            return sixthNumber;
        }

        public void setSixthNumber(int sixthNumber) {
            this.sixthNumber = sixthNumber;
        }
    }
}
