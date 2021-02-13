//Declaração dos utilitários
import java.util.Scanner;
import java.util.Random;
	
public class jogo {
		
	 static int ataqueUsuario() {
	  Scanner identificador = new Scanner(System.in);
	  System.out.println("Escolha seu ataque");
	  System.out.println("(1) - Soco");
	  System.out.println("(2) - Especial");
	  return identificador.nextInt();
	 }

	 static int ataqueComputador() {
	  Random gerador = new Random();
	  return gerador.nextInt(3) + 1;
	 }

	 static void imprimeHP(int hpUsuario, int hpComputador, int limitespeciais) { 
		 
	  System.out.println("==========TABELA==========");
	  System.out.println("- Seu HP: " + hpUsuario);
	  System.out.println("- HP do adversário: " + hpComputador);
	  System.out.println("==========================");
	  System.out.println("-Contagem dos especiais: " + limitespeciais);
	  System.out.println("==========================");
	  
	 }

	 static int batalha() {
	  int hpUsuario = 100;
	  int hpComputador;
	  int contagemEspecial = 5;
	  int escolhaAtaque;
	  int i = 1;

	  while (hpUsuario > 0) {
	   hpComputador = 10 + i;

	   System.out.println("===========================");
	   System.out.println("          INICIO " + i);
	   System.out.println("===========================\n");

	   while (hpUsuario > 0 && hpComputador > 0) {
	    imprimeHP(hpUsuario, hpComputador, contagemEspecial);
	    escolhaAtaque = ataqueUsuario();
	    switch (escolhaAtaque) {
	    case 1:
	     System.out.println("Voce aplicou um soco direto no inimigo..");
	     hpComputador -= 7;
	     break;
	    case 2:
	     System.out.println("Seu ataque especial foi ativado.");
	     hpComputador -= 20;
	     contagemEspecial--; 
	     break;
	    default:
	     System.out.println("Escolha com sabedoria, tal opção não existe.");
	     break;
	    }
	    if (hpComputador > 0) {
	     escolhaAtaque = ataqueComputador();
	     switch (escolhaAtaque) {
	     case 1:
	      System.out.println("Seu adversário lhe deu um soco.");
	      hpUsuario -= 2 + (int)(i / 10);
	      break;
	     case 2:
	      System.out.println("Seu adversário lhe deu um chute.");
	      hpUsuario -= 3 + (int)(i / 10);
	      contagemEspecial--; 
	      break;
	     case 3:
	      System.out.println("O ataque especial do inimigo lhe infligiu dano.");
	      hpUsuario -= 4 + (int)(i / 20);
	      break;
	     }
	    } else {
	     System.out.println("Inimigo derrotado.");
	    } 
	   }
	   if (hpUsuario > 0) {
	    hpUsuario += 5;
	    if (hpUsuario > 150) {
	     hpUsuario = 150;
	    }
	    if (i % 10 == 0) {
	     contagemEspecial++;
	     if (contagemEspecial > 5) {
	      contagemEspecial = 5;
	     }
	    }
	   }
	   i++;
	  }
	  return i; 
	 } 

	 public static void main(String[] args) {
	  Scanner identificador = new  Scanner(System.in);
	  int continua = 1;
	  int recorde = 0;
	  while (continua == 1) {

	   int pontos = batalha();
	   System.out.println("Usuario chegou a " + pontos + " pontos.");
	   if (pontos > recorde) {
	    recorde = pontos;
	   }
	   System.out.println("==========================");
	   System.out.println("    RECORDE ATUAL = " + recorde);
	   System.out.println("==========================");
	   System.out.println("Fim de jogo. Deseja continuar? (1) Sim (2) Nao");
	   continua = identificador.nextInt();
	  }
	       }
}
