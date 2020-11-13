package main5;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  

public class Main5 {
    public static void main(String[] args) throws Exception{
    Scanner sca = new Scanner(System.in);  
    //sca.nextLine();
    System.out.print("Введите номер задачи: ");
    int vib = sca.nextInt();
    switch(vib){
        
    //задача 1
        case 1:
    System.out.println("1 - encrypt");
    System.out.println("2 - decrypt");
    System.out.print("Выберите функцию:");
    int vib1 = sca.nextInt();
    if(vib1 == 1){
        System.out.print("Введите строку:");
        String str1 = sca.next();
        String res1 = encrypt(str1);
        System.out.println(res1);
    }else if(vib1 == 2){
        System.out.print("Введите размер массива:");
        int size1 = sca.nextInt();
        double []arr1 = crarr(size1);
        String res1 = decrypt(arr1, size1);
        System.out.println(res1);
    }else{
        System.out.print("Такй функции нет!");
    }
        break;
        
    //задача 2
        case 2:
    System.out.print("Введите фигуру: ");
    String figure = sca.next();
    System.out.print("Стартовая позиция: ");
    String start = sca.next();
    System.out.print("Конечная позиция: ");
    String end = sca.next();
    String res2 = canMove(figure,start,end);
    System.out.println(res2);
        break;

    //задача 3
        case 3:
    System.out.println("Первая строка = ");
    String str31 = sca.next();
    System.out.println("Вторая строка = ");
    String str32 = sca.next();
    String res3 = canComplete(str31, str32);
    System.out.println(res3);
        break;
        
    //задача 4
        case 4:
    System.out.println("Введите последовательность цифр:");
    sca.nextLine();
    ArrayList<Integer> list = new ArrayList<Integer>();
    while (true)
    {
        String s = sca.nextLine();
        if (s.isEmpty()) break;
        list.add(Integer.parseInt(s));
    }
    int res4 = sumDigProd(list);
    System.out.println(res4);
        break;
        
    //задача 5
        case 5:
    System.out.println("Введите размер массива: ");
    int size5 = sca.nextInt();
    String [] array = new String[size5];
        System.out.println("Введите массив: ");
        for (int i = 0; i < size5; i++)
        {
            array[i] = sca.next(); 
        }
    System.out.println("РЕЗЛЬТАТ:");
    sameVowelGroup(array, size5); 
        break;
        
    //задача 6
        case 6:
    System.out.println("Введите число:");
    String num6 = sca.next();
    String res6 = validateCard(num6);
    System.out.println(res6);
        break;
        
    //задача 7
        case 7:
    System.out.println("Введите число от 0 до 999:");
    int num7 = sca.nextInt();
    String res71 = numToEng(num7);
    String res72 = numToRus(num7);
    System.out.println(res71);
    System.out.println(res72);
        break;

    //задача 8
        case 8:
    System.out.println("Введите строку:");
    String s1 = sca.next();
    String res8 = getSha256Hash(s1);
    System.out.println(res8);
        break;
        
    //задача 9
        case 9:
    System.out.println("Введите строку:");
    sca.nextLine();
    String s9 = sca.nextLine();
    String res9 = correctTitle(s9);
    System.out.println(res9);
        break;

    //задача 10
        case 10:
    System.out.print("Введите число:");
    int num10 = sca.nextInt();
    System.out.println(hexLattice(num10));
        break;
        
        default: 
    System.out.println("Такой задачи в пятом блоке нет!");
        break;
    
        }
    }
    //Функция заполнения массива
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
    public static String encrypt(String str1){
        int num1 = (int)str1.charAt(0);
        String res1 = Integer.toString(num1);
        int num2 = 0;
        for(int i = 0; i < str1.length() - 1; i++){
            num1 = (int)str1.charAt(i);
            num2 = (int)str1.charAt(i+1);
            res1 += ", " + Integer.toString(num2 - num1); 
        }
       return res1;
    }
    
    public static String decrypt(double []arr, int size){
        int n = (int)arr[0];
        String res1 = "";
        res1 += (char)n;
        for(int i = 0; i < size - 1; i ++){
            n+=arr[i+1];
            res1 += (char)n;
        }
        return res1;
    }
    
