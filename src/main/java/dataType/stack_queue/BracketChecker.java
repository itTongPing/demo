package dataType.stack_queue;

public class BracketChecker {

    private String input;


    public BracketChecker (String input){
        this.input = input;
    }


    public void check(){

        int size = input.length();
       StackX stack = new StackX<Character>(size);
        for(int i = 0 ;i< size;i++){

            char ch = input.charAt(i);

            switch (ch){
                case '{':
                case '[':
                case '(':
                    //压栈
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                  //错误情况1.找到但是对于不上,2.没有找到
                    if(!stack.isEmpty()){

                    //出栈
                    char chx = (char) stack.pop();

                    if((ch==')' && chx !='(')||(ch==']' && chx !='[')||(ch=='}' && chx !='{')){
                        System.out.println("Error "+ch+" at "+i);
                    }
                    }else{
                        System.out.println("Error "+ch+" at "+i);
                    }
                    break;
                    default:
                        break;
            }

        }
        if(!stack.isEmpty()){
            System.out.println("右边没有对应的符号");
        }
    }


    public static void main(String[] args) {
        BracketChecker bc = new BracketChecker("(1+2+]{444[]()}");
        bc.check();
    }
}
