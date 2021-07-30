package com.it_academy.practice.junit_basics;

public class Calculator {

    private  int c;
    private int[] args;

    public Calculator( int c, int... args){
        this.c = c;
        this.args = args;
    }

    public float getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }


    public float calculate(char operation) {
        switch(operation) {
            default: {
                return 0;
            }
            case '-': {
                //return a - b;
                int sub = c;
                for (int i : args){
                   sub = sub-i; }
               return sub;
            }
            case '+': {
               // return a + b;
                int sum = c;
                 for (int i : args)
                 sum = sum+i;
                 return sum;
            }

            case '/': {
                int div =c;
              for (int i : args) {
                  div = div / i;
              }
                  return div;

            }
            case '*': {
                //return a * b;
                int mult = c;
                for (int i : args)
                    mult = mult*i;
                return mult;
            }

            case '^': {
                int result = c;
                return (float) Math.pow(result, args[0]);
            }
            case '√': {
                int result = c;

              return (float) Math.sqrt(result);

            }

        }

    }
}



