/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Biblis;

/**
 *
 * @author junior
 */
public class SO {

public int rso(){

if(    System.getProperties().get("os.name").toString().charAt(0)=='L'||  System.getProperties().get("os.name").toString().charAt(0)=='l'  ){
return 1;
}

return 2;
}

public static void main(String args[]){
System.out.println(   new SO().rso()+""  );

}
}
