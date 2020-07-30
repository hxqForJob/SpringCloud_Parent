import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int [] num={23,45,2,-9,6,-89};
        //插入排序
//        for (int i = 1; i < num.length; i++) {
//            int insertVal = num[i];
//            int insertIndex=i-1;
//            while (insertIndex>=0&&num[insertIndex]>insertVal){
//                num[insertIndex+1]=num[insertIndex];
//                insertIndex--;
//            }
//            if(insertIndex+1!=i){
//                num[insertIndex+1]=insertVal;
//            }
//
//        }
        //希尔排序
        for (int i = num.length/2; i >0;i=i/2) {
            for (int j = i; j < num.length; j++) {
                int indexVal = num[j];
                int index=j-i;
                while (index>=0&&num[index]>indexVal){
                    num[index+i]=num[index];
                    index=index-i;
                }
                if(index+i!=j){
                    num[index+i]=indexVal;
                }
            }

        }
        System.out.println(Arrays.toString(num));
    }
}
