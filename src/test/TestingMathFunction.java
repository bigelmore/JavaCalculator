package test;


public class TestingMathFunction {

    private TestingMathFunction() {
	// TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
	test(Math.sin(30));
	test(Math.sin(60));
	test(Math.sin(90));
	test(Math.sin(120));
	test(Math.sin(150));
	test(Math.sin(180));
	test(Math.sin(210));
	test(Math.sin(240));
	test(Math.sin(270));
	test(Math.sin(300));
	test(Math.sin(330));
	test(Math.sin(360));
	
	

    }
    
    private static void test(Object obj){
	System.out.println(obj);
    }

}
