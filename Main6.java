package main6;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.script.*;
import java.util.*;

public class Main6 {
    public static void main(String[] args) throws Exception {
    Scanner sca = new Scanner(System.in);  
    System.out.print("Введите норме задачи: ");
    int zadacha6 = sca.nextInt();
    //sca.nextLine();
    switch(zadacha6){
    
    //задача 1
        case 1:
    System.out.print("Введите число:  ");
    int num1 = sca.nextInt();
    System.out.println(bell(num1));
        break;
     
    //задача 2
        case 2:
    System.out.println("Выберите функцию");
    System.out.println("1 - перевод слова");
    System.out.println("2 - перевод предложения");
    int num2 = sca.nextInt();
    switch(num2){
            case 1:
        System.out.println("Введите слово:");
        String str21 = sca.next();
        String res21 = translateWord(str21);
        System.out.println(res21);
            break;
            case 2:
        System.out.println("Введите предложение:");
        sca.nextLine();
        String str22 = sca.nextLine();
        String res22 = translateSentence(str22);
        System.out.println(res22);
            break;
    }
        break;
  
    //задача 3
        case 3:
    System.out.println("Введите параметры RGB(A):");
    String str3 = sca.next();
    String res3 = validColor(str3);
    System.out.println(res3);
        break;

    //задача 4
        case 4:
    System.out.println("Введите URL строку:");
    String str4 = sca.next();
    System.out.print("Есть ли параметры в ссылке?");
    String vib = sca.next();
    int size4 = 0;
    String [] arr4 = new String[size4];
    switch(vib){
        case "yes":
    System.out.println("Введите количество параметров:");
    size4 = sca.nextInt();
    arr4 = crarr(size4);
    System.out.println(stripUrlParams(str4,arr4));
        break;
        case"no":
    System.out.println(stripUrlParams(str4,arr4));
        break;
    }
        break;
    
    //задача 5
        case 5:
    System.out.println("Введите строку:");
    sca.nextLine();
    String str5 = sca.nextLine();
    List<String> ListRes5 = new ArrayList<String>();
    String res = getHashTags(str5);
    System.out.println(res);
        break;
    
    //задача 6
        case 6:
    System.out.print("Введите число: ");
    int num6 = sca.nextInt();
    System.out.println(ulam(num6));
        break;

    //задача 7
        case 7:
    System.out.println("Введите строку:");
    String str7 = sca.next();
    System.out.println(longestNonrepeatingSubstring(str7));
        break;
    
    //задача 8
        case 8:
    System.out.print("Введите число: ");
    int num8 = sca.nextInt();
    String res8 = convertToRoman(num8);
    System.out.println(res8);
        break;
    
    //задача 9
        case 9:
    System.out.println("Введите строку:");
    sca.nextLine();
    String str9 = sca.nextLine();
    System.out.println(formula(str9));
        break;
    
    //задача 10
        case 10:
    System.out.print("Введите число: ");
    String num10 = sca.next();
    System.out.println(palindromedescendant(num10));
        break;
        
        default: 
    System.out.println("Такой задачи в шестом блоке нет!");
        break;
        }
    }
    
    //Функции
    // Функция запонлнения массива
    public static String[] crarr(int size){
        Scanner sca1 = new Scanner(System.in);
        String [] array = new String[size];
        System.out.println("Введите массив: ");
        for (int i = 0; i < size; i++)
        {
            array[i] = sca1.next(); 
        }
        return array;
    }
    //функция добавления элемента в массив
    public static int[] addElement(int[] org, int added) {
        int[] result = Arrays.copyOf(org, org.length +1);
        result[org.length] = added;
    return result;
    }
   
    //задача 1
    public static int bell(int num){
        int res1 = 0;
        int arr1 [] = new int []{1};
        int arr2 [] = new int []{1};
        int x = 1;
        for(int i = 1; i < num; i++){
            for(int j = 0;j < arr1.length; j++){
                x = arr1[j]+arr2[j];
                arr2 = addElement(arr2,x);
            }
            arr1 = arr2;
            arr2 = new int []{x};
        }
        res1 = x;
        return res1;
    }
    //задача 2
    //доделать
    public static String translateWord(String str2){
        String res2 = "";
        String sstr = "";
        int num = 0;
        char[] arr = {'a','o','i','e','q','u','y','A','E','Y','O','Q','U','Y','I'};
        for(int i = 0; i < str2.length(); i++){
                for(int j = 0;j < arr.length; j++){
                    if(str2.charAt(i) == arr[j])
                    {
                        num = 0;
                        break;
                    }else{
                        num = 1;
                    }
                }
                if(num == 0 && i == 0)
                {
                   return res2 = str2 + "yay"; 
                   
                }else if(num == 0){
                    break;
                }
                else{
                  sstr+=str2.charAt(i);  
                }
            }
            res2 = str2.substring(sstr.length()) + sstr + "ay";
            return res2;
    }
    
