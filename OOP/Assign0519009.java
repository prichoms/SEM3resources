package com.JavaClg.class4lab;

import java.util.Scanner;
import static java.lang.Math.*;


class point
{
    float x;
    float y;

    public point(float x,float y)
    {
        this.x=x;
        this.y=y;
    }
}
class line
{
    float x1,x2,y1,y2;

    public line(point a,point b)
    {
        this.x1=a.x;
        this.y2=a.y;
        this.x1=b.x;
        this.y2=b.y;

    }
}

class square
{
    float x1,x2,y1,y2,z1,z2,q1,q2;

    public square(point c,point d,point e,point f)
    {
        this.x1 = c.x;
        this.x2 = c.y;
        this.y1 = d.x;
        this.y2 = d.y;
        this.z1 = e.x;
        this.z2 = e.y;
        this.q1 = f.x;
        this.q2 = f.y;
    }
}

class rect
{
    float x1,x2,y1,y2,z1,z2,q1,q2;

    public rect(point g,point h,point i,point j)
    {
        this.x1 = g.x;
        this.x2 = g.y;
        this.y1 = h.x;
        this.y2 = h.y;
        this.z1 = i.x;
        this.z2 = i.y;
        this.q1 = j.x;
        this.q2 = j.y;
    }

}

public class Assign0519009 {
    public static void printArr(float[] arr, int index) {
        if (index != -1) {
            printArr(arr, index - 1);
            System.out.println(arr[index]);
        }
    }

    public static void printPairs(float[] arr, float avg) {
        for (int i = 0; i < arr.length; i++) {
            float first = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                float second = arr[j];
                if ((first + second) <= avg) {
                    System.out.printf(first + "," + second);
                    System.out.println();
                }
            }
        }
    }

    public static void printPascal(int n) {

        for (int line = 0; line < n; line++) {
            for (int i = 0; i <= line; i++)
                System.out.print(akg(line, i) + " ");

            System.out.println();
        }
    }

    public static int akg(int n, int k) {
        int res = 1;

        if (k > n - k)
            k = n - k;

        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public static void printFib(int k) {
        int n = k, t1 = 1, t2 = 2;

        System.out.print("Upto " + n + ": " + "1" + " ");
        while (t1 <= n) {
            System.out.print(t1 + "  ");

            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
    }

    public static void value() {

        point a = new point(((int)(Math.random() * 5)+3), (int)(Math.random() * 20));
        point b = new point((int)(Math.random() * 5)+3, (int)(Math.random() * 20));
        point c = new point(((int)(Math.random() * 5)+3), (int)(Math.random() * 20));
        point d = new point(((int)(Math.random() * 5)+3), (int)(Math.random() * 20));
        point e = new point(((int)(Math.random() * 5)+3), (int)(Math.random() * 20));
        point f = new point(((int)(Math.random() * 5)+3), (int)(Math.random() * 20));
        point g = new point(((int)(Math.random() * 5)+3), (int)(Math.random() * 20));
        point h = new point(((int)(Math.random() * 5)+3), (int)(Math.random() * 20));
        point i = new point(((int)(Math.random() * 5)+3), (int)(Math.random() * 20));
        point p = new point(((int)(Math.random() * 5)+3), (int)(Math.random() * 20));

        line l = new line(a, b);
        square s = new square(c, d, e, f);
        rect r = new rect(g, h, i, p);

        System.out.println(l.x1+" "+l.y1+" "+l.x2+" "+l.y2);
        System.out.println("points of square");
        System.out.println(s.x1+" "+s.x2+" "+s.y1+" "+s.y2+" "+s.z1+" "+s.z2+" "+s.q1+" "+s.q2);
        System.out.println("points of rectangle");
        System.out.println(r.x1 + " " + r.x2 + " " + r.y1 + " " + r.y2 + " " + r.z1 + " " + r.z2 + " " + r.q1 + " " + r.q2);


        System.out.println("length of line= ");
        System.out.println(sqrt(abs(l.x2-l.x1)+abs(l.y2-l.y1)));

        System.out.println("perimeter of rectangle+ ");
      //  System.out.println((sqrt(abs(r.x2 - r.x1) + abs(r.y2 - r.y1) + (abs(r.z2 - r.z1) + abs(r.q2 - r.q1))));


    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }
        public static void que4()
        {
            int[] arr1 = new int[9];
            int[] arr2 = new int[11];

            int[][] arr3 = {{17, 7, 21, 41, 44, 131, 14, 101, 198, 139,}, {89, 14, 2, 59, 40, 26, 115, 60, 151, 18}};
            int c = 0;
            int m = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 10; j++) {
                    if (arr3[i][j] % 2 == 0) {
                        arr1[c] = arr3[i][j];
                        ++c;
                    } else {
                        arr2[m] = arr3[i][j];
                        ++m;
                    }
                }
            }

            bubbleSort(arr1);
            bubbleSort(arr2);
            System.out.println("array of not prime nos.");
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr1[i]);
            }
            System.out.println("array of prime nos.");
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr2[i]);
            }
        }


        public static void main (String[]args){

            Scanner obj = new Scanner(System.in);
            System.out.println("enter question no");
            int o;
            o = obj.nextInt();
            obj.nextLine();

            switch (o) {
                case 1:
                    int n;
                    float[] arr;
                    float sum = 0;
                    float avg = 0;
                    System.out.println("enter size of array");
                    n = obj.nextInt();
                    arr = new float[n];

                    for (int i = 0; i < n; i++) {
                        arr[i] = (float) Math.random() * 20;
                        sum += arr[i];
                    }
                    System.out.println("Array elements");
                    printArr(arr, arr.length - 1);
                    avg = sum / n;
                    System.out.println("average sum");
                    System.out.println(avg);
                    System.out.println();
                    System.out.println("If consecutive pairs of sum less than average found it will be printed below.");

                    printPairs(arr, avg);

                    break;


                case 2:
                    System.out.println("enter height of pascal triangle");
                    int j;
                    j = obj.nextInt();
                    System.out.println("Pascal tree u asked for:");
                    printPascal(j);
                    System.out.println("fibonacci seq");
                    printFib(j);
                    break;

                case 3:


                   value();
                    break;

                case 4:
                    que4();
                    break;


            }
        }

}


