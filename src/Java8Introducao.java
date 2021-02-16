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
		// Comparando o tamanho das Strings da lista utilizando a criação
		// de uma nova classe
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		cores.sort(comparador);
		
		System.out.println("Comparação utilizando criação de classe: " + cores);
		
		// Passo 02
		// Comparação utilizando classe anônima
		
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
		
		System.out.println("Comparação utilizando classe anônima: " + cores);
		
		// Passo 03
		// Comparação utilizando lambda
		cores.sort((String s1, String s2) -> {
				if(s1.length() < s2.length())
					return -1;
				if(s1.length() > s2.length())
					return 1;
				return 0;
			});
		
		System.out.println("Comparação utilizando lambda: " + cores);
		
		// Passo 04
		// Declaração de uma variável do tipo Function
		// para ser utilizada como argumento do método comparing
		Function<String, Integer> funcao = s -> s.length();
		cores.sort(Comparator.comparing(funcao));
		
		System.out.println("Comparação utilizando Function: " + cores);
		
		
		// Passo 05
		// Comparação simplificada. Método comparing + lambda		
		cores.sort(Comparator.comparing(s -> s.length()));
		
		System.out.println("Comparação simplificada: " + cores);
		
		// Passo 06
		// Comparação simplificada. Método comparing + method reference		
		cores.sort(Comparator.comparing(String::length));
				
		System.out.println("Comparação simplificada: " + cores);
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