class OperatorsDemo{ 
    public static void main(String args[]){
        int a=15, b=8; 
        System.out.println(a+b); 
        System.out.println(a-b); 
        System.out.println(a*b); 
        System.out.println(a/b); 
        System.out.println(a%b); 
        System.out.println(+a); 
        System.out.println(-a); 
        System.out.println(++a); 
        System.out.println(--a); 
        System.out.println(a==b); //False 
        System.out.println(a!=b); //True 
        System.out.println(a>b); //True 
        System.out.println(a<b); //False 
        System.out.println(a>=b); //True 
        System.out.println(a<=b); //False 
        System.out.println((a>b)&&(b>5)); 
        System.out.println((a>b)||(b<5)); 
        System.out.println(!(a>b)); 
        a=5; 
        b=3; 
        int c=8; 
        int d=1; 
        System.out.println(a&b); 
        System.out.println(a|b); 
        System.out.println(a^b); 
        System.out.println(~a); 
        System.out.println(c<<d); 
        System.out.println(c>>d); 
        System.out.println(-c>>>d); 
        c+=2; //c=c+2 
        System.out.println(c); 
        c-=2; 
        //c=c-2 
        System.out.println(c); 
        c*=2; //c=c*2 
        System.out.println(c); 
        c/=2; //c=c/2 
        System.out.println(c); 
        c%=2; //c=c%2 
        System.out.println(c); 
        int result; 
        result = a<b?b-a:a-b; 
        System.out.println(result); 
    } 
}