package ua.com.alevel.mathset;

import java.math.BigDecimal;

public class MathSet {

    private Number[] fSet;
    private Integer capacity;
    private final int DEFAULT_CAPACITY_INCREASE = 10;

    public MathSet() {
        fSet = new Number[DEFAULT_CAPACITY_INCREASE];
    }

    public MathSet(int capacity) {
        this.capacity = capacity;
        fSet = new Number[capacity];
    }

    public MathSet(Number[]... numbers) {
        fSet = new Number[DEFAULT_CAPACITY_INCREASE];
        for (Number[] arrNum : numbers) {
            for (Number number : arrNum) {
                add(number);
            }
        }
    }

    public MathSet(MathSet... ms) {
        fSet = new Number[DEFAULT_CAPACITY_INCREASE];
        for (MathSet m : ms) {
            Number[] arrNum = m.toArray();
            for (Number number : arrNum) {
                add(number);
            }
        }
    }

    public void join(MathSet... ms) {
        for (MathSet m : ms) {
            Number[] arrNum = m.toArray();
            for (Number number : arrNum) {
                add(number);
            }
        }
    }

    public void intersection(MathSet... ms) {
        for (MathSet m : ms) {
            String intersectionStr = "";
            Number[] arrNum = m.toArray();
            for (Number number : fSet) {
                for (Number value : arrNum) {
                    if (number != null && value != null) {
                        if (compareTo(number, value) == 0) {
                            intersectionStr += value + " ";
                        }
                    }
                }
            }

            String[] partTimeFSetStr = intersectionStr.split(" ");
            Number[] partTimeFSetNum = new Number[partTimeFSetStr.length];
            for (int j = 0; j < partTimeFSetStr.length; j++) {
                double partTimeDouble = Double.parseDouble(partTimeFSetStr[j]);
                BigDecimal decMember = new BigDecimal(partTimeDouble);
                partTimeFSetNum[j] = decMember;
            }

            fSet = new MathSet(partTimeFSetNum).toArray();
        }
    }

    public void add(Number... vals) {
        for (Number val : vals) {
            boolean isExist = false;
            boolean isFreeSpace = false;
            int freeIndex = -1;
            for (int i = 0; i < fSet.length; i++) {
                if (fSet[i] != null) {
                    if (val == null) {
                        continue;
                    }
                    if (compareTo(fSet[i], val) == 0) {
                        isExist = true;
                    }
                } else {
                    isFreeSpace = true;
                    if (freeIndex == (-1)) {
                        freeIndex = i;
                    }
                }
            }
            if (!isExist) {
                if (isFreeSpace) {
                    fSet[freeIndex] = val;
                } else {
                    if (capacity == null) {
                        int memoryIndex = fSet.length;
                        fSetIncrease();
                        fSet[memoryIndex] = val;
                    }
                }
            }
        }
    }

    public void sortDesc() {
        fSort(1, fSet.length, true);
    }

    public void sortDesc(Number value) {
        for (int i = 0; i < fSet.length; i++) {
            if (fSet[i] != null) {
                if (compareTo(fSet[i], value) == 0) {
                    fSort(i + 2, fSet.length, true);
                }
            }
        }
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if((firstIndex > fSet.length || fSet[firstIndex] == null) || (lastIndex > fSet.length || fSet[lastIndex] == null)) {
            System.out.println("Введенны неверные индексы");
            return;
        }
        fSort(firstIndex, lastIndex, true);
    }

    public void sortAsc() {
        fSort(1, fSet.length, false);
    }

    public void sortAsc(Number value) {
        for (int i = 0; i < fSet.length; i++) {
            if (fSet[i] != null) {
                if (compareTo(fSet[i], value) == 0) {
                    fSort(i + 2, fSet.length, false);
                }
            }
        }
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if((firstIndex > fSet.length || fSet[firstIndex] == null) || (lastIndex > fSet.length || fSet[lastIndex] == null)) {
            System.out.println("Введенны неверные индексы");
            return;
        }
        fSort(firstIndex, lastIndex, false);
    }

    public Number get(int index) {
        if (index > fSet.length || fSet[index] == null) {
            System.out.println("Введён неверный индекс");
            return null;
        }
        return fSet[index];
    }

    public Number getMax() {
        Number max = fSet[0];
        for (Number number : fSet) {
            if (number != null) {
                if (compareTo(number, max) == 1) {
                    max = number;
                }
            }
        }
        return max;
    }

    public Number getMin() {
        Number min = fSet[0];
        for (Number number : fSet) {
            if (number != null) {
                if (compareTo(number, min) == -1) {
                    min = number;
                }
            }
        }
        return min;
    }