    //задача 2
    public static String canMove(String figure, String start, String end){
        String res2 = "";
        int x1 = Character.getNumericValue(start.charAt(0));
        int y1 = (int)start.charAt(1);
        int x2 = Character.getNumericValue(end.charAt(0));
        int y2 = (int)end.charAt(1);
        switch (figure){
            case "Pawns":
               if(y1 == y2 && (x2 - x1 == 1) || (x2 - x1 == 0)){
                   res2 = "true";
               }else{
                   res2 = "false";
               }
            break;
            case "Rook":
                if(x1 == x2 || y1 == y2){
                   res2 = "true";
               }else{
                   res2 = "false";
               }
            break;
            case "Knight":
                int dx = Math.abs(x1 - x2);
                int dy = Math.abs(y1 - y2);
                if(( dx == 1 && dy == 2) || (dx == 2 && dy == 1)){
                    res2 = "true";
                }else{
                    res2 = "false";
                }
            break;
            case "Bishop":
                int maxx = Math.max(x1,x2);
                int maxy = Math.max(y1,y2);
                int minx = Math.min(x1,x2);
                int miny = Math.min(y1,y2);
                if(maxx-minx == maxy-miny){
                    res2 = "true";
                }else{
                    res2 = "false";
                }
            break;
            case "Queen":
                if(Math.abs(x1 - x2) == Math.abs(y1 - y2) || x1 == x2 || y1 == y2){
                    res2 = "true";
                }else{
                    res2 = "false";
                }
            break;
            case "King":
                if(Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1){
                    res2 = "true";
                }else{
                    res2 = "false";
                }
            break;
            default: 
                System.out.println("Такой фигуры в шахматах нет!");
            break;
        }
        return res2;
    }
    
    //задача 3
    public static String canComplete(String str1, String str2){
        String res3 = "";
        String str3 = "";
        int len = 0;
        counti: for (int i = 0; i < str1.length(); i++){
            for(; len < str2.length();){
                if(str1.charAt(i) == str2.charAt(len)){
                    str3 += str2.charAt(len);
                    len++;
                    continue counti;
                }
                len++;
            }
        }

        if(str1.equals(str3)){
            res3 = "true";
        }else{
            res3 = "false";
        }
        return res3;
    }
    
    //задача 4
    public static Integer sumDigProd(ArrayList list){
        List<Integer> numbers = new ArrayList<>();
        numbers = list;
        int res4 = 0;
        int sum = 0;
        int len = 0;
        String str = "";
        for (Integer x : numbers)
        {
            sum+=x;
        }
        
        str = Integer.toString(sum);
        len = str.length();
            
        while(len != 1){
            sum = 1;
            for(int i = 0; i < len; i++){
                sum *= Character.getNumericValue(str.charAt(i));
            }
            str = Integer.toString(sum);
            len = str.length();
        }
        
        res4 = sum;
        return res4;
    }
    
    //задача 5
    public static void sameVowelGroup(String [] arr, int size5){
        String str1 = arr[0];
        String strarr = "";
        String res5 = "";
        String glasstr = "";
        int len = 0;
        int contr = 0;
        
        for (int j = 0; j < str1.length(); j++){
            if (str1.charAt(j) == 'a' || str1.charAt(j) == 'e' 
                    ||str1.charAt(j) == 'i' || str1.charAt(j) == 'o'
                   || str1.charAt(j) == 'q' || str1.charAt(j) == 'u'
                    || str1.charAt(j) == 'y' ||
                    str1.charAt(j) == 'A' || str1.charAt(j) == 'E' 
                    ||str1.charAt(j) == 'I' || str1.charAt(j) == 'O'
                   || str1.charAt(j) == 'Q' || str1.charAt(j) == 'U'
                    || str1.charAt(j) == 'Y'){
                
                len++;
                glasstr +=str1.charAt(j);
            }
        }
        
        System.out.print(str1 + " ");
        
        for (int i = 1; i < size5; i++){
            strarr = arr[i];
            word: for (int g = 0; g < len; g++){
                for(int k = 0; k < strarr.length() ;k++){
                    if(strarr.charAt(k) == glasstr.charAt(g)){
                        contr++;
                        res5 += strarr.charAt(k);
                        continue word;
                    }
                }
            }
            if (contr >= len || res5.equals(glasstr)){
                    System.out.print(strarr + " ");
                }
            res5 = "";
            contr = 0;
        }
    }
    
    //задача 6
    public static String validateCard(String num1){
        String res6 = "";
        int lastnum = Character.getNumericValue(num1.charAt(num1.length() - 1));
        String bodynumstr = num1.substring(0, num1.length() - 1);
        StringBuffer buffer = new StringBuffer(bodynumstr);
        buffer.reverse();
        String reverse = buffer.toString();
        int len = reverse.length();
        int inversenum = 0;
        int sum = 0;
        String check = "";
        
        for (int i = 0; i < len; i++){
            inversenum = Character.getNumericValue(reverse.charAt(i));
            if(i % 2 == 0){
                inversenum = inversenum * 2;
                if( Integer.toString(inversenum).length() > 1){
                    check = Integer.toString(inversenum);
                    sum += Character.getNumericValue(check.charAt(0)) + 
                            Character.getNumericValue(check.charAt(1));
                }else{
                    sum += inversenum;
                }
            }else{
            sum += inversenum;
            }
        }
        if( 10 - sum%10 == lastnum){
            res6 = "true";
        }else{
            res6 = "false";
        }
        return res6;
    }
    
