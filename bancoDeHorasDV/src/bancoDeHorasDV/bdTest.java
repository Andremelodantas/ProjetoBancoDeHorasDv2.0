package bancoDeHorasDV;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class bdTest {
	
	public FuncionarioRepository Fr;

	@BeforeEach
	void setUp() throws Exception {
		Fr = new FuncionarioRepository();
	}

	@Test
	void removeAddTest() throws IOException {
		assertEquals(Fr.remove(Fr.getTamanho()+1),"Id invalido.");
		assertEquals(Fr.add("Paula"),"Funcion�rio adicionado com sucesso.\n");
		assertEquals(Fr.remove(Fr.getTamanho()),"Funcion�rio removido com sucesso.\n");
	}
	
	@Test
	void opBasicasTest() throws IOException {
		assertEquals(Fr.getSaldo(1),"Vaqueiro - 10 horas.\n");
		assertEquals(Fr.getSaldo(Fr.getTamanho()+1),"n�mero do funcion�rio invalido.\n");
		assertEquals(Fr.getSaldo(2),"Fabricio - 8 horas.\n");
		assertEquals(Fr.getSaldo(3),"Welligton - 2 horas.\n");
		assertEquals(Fr.getSaldo(4),"Andrezinho - 0 horas.\n");
		
		assertEquals(Fr.alterarHora(0, 5),"Altera��o feita com sucesso.\n");
		assertEquals(Fr.alterarHora(0, -5),"Altera��o feita com sucesso.\n");
		assertEquals(Fr.alterarHora(Fr.getTamanho()+1, 5),"n�mero do funcion�rio invalido.\n");
	}

}
