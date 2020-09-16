package main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.print("Введите номер задачи:");
        int num = sca.nextInt();
        switch (num){
            case 1:
                System.out.println("Введите два числа:");
                float a1 = sca.nextFloat();
                float b1 = sca.nextFloat();
                float res1 = remainder(a1,b1);
                System.out.println(res1);
            break;
            
            case 2:
                System.out.println("Введите два числа:");
                float a2 = sca.nextFloat();
                float b2 = sca.nextFloat();
                float res2 = triArea(a2,b2);
                System.out.println(res2);
            break;
            
            case 3:
                System.out.println("Введите три числа:");
                float a3 = sca.nextFloat();
                float b3 = sca.nextFloat();
                float c3 = sca.nextFloat();
                float res3 = animals(a3,b3,c3);
                System.out.println(res3);
            break;
            
            case 4:
                System.out.println("Введите три числа:");             
                float a4 = sca.nextFloat();
                float b4 = sca.nextFloat();
                float c4 = sca.nextFloat();
                String res4 = profitableGamble(a4,b4,c4);
                System.out.println(res4);  
            break;
            
            case 5:
                System.out.println("Введите три числа:");  
                float a5 = sca.nextFloat();
                float b5 = sca.nextFloat();
                float c5 = sca.nextFloat();
                String res5 = operation(a5,b5,c5);
                System.out.println(res5);
            break;
            
            case 6:
                System.out.print("Введите символ:");
                String sym = sca.next();
                int res6 = ctoa(sym);
                System.out.println(res6);
            break;
            
            case 7:    
                List<Integer> numbers = new ArrayList<>();
                System.out.print("Введите размер списка: ");
                int n = sca.nextInt();
                System.out.println("Заполните список");
                for (int i=0; i<n; i++)
                {
                    int s = sca.nextInt();
                    numbers.add(i, s);
                }
                int res7 = addUpTo(numbers,n);
                System.out.println(res7);
            break;
            
            case 8:
                System.out.println("Введите два числа: ");
                int a = sca.nextInt();
                int b = sca.nextInt();
                double res8 = nextEdge(a,b);
                System.out.println(res8);
            break;
            
            case 9:
                System.out.print("Введите длинну массива: ");
                int size = sca.nextInt(); 
                double [] array = new double[size];
                System.out.println("Введите массив: ");
                for (int i = 0; i < size; i++)
                {
                    array[i] = sca.nextInt(); 
                }
                double res9 = sumOfCubes(array);
                System.out.println(res9);
            break;
            
            case 10:
                System.out.println("Введите три числа: ");
                float a10 = sca.nextFloat();
                float b10 = sca.nextFloat();
                float c10 = sca.nextFloat();
                String res10 = adcmath(a10,b10,c10);
                System.out.println(res10);
            break;
            
            default: 
                System.out.println("Такой задачи в первом блоке нет!");
            break;
        }          
    }
    
    public static float remainder(float a, float b){
        float res = a%b;
        return res;
    } 
    
    public static float triArea(float a, float b){
        float res = (a*b)/2;
        return res;
    } 
    
    public static float animals(float a, float b, float c){
        float res = a * 2 + b * 4 + c * 4;
        return res;
    } 
    
    public static String profitableGamble(float prob, float prize, float pay){
        String res;
        if (prob * prize > pay){
            res = "True";
            return res;
        }else{
            res = "False";
            return res;
        }
    } 
    
    public static String operation(float N, float a, float b){
        String res;
        if (a+b==N || b+a==N)
        {
            res = "added";
            return res;        
        }
        else if (a-b == N || b-a==N)
        {
            res = "subtracted";
            return res; 
        }
        else if (a*b == N || b*a==N)
        {
            res = "multiple";
            return res; 
        }
        else if(a/b == N || b/a==N)
        {
            res = "split";
            return res; 
        }
        else
        {
            res = "none";
            return res; 
        }
    }
    
    public static int ctoa(String sym){
        char character = sym.charAt(0); 
          int ascii = (int) character;
          return ascii;
    } 
    
    public static int addUpTo(List a,int n){
        List<Integer> numbers1 = new ArrayList<>();
        numbers1 = a;
        int e = numbers1.get(n-1);
        int c = 0;
        for (int i = 1; i <= e ; i++){
            c += i;
        }
        return c;
        
        
    } 
    
    public static double nextEdge(int a, int b){
        double res = 0;
        double res1 = 0;
        for (int i = 0; i < 180; i ++){
            res1 = Math.sqrt(b*b + a*a - 2*b*a * Math.cos(i));
                if (res1 > res){
                    res = res1;
                }   
        }
        return (int)res;
    } 
    
    public static double sumOfCubes(double [] arr){
        double cub = 0;
        for (int i=0;i<arr.length;i++){
                cub += Math.pow(arr[i], 3); 
        } 
        return cub;
        
    } 
    
    public static String adcmath(float a, float b, float c){
        String res;
        if ((a*b) % c == 0)
        {
            res = "true";
            return res;
        }else
        {
           res = "false";
            return res;
        } 
          
    } 
        
        
}
