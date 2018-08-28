/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Banco;

import Biblis.Ler;

/**
 *
 * @author junior
 */
public class DadosAcesso {
   public static String usuario(){
  return  new Ler().AbrirS("dadosbd").split("\n")[0];
    }
    public static String senha(){
  return  new Ler().AbrirS("dadosbd").split("\n")[1];
    }
    
    
}