    public static String translateSentence(String str2){
        String res3 = "";
        String str = "";
        for(int i  = 0; i < str2.length(); i ++){
            if((int)str2.charAt(i) != 32 && i != str2.length() - 1){
                str +=  str2.charAt(i);
            }else{
                res3 += translateWord(str) + " ";
                str = "";
            }
        }
        res3 = res3.substring(0,res3.length() - 1) + str2.charAt(str2.length() - 1);;
        return res3;
    }
    
    //задача 3
    public static String validColor(String str3){
        String numstr = "";
        int numstrfl = 0;
        int num = 0;
        int res = 0;
        int res1 = 0;
        if(str3.charAt(3) == 'a'){
            String sstr1 = str3.substring(4);
            for(int j = 1; j < sstr1.length(); j ++){
                if(sstr1.charAt(j) >= 48 && sstr1.charAt(j) <= 57){
                    numstr +=sstr1.charAt(j);
                }else if(sstr1.charAt(j) == ',' && (sstr1.charAt(j) == sstr1.charAt(j+1)) ){
                    break;
                }else if(sstr1.charAt(j) == '.' ){
                    numstrfl  = Character.getNumericValue(sstr1.charAt(j-1));
                    if(numstrfl < 1){
                        res1++;
                        break;
                    }
                }else if(sstr1.charAt(j) == ',' || sstr1.charAt(j) == ')'){
                    num = Integer.valueOf(numstr);
                    if(num <= 255 ){
                        res1++;
                    }   
                } 
            }
        
        }else{
            String sstr = str3.substring(3);
            for(int i = 1; i < sstr.length(); i ++){
                if(sstr.charAt(i) >= 48 && sstr.charAt(i) <= 57){
                    numstr +=sstr.charAt(i);
                }else if(sstr.charAt(i) == ',' && (sstr.charAt(i) == sstr.charAt(i+1)) ){
                    break;
                }else if(sstr.charAt(i) == ',' || sstr.charAt(i) == ')'){
                    num = Integer.valueOf(numstr);
                    if(num <= 255){
                        res++;
                    }
                }
            }  
        }
        if(res == 3 || res1 == 4){
                return "true";
            }else{
                return "false";
            }
    }

    //задача 4
    public static String stripUrlParams(String str, String[] S1){
        char [] S = str.toCharArray();
        String res4 = "";
        for(int i = 0; i < S.length - 2;i++){
            res4 += S[i];
            if(S[i] == 'c' && S[i+1] == 'o' && S[i+2] == 'm'){
                res4 +=S[i + 1];
                res4 +=S[i + 2];
                break;
            }
        }
        if(res4.length() != str.length()){
            res4 += str.charAt(res4.length());
            String par = "";
            for(int i = res4.length(); i < str.length(); i++){
                par +=str.charAt(i);
            }
            String[] param = par.split("&");
            HashMap<String, String> map = new HashMap<>();
            for(int i = 0; i < param.length;i++){
                String[] k = param[i].split("=");
                map.put(k[0],k[1]);
            }
            if(S1.length != 0){
                for(int i = 0; i < S1.length;i++){
                    map.remove(S1[i]);
                }
            }
            ArrayList<HashMap.Entry> entries = new ArrayList<>(map.entrySet());
            for(int i = 0; i < entries.size();i++){
                if(i == entries.size() - 1){
                    res4+=entries.get(i);
                }else{
                    res4+=entries.get(i) + "&";
                }
            }
        }
        return res4;
    }
    
    //задача 5
    public static String getHashTags(String str5){
        ArrayList ListRes = new ArrayList();
        str5 = str5.toLowerCase();
        String str = "";
        
        for(int i = 0; i < str5.length();i++){
            if(str5.charAt(i)!=' '&& str5.charAt(i)!=',' && str5.charAt(i)!='.'){
                str+=str5.charAt(i);
            }else{
                ListRes.add(str);
                str = "";
            }
        }
        ListRes.add(str);
        
        int col = 0;
        if(ListRes.size() >= 3){
            col = 3;
        }else if(ListRes.size() == 2){
            col = 2;
        }else if(ListRes.size() == 1){
            col = 1;
        }
        
        int largestString = (ListRes.get(0).toString()).length();
        int index = 0;
        String res = "";
        for (int j = 0; j < col; j++){
            for(int i = 0; i < ListRes.size(); i++) {
                if(ListRes.get(i).toString().length() > largestString) {
                    largestString = ListRes.get(i).toString().length();
                    index = i;
                }
            }
            str = ListRes.get(index).toString();
            res += "#" + str + ", ";
            ListRes.remove(index);
            str = "";
            index = 0;
            largestString = 0;
        }
        res = res.substring(0, res.length()-2);
        return res;
    }
    
