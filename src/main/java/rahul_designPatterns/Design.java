package rahul_designPatterns;

import java.util.ArrayList;
import java.util.List;

class a //mediator pattern
{
    int no;
    a(int n)
    {
        no=n;
    }
    protected void print()
    {
        System.out.println("HI"+no);
    }
}
class b extends a
{
    b(int n)
    {
        super(n);
    }
}

interface ComputerAbstractFactory   //ABSTRACT FACTORY METHOD
{
    Computer createComputer();
}
class PcFactory implements ComputerAbstractFactory
{
    String ram;
    PcFactory(String r)
    {
        ram=r;
    }

    @Override
    public Computer createComputer() {
        return new Pc(ram);
    }
}
abstract class Computer
{
    public abstract String getRam();
}
class Pc extends Computer
{
    String ram;
    Pc(String r)
    {
        ram=r;
    }
    public String getRam()
    {
        return ram;
    }
}

interface Shape   //COMPOSITE AND TEMPLATE METHOD
{
    void draw(String color);
}
class Triangle implements Shape
{
    @Override
    public void draw(String color) {
        System.out.println("Color in Triangle:-"+color);
    }
}
class Circle implements Shape
{
    @Override
    public void draw(String color) {
        System.out.println("Color in Circle:-"+color);
    }
}
class Drawing implements Shape
{
    List<Shape> shapeList=new ArrayList<Shape>();

    @Override
    public void draw(String color) {
        for (Shape sh: shapeList)
        {
            sh.draw("Red");
        }
    }
}
class Color
{
    String co()
    {
        return "red";
    }
}

public class Design  //SINGLETON METHOD
{
    public static final Design design=new Design();
    private Design()
    {}
    public static Design DesignInstance()
    {
        return design;
    }
    public static void main(String args[])
    {
        Drawing d1=new Drawing();
        Color col=new Color();
        d1.draw(col.co());//BRIDGE METHOD
        b abc=new b(5);
        abc.print();
    }
}