    //задача 7
    public static String numToEng(int num7){
        String res7 = "";
        String[] numEng1  = new String []{"","one","two","three", "four", "five", "six", "seven", "eight",
      "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
      "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" ,"zero"};
        String[] numEng2 = new String []{"","twenty", "thirty", "forty", "fifty", "sixty", "seventy",
      "eighty", "ninety",""};
        
        if(num7 > 0){
        if((num7/100 > 0)&& (num7%100 > 0)){
            res7 = numEng1[num7 / 100] + " hundred ";
        }else if(num7 / 100 > 0){
            res7 = numEng1[num7 / 100] + " hundred ";
        }else{
            res7 = " ";
        }
        if(num7 % 100 <= 19){
            res7 += numEng1[num7 % 100];
        }else{
            res7 = res7 + numEng2[num7 % 100 / 10 - 1] + " " + numEng1[num7 % 10];
        }
        }else{
            res7 = numEng1[19];
        }
        
        return res7;
    }
    
    public static String numToRus(int num7){
        String res7 = "";
        String[] numEng1  = new String []{"","один","два","три", "четыре", "пять", "шесть", "семь", "восемь",
      "девять", "десять", "одинадцать", "двенадцать", "тринадцать", "четырнадцать",
      "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать" ,"ноль"};
        String[] numEng2 = new String []{"","двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
      "восемьдесят", "девяносто",""};
        
        if(num7 > 0){
        if((num7/100 > 0)&& (num7%100 > 0)){
            res7 = numEng1[num7 / 100] + "сот ";
        }else if(num7 / 100 > 0){
            res7 = numEng1[num7 / 100] + "сот ";
        }else{
            res7 = " ";
        }
        if(num7 % 100 <= 19){
            res7 += numEng1[num7 % 100];
        }else{
            res7 = res7 + numEng2[num7 % 100 / 10 - 1] + " " + numEng1[num7 % 10];
        }
        }else{
            res7 = numEng1[19];
        }
        
        return res7;
    }
    
    //задача 8
    public static String getSha256Hash(String input) throws Exception{ 
       try{
       MessageDigest dig = MessageDigest.getInstance("SHA-256");
            byte[] hesh = dig.digest(input.getBytes("UTF-8"));
            StringBuffer hexStr = new StringBuffer();
            for (int i = 0; i < hesh.length; i++) {
                String hexS = Integer.toHexString(0xff & hesh[i]);
                if(hexS.length() == 1)
                    hexStr.append('0');
                hexStr.append(hexS);
            }
            return hexStr.toString();
       } catch(Exception exc){
           throw new RuntimeException(exc);
        }
    } 
  
    //задача 9
    public static String correctTitle(String str9){
        String str99 = str9.toLowerCase();
        String res9 = "";
        String str = "";
        
        for (int i = 0; i < str99.length(); i++){
            if((int)str99.charAt(i) != 32 && i != str99.length() - 1){
                str+=str99.charAt(i);
            }else {
                if(str.equals("and") || str.equals("the") || str.equals("of") || str.equals("in")){
                    res9+= str + " ";
                    str = "";
                }else{
                    res9+= str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase() + " ";
                    str = "";
                }
            }
        }
        
        res9 = res9.substring(0,res9.length() - 1) + str99.charAt(str99.length() - 1);
        return res9;
    }
    
    //задача 10
    public static String hexLattice(int num10){
        int t = 0;
        int n = 0;
        int n1= 0;
        String str = "";
        String str1 = "";
        int count = 0;
        String res10 = "";
        
        if((num10 - 1)%6 == 0){
            t = (num10 - 1) / 6;
            for(int i = 1 ; i <= t+1; i++){
                n = 1+6*((i*(i-1))/2);
                if(n == num10){
                    res10 = "true " + i;
                    n = i;
                    break;
                }else{
                    res10 = "Invalid" + i;
                }
            }
            n1 = n;
            n = (n*2) - 1;
            
            for(int j = n1; j <n; j++){
                n1--;
                count = 1;
                while(count < n1){
                    str+=" ";
                    count++;
                }
                count = 0;
                while(count < j ){
                    str1+="o" + " ";
                    count++;
                }
                System.out.println(str + " "  + str1 +" " + str);
                str = "";
                str1 = "";
            }
            
            count = 0;
            str = "";
            while(count < n){
                str +="o" + " ";
                count++;
            }
           
            System.out.println(str);
            n1 = 1;
            str = "";
            str1 = "";
            
            for(int k = n-1; k >=n1;k--){
                
                count = 1;
                while(count < n1){
                    str+=" ";
                    count++;
                }
                count = 0;
                while(count < k ){
                    str1+="o" + " ";
                    count++;
                }
                
                str = str + " "  + str1 +" " + str;
                System.out.println(str);
                str = "";
                str1 = "";
                n1++;
            }
            
        }else{
            res10 = "Invalid";
        }
        
        return res10;
    }
    
}
