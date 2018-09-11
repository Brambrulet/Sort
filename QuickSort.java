package study.inno.sort;

public class QuickSort implements BaseSort {
    @Override
    public void sort(Integer[] aArray) throws IndexOutOfBoundsException, NullPointerException {
        if (aArray == null) throw new NullPointerException();
        else if (aArray.length == 0) throw new IndexOutOfBoundsException();

        qSort(aArray, 0, aArray.length - 1);

    }

    private void qSort(Integer[] aArray, int aBegin, int aEnd) {
        int vBegin = aBegin, vEnd = aEnd;
        //Не стал заморачиваться с опорным элементом, взял из середины ... как в институте учили
        int vPivot = aArray[(aBegin + aEnd) / 2];

        while (vBegin <= vEnd) {

            //Ищем значения для перестановки
            while (vBegin < aEnd && aArray[vBegin] < vPivot) ++vBegin;
            while (aBegin < vEnd && aArray[vEnd] > vPivot) --vEnd;

            //Если есть что менять
            if (vBegin <= vEnd) {
                //меняем элементы
                Integer vTemp = aArray[vBegin];
                aArray[vBegin] = aArray[vEnd];
                aArray[vEnd] = vTemp;

                //Переходим к следующим позициям
                ++vBegin;
                --vEnd;
            }
        }

        //На текущий момент порядка в массиве прибавилось -
        //каждый из элементов из левой половины меньше любого элемента из правой половины
        //Теперь нужно аналогично навести порядок в каждой из половинок ... а потом в четвертинках ... в восьмушках ...
        //И оно само глядишь и отсортируется :)
        if (aBegin < vEnd) qSort(aArray, aBegin, vEnd);
        if (vBegin < aEnd) qSort(aArray, vBegin, aEnd);
    }
}
