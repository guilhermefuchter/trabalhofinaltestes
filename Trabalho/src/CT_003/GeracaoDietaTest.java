package CT_003;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeracaoDietaTest {

    private SistemaGeracaoDieta sistema;

    @BeforeEach
    void setUp() {
        // Inicializa o sistema e autentica o usuário
        sistema = new SistemaGeracaoDieta();
        sistema.autenticarUsuario("usuario", "senha123");
    }

    @Test
    void CT_003_GeracaoDietaParaVaca() {
        // Dados configurados para o teste
        Vaca vaca = new Vaca();
        vaca.setPeso(600.0); // kg
        vaca.setIdade(5); // anos
        vaca.setEstagioProdutivo("Lactação inicial");

        // Pré-condição: Verificar se a vaca foi adicionada ao sistema
        sistema.adicionarVaca(vaca);

        // Ação: Gerar a dieta personalizada
        Dieta dieta = sistema.gerarDieta(vaca);

        // Verificação 1: Garantir que a dieta foi gerada
        Assertions.assertNotNull(dieta, "A dieta não foi gerada.");

        // Verificação 2: Garantir que os valores atendem os requisitos
        Assertions.assertTrue(dieta.getProteinas() > 0, "O valor de proteínas deve ser maior que 0.");
        Assertions.assertTrue(dieta.getEnergia() > 0, "O valor de energia deve ser maior que 0.");

        // Verificação 3: Garantir que a dieta está associada à vaca
        Assertions.assertEquals(vaca, dieta.getVacaAssociada(), "A dieta gerada não está associada à vaca correta.");
    }
}
