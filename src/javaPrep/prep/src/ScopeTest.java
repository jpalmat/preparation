public class ScopeTest {
static int classVariable;
int instanceVariable;
public ScopeTest(){int local1 = 2;}
public ScopeTest(int local2){instanceVariable = local2;}
public static void main(String[] args){
int local4 = 0;
ScopeTest st1 = new ScopeTest();
System.out.println(classVariable);
System.out.println(st1.classVariable);
System.out.println(st1.instanceVariable);
ScopeTest st2 = new ScopeTest(1);
st2.setClassVariable(2);
System.out.println(st1.classVariable);
System.out.println(st1.instanceVariable);
System.out.println(st2.classVariable);
System.out.println(st2.instanceVariable);
}
void setClassVariable(int local8){classVariable = local8;}
}
