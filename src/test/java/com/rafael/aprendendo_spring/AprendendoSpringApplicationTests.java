package com.rafael.aprendendo_spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")   // Usa perfil de teste
class AprendendoSpringApplicationTests {

	@Test
	void contextLoads() {
		// Teste básico de carregamento do contexto
	}
}