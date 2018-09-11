package study.inno.sort;

class AssocSort implements BaseSort {
    public AssocSort() {
    }

    @Override
    public void sort(Integer[] aArray) throws IndexOutOfBoundsException, NullPointerException {

        if (aArray == null) throw new NullPointerException();
        else if (aArray.length == 0) throw new IndexOutOfBoundsException();

        int vArrSize = aArray.length, vVal, vBegin, vEnd, vPos, vLen;

        for (int i = 1; i < vArrSize; ++i) {
            //сортировка начинается со второго элемента
            //первый сам по себе уже является сортированным массивом

            //Ищем куда приткнуть имеющийся элемент в уже отсортированную часть массива
            //Поиск методом половинного деления
            vVal = aArray[i];
            vBegin = 0;
            vEnd = i - 1;
            while (vEnd != vBegin) {
                //Ищем середину отсортированной части
                vPos = (vBegin + vEnd) / 2;

                //Если текущий элемент меньше значения из середины, то ищем в левой половине
                //Если же элемент больше значения из середины, то ищем в правой половине
                if (vVal < aArray[vPos]) vEnd = vPos;
                else vBegin = vPos + 1;
            }

            //сузили поиск до одного элемента, и теперь
            //просто выбираем с какой стороны расположить текущий элемент
            vPos = vEnd;
            if (vVal >= aArray[vEnd]) ++vPos;
            if (vPos == i) continue; //элемент уже на своём месте
            vLen = i - vPos;

            System.arraycopy(aArray, vPos, aArray, vPos + 1, vLen);
            aArray[vPos] = vVal;
        }
    }
}
