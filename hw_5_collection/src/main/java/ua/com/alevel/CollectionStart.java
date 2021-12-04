package ua.com.alevel;

import ua.com.alevel.mathset.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionStart {

    static Map<Integer, MathSet> mathSetMap = new LinkedHashMap<>();
    static Map<Integer, Number[]> numberMap = new LinkedHashMap<>();
    static int indexMap = 0;
    static int indexArr = 0;

    public static void main(String[] args) {
        sayHello();
        run();
    }

    public static void run() {
        printMap();
        System.out.println("Ваш выбор:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String taskNum = null;
        try {
            taskNum = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (Integer.parseInt(taskNum)) {
            case 1: {
                try {
                    System.out.println("Введите массив Number через пробел:");
                    String numbersStr = reader.readLine();
                    String[] numbersArr = numbersStr.split(" ");
                    Number[] numArr = new Number[numbersArr.length];
                    for (int i = 0; i < numArr.length; i++) {
                        numArr[i] = new BigDecimal(Double.parseDouble(numbersArr[i].trim()));
                    }
                    numberMap.put(indexArr, numArr);
                    indexArr += 1;
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 2: {
                MathSet mathSet = new MathSet();
                mathSetMap.put(indexMap, mathSet);
                indexMap += 1;
                run();
                break;
            }

            case 3: {
                try {
                    System.out.println("Введите capacity:");
                    String capacity = reader.readLine();
                    MathSet mathSet = new MathSet(Integer.parseInt(capacity.trim()));
                    mathSetMap.put(indexMap, mathSet);
                    indexMap += 1;
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }

            }

            case 4: {
                try {
                    System.out.println("Укажите через запятую, какие массивы вы хотите добавить:");
                    String arrays = reader.readLine();
                    String[] arrayNumsStr = arrays.split(",");
                    int maxLength = 0;
                    for (String s : arrayNumsStr) {
                        if (numberMap.get(Integer.parseInt(s.trim())).length > maxLength) {
                            maxLength = numberMap.get(Integer.parseInt(s.trim())).length;
                        }
                    }
                    Number[][] mathNum = new Number[arrayNumsStr.length][maxLength];
                    for (int i = 0; i < arrayNumsStr.length; i++) {
                        Number[] nums = numberMap.get(Integer.parseInt(arrayNumsStr[i].trim()));
                        System.arraycopy(nums, 0, mathNum[i], 0, nums.length);
                    }
                    MathSet mathSet = new MathSet(mathNum);
                    mathSetMap.put(indexMap, mathSet);
                    indexMap += 1;
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 5: {
                try {
                    System.out.println("Укажите через пробел, какие MathSet вы хотите добавить:");
                    String arrays = reader.readLine();
                    String[] arrayNumsStr = arrays.split(" ");
                    MathSet[] mathSets = new MathSet[arrayNumsStr.length];
                    for (int i = 0; i < arrayNumsStr.length; i++) {
                        mathSets[i] = mathSetMap.get(Integer.parseInt(arrayNumsStr[i].trim()));
                    }
                    MathSet mathSet = new MathSet(mathSets);
                    mathSetMap.put(indexMap, mathSet);
                    indexMap += 1;
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 6: {
                try {
                    System.out.println("Выберите коллекцию с которой вы хотите объединить:");
                    String index = reader.readLine();
                    System.out.println("Укажите через пробел, какие MathSet вы хотите объединить:");
                    String arrays = reader.readLine();
                    String[] arrayNumsStr = arrays.split(" ");
                    MathSet[] mathSets = new MathSet[arrayNumsStr.length];
                    for (int i = 0; i < arrayNumsStr.length; i++) {
                        mathSets[i] = mathSetMap.get(Integer.parseInt(arrayNumsStr[i].trim()));
                    }
                    mathSetMap.get(Integer.parseInt(index)).join((mathSets));
                    System.out.println(mathSetMap.get(Integer.parseInt(index)));
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 7: {
                try {
                    System.out.println("Выберите коллекцию с которой вы хотите сделать пересечение:");
                    String index = reader.readLine();
                    System.out.println("Укажите через пробел, из каких MathSet вы хотите сделать пересечение:");
                    String arrays = reader.readLine();
                    String[] arrayNumsStr = arrays.split(" ");
                    MathSet[] mathSets = new MathSet[arrayNumsStr.length];
                    for (int i = 0; i < arrayNumsStr.length; i++) {
                        mathSets[i] = mathSetMap.get(Integer.parseInt(arrayNumsStr[i].trim()));
                    }
                    mathSetMap.get(Integer.parseInt(index)).intersection((mathSets));
                    System.out.println(mathSetMap.get(Integer.parseInt(index)));
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 8: {
                try {
                    System.out.println("Выберите коллекцию в которую надо добавить элемент:");
                    String index = reader.readLine();
                    System.out.println("Укажите через запятую, какие элементы добавлять:");
                    String member = reader.readLine();
                    String[] membersArr = member.split(" ");
                    Number[] numberArr = new Number[membersArr.length];
                    for (int i = 0; i < numberArr.length; i++) {
                        BigDecimal b1 = new BigDecimal(Double.parseDouble(membersArr[i].trim()));
                        numberArr[i] = b1;
                    }
                    mathSetMap.get(Integer.parseInt(index)).add(numberArr);
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 9: {
                try {
                    System.out.println("Выберите коллекцию которую надо отсортировать по возрастанию:");
                    String index = reader.readLine();
                    mathSetMap.get(Integer.parseInt(index)).sortDesc();
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 10: {
                try {
                    System.out.println("Выберите коллекцию которую надо отсортировать по возрастанию:");
                    String index = reader.readLine();
                    System.out.println("Выберите число начиная от которого начинать сотсортировать:");
                    String val = reader.readLine();
                    mathSetMap.get(Integer.parseInt(index)).sortDesc(new BigDecimal(Double.parseDouble(val)));
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 11: {
                try {
                    System.out.println("Выберите коллекцию которую надо отсортировать по возрастанию:");
                    String index = reader.readLine();
                    System.out.println("Выберите индекс начиная от которого начинать сотсортировать:");
                    String indexStart = reader.readLine();
                    System.out.println("Выберите индекс до которого сотсортировать:");
                    String indexEnd = reader.readLine();
                    mathSetMap.get(Integer.parseInt(index)).sortDesc(Integer.parseInt(indexStart), Integer.parseInt(indexEnd));
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 12: {
                try {
                    System.out.println("Выберите коллекцию которую надо отсортировать по убыванию:");
                    String index = reader.readLine();

                    mathSetMap.get(Integer.parseInt(index)).sortAsc();
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 13: {
                try {
                    System.out.println("Выберите коллекцию которую надо отсортировать по убыванию:");
                    String index = reader.readLine();
                    System.out.println("Выберите число начиная от которого начинать сотсортировать:");
                    String val = reader.readLine();
                    mathSetMap.get(Integer.parseInt(index)).sortAsc(new BigDecimal(Double.parseDouble(val)));
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 14: {
                try {
                    System.out.println("Выберите коллекцию которую надо отсортировать по убывани:");
                    String index = reader.readLine();
                    System.out.println("Выберите индекс начиная от которого начинать сотсортировать:");
                    String indexStart = reader.readLine();
                    System.out.println("Выберите индекс до которого сотсортировать:");
                    String indexEnd = reader.readLine();
                    mathSetMap.get(Integer.parseInt(index)).sortAsc(Integer.parseInt(indexStart), Integer.parseInt(indexEnd));
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 15: {
                try {
                    System.out.println("Выберите коллекцию которую из которой хотите получить элемент:");
                    String index = reader.readLine();
                    System.out.println("Выберите индекс :");
                    String indexEl = reader.readLine();
                    System.out.println("Ваш элемент - " + mathSetMap.get(Integer.parseInt(index)).get(Integer.parseInt(indexEl)));
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 16: {
                try {
                    System.out.println("Выберите коллекцию из которой хотите получить максимальный элемент:");
                    String index = reader.readLine();
                    System.out.println("Ваш максимальный элемент - " + mathSetMap.get(Integer.parseInt(index)).getMax());
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 17: {
                try {
                    System.out.println("Выберите коллекцию из которой хотите получить минимальный элемент:");
                    String index = reader.readLine();
                    System.out.println("Ваш минимальный элемент - " + mathSetMap.get(Integer.parseInt(index)).getMin());
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 18: {
                try {
                    System.out.println("Выберите коллекцию из которой хотите получить среднее арифметическое:");
                    String index = reader.readLine();
                    System.out.println("Ваш среднее арифметическое - " + mathSetMap.get(Integer.parseInt(index)).getAverage());
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 19: {
                try {
                    System.out.println("Выберите коллекцию из которой хотите получить медиану:");
                    String index = reader.readLine();
                    System.out.println("Ваша медиана - " + mathSetMap.get(Integer.parseInt(index)).getMedian());
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 20: {
                try {
                    System.out.println("Выберите коллекцию из которой хотите получить массив:");
                    String index = reader.readLine();
                    Number[] numArr = mathSetMap.get(Integer.parseInt(index)).toArray();
                    System.out.print("Ваш массив: ");
                    for (int i = 0; i < numArr.length; i++) {
                        System.out.print(numArr[i] + " ");
                    }
                    System.out.println();
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 21: {
                try {
                    System.out.println("Выберите коллекцию из которой хотите получить выборочный массив:");
                    String index = reader.readLine();
                    System.out.println("Выберите индекс начиная от которого вы хотите получить массив:");
                    String indexStart = reader.readLine();
                    System.out.println("Выберите индекс до которого вы хотите получить массив:");
                    String indexEnd = reader.readLine();
                    Number[] numArr = mathSetMap.get(Integer.parseInt(index)).toArray(Integer.parseInt(indexStart), Integer.parseInt(indexEnd));
                    System.out.print("Ваш массив: ");
                    for (Number number : numArr) {
                        System.out.print(number + " ");
                    }
                    System.out.println();
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 22: {
                try {
                    System.out.println("Выберите коллекцию из которой вы хотите получить кусочек:");
                    String index = reader.readLine();
                    System.out.println("Выберите индекс начиная от которого вы хотите получить массив:");
                    String indexStart = reader.readLine();
                    System.out.println("Выберите индекс до которого вы хотите получить массив:");
                    String indexEnd = reader.readLine();
                    mathSetMap.put(indexMap, mathSetMap.get(Integer.parseInt(index)).cut(Integer.parseInt(indexStart), Integer.parseInt(indexEnd)));
                    indexMap += 1;
                    System.out.print("Ваш массив: ");
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 23: {
                try {
                    System.out.println("Выберите коллекцию хотите очистить:");
                    String index = reader.readLine();
                    mathSetMap.get(Integer.parseInt(index)).clear();
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 24: {
                try {
                    System.out.println("Выберите коллекцию из которой хотите удалить массив чисел: ");
                    String index = reader.readLine();
                    System.out.println("Выберите массив значения которого будут удалены из коллекции: ");
                    String arrNum = reader.readLine();
                    mathSetMap.get(Integer.parseInt(index)).clear(numberMap.get(Integer.parseInt(arrNum)));
                    run();
                    break;
                } catch (Exception ex) {
                    System.out.println("В " + taskNum + " задании что-то пошло не так повторите попытку");
                    run();
                }
            }

            case 0: {
                System.exit(0);
            }

        }
    }

    public static void printMap() {
        System.out.println("Существующие MathSet:");
        mathSetMap.entrySet().stream().forEach(System.out::println);
        System.out.println("Созданные массивы Number:");
        for (Map.Entry<Integer, Number[]> pair : numberMap.entrySet()) {
            System.out.print(pair.getKey() + " = ");
            Number[] num = pair.getValue();
            for (Number number : num) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static void sayHello() {
        String hello =
                "0 - Выход\n"+
                "1 - Создать массив Number\n" +
                "2 - Создать об. этой коллекции MathSet()\n" +
                "3 - Создать об. этой коллекции MathSet(int capacity)\n" +
                "4 - Создать об. этой коллекции MathSet(Number[]... numbers) / MathSet(Number[]... numbers)\n" +
                "5 - Создать об. этой коллекции MathSet(MathSet... ms) / MathSet(MathSet ms)\n" +
                "6 - Сделать операцию объединение  join(MathSet... ms) / join(MathSet ms)\n" +
                "7 - Сделать операцию пересечение  intersection(MathSet... ms) / intersection(MathSet ms)\n" +
                "8 - Добавить об. к об. коллекции add(Number... vals) / add(Number vals)\n" +
                "9 - Отсортировать коллекцию sortDesc()\n" +
                "10 - Отсортировать коллекцию sortDesc(Number value)\n" +
                "11 - Отсортировать коллекцию sortDesc(int firstIndex, int lastIndex)\n" +
                "12 - Отсортировать коллекцию sortAsc()\n" +
                "13 - Отсортировать коллекцию sortAsc(Number value)\n" +
                "14 - Отсортировать коллекцию sortAsc(int firstIndex, int lastIndex)\n" +
                "15 - Получить элемент по индексу get(int index)\n" +
                "16 - Получить максимальный элемент коллекции getMax()\n" +
                "17 - Получить минимальный элемент коллекции getMin()\n" +
                "18 - Получить среднее арифметическое getAverage()\n" +
                "19 - Получить медиану getMedian()\n" +
                "20 - Получить массив toArray()\n" +
                "21 - Получить массив по индексам toArray(int fInd, int lInd)\n" +
                "22 - Вырезать кусочек cut(int fInd, int lInd)\n" +
                "23 - Очистить  всю коллекцию clear()\n" +
                "24 - Убрать из коллекции заданные позиции clear(Number[] numbers)\n";
        System.out.println(hello);
        System.out.println();
    }
}