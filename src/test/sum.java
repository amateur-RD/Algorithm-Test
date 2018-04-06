package test;
import java.util.ArrayList;
import java.util.Scanner;  
  
public class sum {  
    static int sum=0;  
    static int c=0;  
    static int n=0;  
    static int[] arr;  
    static int[] temp;  
    static int t=0;  
    public static void main(String[] args) {  
        Scanner input=new Scanner(System.in);  
        while(input.hasNext()) {
            n=input.nextInt();  
            c=input.nextInt();
        }
        String str;
        do {
        	 str = input.nextLine();
             if(str.equals("")) {
             	break;
            }
        }while(true);
       
        
        arr=new int[n];  
        temp=new int[n];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {  
            arr[i]=sc.nextInt();  
        } 
        //Scanner input=new Scanner(System.in);  

//        ArrayList< ArrayList<Integer>> listAll= new ArrayList< ArrayList<Integer>>();  		 
//        
//        String str;
//        int k=0;
//        ArrayList<Integer> list;
//        for (int i = 0; i < 2; i++) {
//        	str = input.nextLine();
//
//          list = new ArrayList<Integer>();
//          Scanner myinput2 = new Scanner(str);	//默认空格作分隔符
//          while(myinput2.hasNext())    //逐个接收当前串里的字符/数字          
//         	 {
//          list.add(myinput2.nextInt());
//          }
//          listAll.add(list);
//          k++;
//      	}
//        
//
//        ArrayList<Integer> tmp =  listAll.get(0);
//        n= tmp.get(0);
//        c = tmp.get(1);
//        
//        arr=new int[n];  
//        temp=new int[n];
//        int i=0;
//        ArrayList<Integer> tmp2 =  listAll.get(1);
//        for(Integer each: tmp2)
//        {
//        	arr[i++] = each;
//        }
        search(0);  
        input.close();
        //sc.close();
        if(t==0){  
            System.out.println("good");  
        }else {
        	System.out.println("perfect");
        }
    }  
    public static void search(int m){  
        if(sum==c){  
            t=1;  
//            for (int i = 0; i < m; i++) {  
//                if(temp[i]==1){  
//                    System.out.print(arr[i]+" ");  
//                }  
//            }  
            //System.out.println();  
            return;  
        }  
        if(sum>c||m==n){  
            return;  
        }  
        if(sum+arr[m]<=c){  
            sum+=arr[m];  
            temp[m]=1;  
            search(m+1);  
            temp[m]=0;  
            sum-=arr[m];  
        }  
        search(m+1);  
    }  
}  