    //задача 6
    public static int countulam(int[]arr, int n, int num){
        int count = 0;
        for(int i = 0; i < arr.length;i++){
            for(int j = 0; j < arr.length;j++){
                if(arr[i] + arr[j] == num && arr[i] != arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
    
    public static int ulam(int n){
        int res6 = 0;
        int count = 0;
        int arrulam[] = {1,2};
        int i = 2;
        
        if(n == 1){
            res6 = 1;
        }else if(n == 2){
            res6 = 2;
        }else{
            work: while(i < n){
                for(int j = 0; j < arrulam.length; j++){
                    for(int k = 0; k < arrulam.length; k++){
                        if(arrulam[j] != arrulam[k] && arrulam[j] + arrulam[k] > arrulam[i - 1]){
                            count = countulam(arrulam,n,arrulam[j] + arrulam[k]);
                            if(count == 2){
                                res6 = arrulam[j] + arrulam[k];
                                arrulam = addElement(arrulam, res6);
                                i++;
                                continue work;
                            }
                        }
                    }
                }
            }
            }
        
        return res6;
    }
    
    //задача 7
    public static String longestNonrepeatingSubstring(String str7){
        String Maxres7 = "";
        String promres = "";
        int count = 0;
        int index = str7.length();
        for(int i = 1; i < str7.length();i++){
            index = str7.indexOf(Character.toString(str7.charAt(i-1)),i);
            if(index != -1){
                count ++;
                promres = str7.substring(i-1, index);
                if(promres.length() > Maxres7.length()){
                    Maxres7 = promres;
                }
            }
        }
        if(count == 0){
            Maxres7 = str7;
        }
        return Maxres7;
    }
    
    //задача 8
    private static String convertToRoman(int n) {
    String[] romanNumerals = { "M",  "CM", "D", "CD", "C", "XC", "L",  "X", "IX", "V", "I" };
    int[] romanNumeralNums = {  1000, 900, 500,  400 , 100,  90,  50,   10,    9,   5,   1 };
    String finalRomanNum = "";

    for (int i = 0; i < romanNumeralNums.length; i ++) {
            int currentNum = n /romanNumeralNums[i];
            if (currentNum==0) {
                continue;
            }

            for (int j = 0; j < currentNum; j++) {
                finalRomanNum +=romanNumerals[i];
            }

            n = n%romanNumeralNums[i];
    }
        return finalRomanNum;
    }
    
    //задача 9
    public static boolean formula(String str) throws Exception{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval("");
        Object result1 = engine.eval("");
        String str1 = "";
        boolean res = false;
        int count = 0;
        int opt = 0;
        int len = str.length();
        
        for(int i = 0; i < len; i++){
            if(str.charAt(i) != '=' && i != len - 1){
                str1 += str.charAt(i);
            }else{
                if(i == str.length() - 1){
                    str1 +=str.charAt(i);
                }
                count++;
                if(count % 2 == 0){
                    result1 = engine.eval(str1);
                    System.out.println(result1);
                    str1 = "";
                }else{
                    result = engine.eval(str1);
                    System.out.println(result);
                    str1 = "";
                }
                
                if(result.equals(result1)){
                    opt+=1;
                }
            }
        }
        if(count - 1 == opt){
            res = true;
        }
        return res;
    }
    //задача 10
    public static boolean palindromedescendant(String num){
        boolean res = false;
        String num1 = "";
        String num2 = "";
        int len = 0;
        String strnum = "";
        
        len = num.length();
        if(len == 1){
            res = true;
        }else{
            while(len >= 2){
                if(len%2 == 0){
                    num1 = num.substring(0, len/2);
                    num2 = num.substring(len/2);
                    num2 = new StringBuilder(num2).reverse().toString();
                    if(num1.equals(num2)){
                        res = true;
                        len = 1;
                    }else{
                        for(int i = 0 ; i < len; i+=2){
                            strnum += Integer.toString(Character.getNumericValue(num.charAt(i)) + Character.getNumericValue(num.charAt(i+1)));
                        }
                        len = strnum.length();
                        num = strnum;
                        strnum = "";
                    }
                }else{
                    num1 = num.substring(0,(len/2));
                    num2 = num.substring((len/2)+1);
                    num2 = new StringBuilder(num2).reverse().toString();
                    if(num1.equals(num2)){
                        res = true;
                        len = 1;
                    }else{
                        len = 1;
                    }
                }
            }
        }
        return res;
    }
    
}