    public Number getAverage() {
        Double average = 0.0;
        int trueSize = 0;
        for (Number number : fSet) {
            if (number != null) {
                trueSize += 1;
                average += number.doubleValue();
            }
        }

        average = average / trueSize;
        BigDecimal decAverage = new BigDecimal(average);
        return (Number) decAverage;
    }

    public Number getMedian() {
        sortDesc();
        double median = 0.0;
        Number[] cleanfSet = fToArray(0, fSet.length, false);
        if (cleanfSet.length % 2 == 0) {
            median = cleanfSet[cleanfSet.length / 2].doubleValue() + cleanfSet[cleanfSet.length / 2 + 1].doubleValue() / 2;
        } else {
            median = cleanfSet[cleanfSet.length / 2].doubleValue();
        }
        return median;
    }

    public Number[] toArray() {
        return fToArray(0, fSet.length, false);
    }

    public Number[] toArray(int fInd, int lInd) {
        if((fInd > fSet.length || fSet[fInd] == null) || (lInd > fSet.length || fSet[lInd] == null)) {
            System.out.println("Введенны неверные индексы");
            return null;
        }
        return fToArray(fInd, lInd, true);
    }

    public MathSet cut(int fInd, int lInd) {
        if((fInd > fSet.length || fSet[fInd] == null) || (lInd > fSet.length || fSet[lInd] == null)) {
            System.out.println("Введенны неверные индексы");
            return null;
        }
        MathSet retMathSet = new MathSet(toArray(fInd, lInd));
        return retMathSet;
    }

    public void clear() {
        for (int i = 0; i < fSet.length; i++) {
            fSet[i] = null;
        }
    }

    public void clear(Number[] numbers) {
        for (int i = 0; i < fSet.length; i++) {
            for (Number number : numbers) {
                if (fSet[i] != null) {
                    if (compareTo(fSet[i], number) == 0) {
                        fSet[i] = null;
                        break;
                    }
                }
            }
        }
        nullPermutation();
    }

    private Number[] fToArray(int fInd, int lInd, boolean selective) {
        if (selective) {
            lInd += 1;
        }
        int retArrSize = lInd - fInd;
        Number[] tmpAutArr = new Number[retArrSize];
        int index = 0;
        int trueSize = 0;
        for (int i = fInd; i < lInd; i++) {
            tmpAutArr[index] = fSet[i];
            index += 1;
        }
        for (Number number : tmpAutArr) {
            if (number != null) {
                trueSize += 1;
            } else {
                break;
            }
        }
        Number[] autArr = new Number[trueSize];
        System.arraycopy(tmpAutArr, 0, autArr, 0, autArr.length);
        return autArr;
    }

    private int compareTo(Number n1, Number n2) {
        BigDecimal b1 = new BigDecimal(n1.doubleValue());
        BigDecimal b2 = new BigDecimal(n2.doubleValue());
        return b1.compareTo(b2);
    }

    @Override
    public String toString() {
        String fSetToStr = "";
        for (Number number : fSet) {
            if (number != null) {
                fSetToStr += number.toString() + " ";
            }
        }
        return fSetToStr;
    }

    private void fSetIncrease() {
        Number[] partTimeFSet = fSet;
        fSet = new Number[partTimeFSet.length + DEFAULT_CAPACITY_INCREASE];
        System.arraycopy(partTimeFSet, 0, fSet, 0, partTimeFSet.length);
    }

    private void fSort(int firstIndex, int lastIndex, boolean way) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = firstIndex; i < lastIndex; i++) {
                if (fSet[i] != null) {
                    if (way) {
                        if (fSet[i].doubleValue() < fSet[i - 1].doubleValue()) {
                            replace(i, i - 1);
                            needIteration = true;
                        }
                    } else {
                        if (fSet[i].doubleValue() > fSet[i - 1].doubleValue()) {
                            replace(i, i - 1);
                            needIteration = true;
                        }
                    }
                }
            }
        }
    }

    private void replace(int fInd, int lInd) {
        Number partTime = fSet[fInd];
        fSet[fInd] = fSet[lInd];
        fSet[lInd] = partTime;
    }

    private void nullPermutation() {
        for (int i = 0; i < fSet.length; i++) {
            if (fSet[i] == null) {
                for (int j = i + 1; j < fSet.length; j++) {
                    if (fSet[j] != null) {
                        fSet[i] = fSet[j];
                        fSet[j] = null;
                        break;
                    }
                }
            }
        }
    }
}