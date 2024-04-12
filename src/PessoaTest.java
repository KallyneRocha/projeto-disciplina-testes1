//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class PessoaTest {

    //1.O Nome deve possuir um nome e, pelo menos, um sobrenome, separados por um espaço em branco.
    //Caso 1
    @DisplayName("Deve criar pessoa com nome e sobrenome válidos")
    @Test
    public void NomeSobrenomeValido() throws Exception {
        Pessoa pessoa = new Pessoa("Kallyne Rocha", 26);
        Assertions.assertEquals("Kallyne Rocha", pessoa.getNome());
        Assertions.assertEquals(26, pessoa.getIdade());
    }

    //Caso 2
    @DisplayName("Deve lançar exceção ao fornecer apenas um nome")
    @Test
    public void NomeUnico() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("Kallyne", 30);
        });
        Assertions.assertEquals("Deve ser informado o sobrenome", exception.getMessage());
    }

    //2.Nome e sobrenome devem possuir, juntos, mais do que 5 caracteres
    //Caso 1
    @DisplayName("Deve criar pessoa com nome e sobrenome de tamanho válido")
    @Test
    public void NomeTamanhoValido() throws Exception {
        Pessoa pessoa = new Pessoa("Kyllder Almeida", 25);
        assertEquals("Kyllder Almeida", pessoa.getNome());
        assertEquals(25, pessoa.getIdade());
    }

    //Caso 2
    @DisplayName("Deve lançar exceção ao fornecer nome e sobrenome com tamanho inválido")
    @Test
    public void testTamanhoNomeInvalido() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            new Pessoa("Ana Li", 22);
        });
        assertEquals("Nome e sobrenome devem possuir mais do que 5 caracteres", exception.getMessage());
    }

    //3. Nomes devem ser compostos exclusivamente de letras do alfabeto, exceto pelo espaço em branco que separa nome e sobrenomes
    //Caso 1
    @DisplayName("Deve criar pessoa com nome contendo apenas caracteres válidos")
    @Test
    public void testNomeCaracteresValidos() throws Exception {
        Pessoa pessoa = new Pessoa("Gustavo Flores", 22);
        Assertions.assertEquals("Gustavo Flores", pessoa.getNome());
        Assertions.assertEquals(22, pessoa.getIdade());
    }

    //Caso 2
    @DisplayName("Deve lançar exceção ao fornecer nome com caracter inválido")
    @Test
    public void testNomeComCaracterInvalido() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            new Pessoa("Antony R0cha", 28);
        });
        Assertions.assertEquals("Caracter inválido encontrado!", exception.getMessage());
    }

    //A idade deve ser maior ou igual a zero e menor ou igual a 100. Use a técnica de análise do valor limite para testar esse requisito
    //Caso 1
    @DisplayName("Deve criar pessoa com idade válida igual a cem")
    @Test
    public void testIdadeValida() throws Exception {
        Pessoa pessoa = new Pessoa("Helton Carneiro", 100);
        Assertions.assertEquals("Helton Carneiro", pessoa.getNome());
        Assertions.assertEquals(100, pessoa.getIdade());
    }

    //Caso 2
    @DisplayName("Deve criar pessoa com idade válida igual a zero")
    @Test
    public void testIdadeZero() throws Exception {
        Pessoa pessoa = new Pessoa("Joaquim Oliveira", 0);
        Assertions.assertEquals("Joaquim Oliveira", pessoa.getNome());
        Assertions.assertEquals(0, pessoa.getIdade());
    }

    //Caso 3
    @DisplayName("Deve lançar exceção ao fornecer idade negativa")
    @Test
    public void testIdadeNegativa() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            new Pessoa("Ana Maria", -1);
        });
        Assertions.assertEquals("Idade não pode ser negativa", exception.getMessage());
    }

    //Caso 4
    @DisplayName("Deve lançar exceção ao fornecer idade maior que 100")
    @Test
    public void testIdadeMaiorQue100() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            new Pessoa("José Silva", 101);
        });
        Assertions.assertEquals("Idade não pode ser maior que 100", exception.getMessage());
    }

}
