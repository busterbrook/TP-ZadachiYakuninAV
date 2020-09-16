package main2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);  
        System.out.print("Введите номер задачи(2 блок):");
        int num = sca.nextInt();
        switch (num){
          case 1:
//1 задача
        System.out.print("Введите строку: ");
        String str = sca.next();
        System.out.print("Число повторений каждого символа :  ");
        int n = sca.nextInt();
        String res1 = repeat(str, n);
        System.out.print(res1);
          break;
//2 задача
          case 2:
        System.out.print("Введите длинну массива: ");
        int size = sca.nextInt(); 
        double []array;
        array = crarr(size);
        double res2 = differenceMaxMin(array);
        System.out.println(res2);
            break;
//3 задача
          case 3:
        System.out.print("Введите длинну массива: ");
        int size3 = sca.nextInt();
        double []arr;
        arr = crarr(size3);
        String res3 = isAvgWhole(arr, size3);
        System.out.println(res3);
          break;
//4 задача
          case 4:
          System.out.print("Введите длинну массива: ");
          int size4 = sca.nextInt();
          double []arr2;
          arr2 = crarr(size4);
          double []arr1 = comulativeSum(arr2,size4);
          for (int i =0; i < arr1.length; i++){
            System.out.print(arr1[i] + ", ");
          }
          break;
//5 задача
          case 5:
          System.out.print("Введите число : ");
          float num5 = sca.nextFloat();
          float res5 = getDecimalPlaces(num5);
          System.out.println((int)res5);
          break;
//6 задача
          case 6:
          System.out.print("Введите число: ");
          int n6 = sca.nextInt();
          int res6 = Fibonacci(n6);
          System.out.println("Число фибоначи " + n6 +"= " + res6);
            break;
//7 задача
          case 7:
                String numbers = sca.next();
                String res7 = isValid(numbers);
                System.out.println(res7);
          break;
//8 задача
          case 8:
              System.out.print("Введите первую строку:");
              String num18 = sca.next();
              System.out.print("Введите вторую строку:");
              String num28 = sca.next();
              String res8 = isStrangePair(num18,num28);
              System.out.print(res8);
          break;
//9 задача
          case 9:
              System.out.print("Введите первую строку:");
              String num19 = sca.next();
              System.out.print("Введите вторую строку:");
              String num29 = sca.next();
              System.out.print("Выберите функцию: 1-isPrefix,2-isSuffix");
              int s9 = sca.nextInt();
              switch (s9){
                  case 1:
                  String res91 = isPrefix(num19,num29);
                  System.out.print(res91);
                  break;
                  case 2:
                  String res92 = isSuffix(num19,num29);
                  System.out.print(res92);
                  break;
              } 
          break;
//10 задача
          case 10:
          System.out.print("Введите шаг: ");
          int h1 = sca.nextInt();
          int res10 = boxSeq(h1);    
          System.out.println(res10);
          break;
          
          default: 
            System.out.println("Такой задачи в первом блоке нет!");
          break;
    }
}
    
    
    //Функции
    // Функция запонлнения массива
    public static double[] crarr(int size){
        Scanner sca1 = new Scanner(System.in);
        double [] array = new double[size];
        System.out.println("Введите массив: ");
        for (int i = 0; i < size; i++)
        {
            array[i] = sca1.nextInt(); 
        }
        return array;
    }
    
    //1 задача
    public static String repeat(String str, int n){
        String s = new String();
        for (int i = 0; i < str.length();i++){
            for (int j = 0; j < n ; j++){
                s = s + String.valueOf(str.charAt(i));
                }
            }
        return s;
        }
    //2 задача
    public static double differenceMaxMin(double [] str){
        double resMax = str[0];
        double resMin = str[0];
        double res;
        for (int i =0; i<str.length;i++){
            if (str[i]>=resMax){
                resMax = str[i];
            }else if (str[i]<=resMin){
                resMin = str[i];
            }
        }
        res = Math.abs(resMax-resMin);
        return res;
    }
    //3 задача
    public static String isAvgWhole(double []arr, int size){
        double m = 0;
        String res;
        for (int i = 0; i<size; i++){
            m += arr[i];
        }
        if(m%size == 0){
            return res = "true";
        }else{
            return res = "false";
        }
    }
    //4 задача
    public static double[] comulativeSum(double []arr,int size){
        double []arr1 = new double[size];
        double numm =0;
        arr1[0]=arr[0];
        for (int i = 1; i < size; i++){
            numm = numm + arr[i-1];
            arr1[i] = arr[i] + numm;
        }
        return arr1;
    }
    //5 задача
    public static float getDecimalPlaces(float a){
        float res5;
        res5 = ((int)(a*10))% 10;
        return res5;
    }
    
    // 6 задача
    public static int Fibonacci(int n){
        int fib;
        int fib1 =1,fib2=1;
        if (n<2){
            fib2 = 1;
        }
        for (int i = 3 ; i<n+2;i++){
            fib = fib1+fib2;
            fib1 = fib2;
            fib2 = fib;
        }
        return fib2;
    }
    
    //7 задача
    public static String isValid(String a){
        String res = "";
        char pr = ' ';
        if (a.length()>5){
            res = "false";
        }else{
//            char e = ' ';
        for (int i = 0; i < a.length(); i++){
//            e = (char)a.get(i);
            if(a.charAt(i) == (pr)){
                res = "false";
                break;
            }else if ((int)a.charAt(i) < 48 || (int)a.charAt(i) > 57) {
                     res = "false";
                     break;
              }else{
                res = "true";
            }
        }
        }
        return res;
    }
    //8 задача
    public static String isStrangePair(String a, String b){
        String res;
        if (a.charAt(0) == b.charAt(b.length()-1) && a.charAt(a.length()-1) == b.charAt(0)){
            res = "true";
        }else{
            res = "false";
        }
        return res;
    }
    // 9 задача
    public static String isPrefix(String a,String b){
        b = b.replace("-", "");
        if (a.startsWith(b) == true){
            return "true";
        }else{
            return "false";
        }
    }
    public static String isSuffix(String a, String b){
         b = b.replaceFirst("-", "");
         if (a.endsWith(b) == true){
             return "true";
         }else{
             return "false";
         }
    }   
    
    //10 задача
    public static int boxSeq(int h){
        int res = 0;
        if (h == 0){
            return res;
        }else{
        for (int i = 1; i <=h ;i++){
            if(i%2!=0){
                res += 3;
            }else{
                res -= 1;
            }
        }
        }
        return res;
    }
    
}
