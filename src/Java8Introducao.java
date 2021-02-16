import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Java8Introducao {

	public static void main(String[] args) {
		
		List<String> cores = new ArrayList<String>();
		
		cores.add("Vermelho");
		cores.add("Cinza");
		cores.add("Verde");
		cores.add("Azul");
		
		// Passo 01
		// Comparando o tamanho das Strings da lista utilizando a cria��o
		// de uma nova classe
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		cores.sort(comparador);
		
		System.out.println("Compara��o utilizando cria��o de classe: " + cores);
		
		// Passo 02
		// Compara��o utilizando classe an�nima
		
		cores.sort(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.length() < s2.length())
					return -1;
				if(s1.length() > s2.length())
					return 1;
				return 0;
			}
		});
		
		System.out.println("Compara��o utilizando classe an�nima: " + cores);
		
		// Passo 03
		// Compara��o utilizando lambda
		cores.sort((String s1, String s2) -> {
				if(s1.length() < s2.length())
					return -1;
				if(s1.length() > s2.length())
					return 1;
				return 0;
			});
		
		System.out.println("Compara��o utilizando lambda: " + cores);
		
		// Passo 04
		// Declara��o de uma vari�vel do tipo Function
		// para ser utilizada como argumento do m�todo comparing
		Function<String, Integer> funcao = s -> s.length();
		cores.sort(Comparator.comparing(funcao));
		
		System.out.println("Compara��o utilizando Function: " + cores);
		
		
		// Passo 05
		// Compara��o simplificada. M�todo comparing + lambda		
		cores.sort(Comparator.comparing(s -> s.length()));
		
		System.out.println("Compara��o simplificada: " + cores);
		
		// Passo 06
		// Compara��o simplificada. M�todo comparing + method reference		
		cores.sort(Comparator.comparing(String::length));
				
		System.out.println("Compara��o simplificada: " + cores);
	}
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		
		if(s1.length() < s2.length())
			return -1;
		if(s1.length() > s2.length())
			return 1;
		return 0;
	}
}