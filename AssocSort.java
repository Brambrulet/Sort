package study.inno.sort;

class AssocSort implements BaseSort {
    public AssocSort() {
    }

    @Override
    public boolean sort(int[] aArray) {

        if (aArray == null || aArray.length == 0) return false;

        int vArrSize = aArray.length, vVal, vBegin, vEnd, vPos, vLen;

        for (int i = 1; i < vArrSize; ++i) {
            //сортировка начинается со второго элемента
            //первый сам по себе уже является сортированным массивом

            //Ищем куда приткнуть имеющийся элемент в уже отсортированный массив
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

            //если у нас остался в отсортированной части только один элемент на выбор
            //то просто выбираем с какой стороны расположить текущий элемент
            vPos = vEnd;
            if (vVal >= aArray[vEnd]) ++vPos;
            if (vPos == i) continue;
            vLen = i - vPos;

            if (vLen > 0) {
                System.arraycopy(aArray, vPos, aArray, vPos + 1, vLen);
                aArray[vPos] = vVal;
            }
            //если условие не прокатило, то элемент уже на своём месле

        }

        return true;
    }
}
