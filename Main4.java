package main4;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class Main4 {
    public static void main(String[] args) {
    Scanner sca = new Scanner(System.in);  
    System.out.print("Введите номер задачи: ");
    int num = sca.nextInt();
    switch(num){
    case 1:
    //задача 1
    System.out.print("Введите колличество слов: ");
    int n = sca.nextInt();
    System.out.print("Введите размер стровки: ");
    int k = sca.nextInt();
    System.out.print("Введите предложение: ");
    sca.nextLine();
    String str1 = sca.nextLine();    
    if((1 > n && n > 100 )|| (1 > k && k > 80 )){
        System.out.println("Введите другие значения n и k");
    }else{
       System.out.println(fourSix(n,k,str1));
        
    }
    break;
        
    case 2:
    //задача 2
    System.out.println("Введите  строку скобок: ");
    String str2  = sca.nextLine();
    String res2 = split(str2);
    System.out.println(res2);
    break;
    
    case 3:
    //задача 3
    System.out.print("Введите строку:");
    String str3 = sca.next();
    String res3 = "";
    System.out.println("1 - toCamelCase");
    System.out.println("2 - toSnakeCase");
    int v3 = sca.nextInt();
    switch (v3){
        case 1:
        res3 = toCamelCase(str3);
        break;
        case 2:
        res3 = toSnakeCase(str3);
        break;
        default: 
                System.out.println("Такой функции нет в данной задаче!");
            break;
    }
    System.out.println(res3);
    break;
    
    case 4:
    //задача 4
    double [] x = new double[]{};
    int size4 = 4;
    x = crarr(size4);
    double res4 = overTime(x);
    System.out.print("$" + res4 + "0");
    break;
    
    case 5:
    //задача 5
    System.out.print("Введиет вес:");
    float v1 = sca.nextFloat();
    System.out.print("Еденица изверения веса:");
    String v2 = sca.next();
    System.out.print("Введиет рос:");
    float r1 = sca.nextFloat();
    System.out.print("Еденица измерение роста:");
    String r2 = sca.next();
    String res5 = BMI(v1,v2,r1,r2);
    System.out.println(res5);
    break;
    
    case 6:
    //задача 6
    System.out.print("Введите число: ");
    int num6 = sca.nextInt();
    int res6 = bugger(num6);
    System.out.println(res6);
    break;
    
    case 7:
    //задача 7
    System.out.print("Введите строку: ");
    String str7 = sca.nextLine();
    String res7 = toStarShorthand(str7);
    System.out.println(res7);
    break;
    
    case 8:
    //задача 8
    System.out.print("Введите 1 строку: ");
    String s81 = sca.nextLine();
    System.out.print("Введите 2 строку: ");
    String s82 = sca.nextLine();
    String res8 = doesRhyme(s81,s82);
    System.out.println("Результат: " + res8);
    break;
    
    case 9:
    //задача 9
    System.out.print("Введите первое число: ");
    BigInteger num1 = sca.nextBigInteger();
    System.out.print("Введите второе число: ");
    BigInteger num2 = sca.nextBigInteger();
    String res9 = trouble(num1.intValue(), num2.intValue());
    System.out.print(res9);
    break;
    
    case 10:
    //задача 10
    System.out.print("Введите строку: ");
    String str10 = sca.next();
    System.out.print("Введите сивмол: ");
    String sim = sca.next();
    int res10 = countUniqueBooks(str10,sim);
    System.out.println(res10);
    break;
    
    default: 
        System.out.println("Такой задачи в первом блоке нет!");
    break;
    }
    }
    
    //функция заполнающая массив
    public static double[] crarr(int size){
        Scanner sca1 = new Scanner(System.in);
        double [] array = new double[size];
        System.out.println("Введите массив: ");
        for (int i = 0; i < size; i++)
        {
            array[i] = sca1.nextDouble(); 
        }
        return array;
    }
    
    //задача 1
    public static String fourSix(int n, int k,String s) {
    StringBuilder Text = new StringBuilder();
    StringBuilder Line = new StringBuilder();
    String[] words = s.split(" ");
    k+=1;
    for (int i = 0; i < n; i++) {
        Line.append(words[i]).append(" ");
        if (i+1 == n || Line.length() + words[i+1].length() > k) {
            Line.deleteCharAt(Line.length() - 1);
            Text.append(Line.toString()).append(System.lineSeparator());
            Line = new StringBuilder();
        }
    }
    return Text.toString();
    }
        
    //задача 2
    public static String split(String str2){
        String res2 = "";
        int open = 0;
        int close = 0;
        for(int i = 0; i < str2.length()-1; i++){
            if(str2.charAt(i) == '('){
                open+=1;
                res2+=str2.charAt(i);
            }else if (str2.charAt(i) == ')'){
                close+=1;
                res2+=str2.charAt(i);
            }
            if(open == close)
                res2+=", ";
            
        }
        return res2 + ")";
    }
    
    //задача 3
    public static String toCamelCase(String str3){
        String res3 = "";
        int start;
        int end;
        for(int i = 0; i < str3.length() - 1; i++){
            if((int)str3.charAt(i) == 95){
               start = i + 1;
               end = i + 2;
               str3 = str3.substring(0,start) + str3.substring(start,end).toUpperCase() + str3.substring(end).toLowerCase();
               
            }
        }
        res3 = str3.replace("_", "");
        return res3;
    }
    
    public static String toSnakeCase(String str3){
        String res3 = "";
        String pr = "_";
        int start;
        int end;
        for(int i = 0; i < str3.length() - 1; i++){
            if((int)str3.charAt(i) >= 65 && (int)str3.charAt(i) <= 90){
               start = i;
               end = i + 1;
               res3 = str3.substring(0,start) + pr + str3.substring(start,end).toLowerCase()+ str3.substring(end);     
            }
        }
        return res3;
    }
    
    //задача 4
    public static double overTime(double []array){
        double a = array[0];
        double b = array[1];
        double c = array[2];
        double d = array[3];
        double res4 = 0;
        if(b>17){
            res4 = ((17 - a) * c) + ((b - 17) * c * d);            
        }else if(b <= 17){
            res4 = (b - a) * c;
        }else if(a >= 17){
            res4 = (b - a) * c * d;
        }
        return res4;
    }
    
    //задача 5
    public static String BMI(float v1, String v2, float r1, String r2){
        String res5 = "";
        float imt = 0;
        float kg = 0;
        float met = 0;
        if (v2.charAt(0) == 'p')
        {
            kg = v1 * (float)0.45392;
        }
        else
        {
            kg = v1;
        }
        
        if (r2.charAt(0) == 'i')
        {
            met = r1 * (float)0.0254;
        }else if(r2.charAt(0) == 'c' || r2.charAt(0) == 's')
        {
            met = r1 / 100;
        }
        else
        {
            met = r1;
        }
        
        imt = (kg)/(met * met);
        
        if(imt < 18.5){
            res5 = (imt + " Underweight");
        }else if(imt >18.5 && imt < 24.9){
            res5 = (imt + " Normal weight");
        }else if(imt >= 25){
            res5 = (imt + " Overweight");
        }
        
        return res5;
    }
    
    //задача 6
    public static int bugger(int num){
        int res6 = 0;
        int c = 0;
        while(num > 9){
            int temp = 1;
            while(num > 0){
                temp *= num % 10;
                num/= 10;
            }
            num = temp;
            c++;
        }
        return  res6 = c;
    }
    
    //задача 7
    public static String toStarShorthand(String str7){
        String res7 = "";
        int count = 1;
        char end = str7.charAt(str7.length()-1);
        for(int i = 0; i < str7.length()-1; i ++){
            
            if(str7.charAt(i) == str7.charAt(i + 1)){
                count+=1;
            }else if(str7.charAt(i) != str7.charAt(i + 1)){
                if(count > 1){
                    res7 += str7.charAt(i) + "*" + count;
                    count = 1;
                }else{
                    res7+=str7.charAt(i);
                    count = 1;
                }
            }
        }
        if(count > 1){
            res7 += end + "*" + count;
        }else{
            res7+=end;
        }
        return res7;
    }
    
    //задача 8
    public static String doesRhyme(String s81, String s82){
        String res8 = "";
        String end1 = "";
        String end2  = "";
        int len1 = s81.length();
        int len2 = s82.length();
        
        if(s81.charAt(len1-1) >= 33 &&  (int)s81.charAt(len1 - 1) <= 47){
            end1 = Character.toString(s81.charAt(len1-3));
            end1 += s81.charAt(len1 - 2);
        }else{
            end1 = Character.toString(s81.charAt(len1-2));
            end1 += s81.charAt(len1 - 1);
        }
        
        if(s82.charAt(len2-1) >= 33 &&  (int)s82.charAt(len2 - 1) <= 47){
            end2 = Character.toString(s82.charAt(len2 - 3));
            end2 += s82.charAt(len2 - 2);
        }else{
            end2 = Character.toString(s82.charAt(len2 - 2));
            end2 += s82.charAt(len2 - 1);
        }
        
        end1 = end1.toLowerCase();
        end2 = end2.toLowerCase();
       
        if(end1.equals(end2)){
            res8 = "true";
        }else{
            res8 = "false";
        }
        
        return res8;
    }
    
    //задача 9
    public static String trouble(int num1, int num2){
        String res9 = "";
        String n1 = String.valueOf(num1);
        String n2 = String.valueOf(num2);
        int res1 = 1;
        int res2 = 1;
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < 10 ;i++){
            for(int j = 0; j < n1.length() - 1;  j++){
                if(i == Character.getNumericValue(n1.charAt(j)) && n1.charAt(j) == n1.charAt(j+1)){
                    res1+=1;  
                    max1 = res1;
            }else if (n1.charAt(j) != n1.charAt(j+1)){
                if(res1 > max1){
                    max1 = res1;
                    }
                }     
            }            
            
            for(int k = 0; k < n2.length() - 1;  k++){
                if(i == Character.getNumericValue(n2.charAt(k)) && n2.charAt(k) == n2.charAt(k+1)){
                    res2+=1;
                    max2 = res2;
                }else if(n2.charAt(k) != n2.charAt(k+1)){
                    if(res2 > max2){
                    max2 = res2;
                    } 
                }
            }
            res1 = 1;
            res2 = 1;   
        }
        if(max1 == 3 && max2 == 2){
                res9 = "true";
            }else{
                res9 = "false";
        }
        return res9;
    }
    
    //задача 10
    public static Integer countUniqueBooks(String str, String sim){
        char simbol = sim.charAt(0);
        int res10 = 0;
        int count = 0;
        String sstr = "";
        String sstr1 = "";
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == simbol){
                count++;
            }else if(count == 1){
                sstr+=str.charAt(i);
            }
            if(count == 2){
                for(int j = 0; j < sstr.length() ; j++){
                    if(!sstr1.contains(Character.toString(sstr.charAt(j)))){
                        sstr1+=Character.toString(sstr.charAt(j));
                    }
                }
                count = 0;
                sstr = "";
            }
            
        }
        res10 = sstr1.length();
        return res10;
       
    }
    
    
}

