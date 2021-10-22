import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ClienteController {

    /**
     * Posta cliente para nossa API de teste
     * @param clienteParaPostar
     */
    public ValidatableResponse postaCliente (Cliente clienteParaPostar,String SERVICO_CLIENTE,String RECURSO_CLIENTE) {
        return given()
                .contentType(ContentType.JSON)
                .body(clienteParaPostar)
                .when().
                post(SERVICO_CLIENTE + RECURSO_CLIENTE)
                .then();
    }

    /**
     * Atualiza cliente na nossa API de teste
     * @param clienteParaAtualizar
     * @return
     */
    public ValidatableResponse atualizaCliente (Cliente clienteParaAtualizar,String SERVICO_CLIENTE,String RECURSO_CLIENTE) {
        return given()
                .contentType(ContentType.JSON)
                .body(clienteParaAtualizar).
                when().
                put(SERVICO_CLIENTE + RECURSO_CLIENTE).
                then();
    }

    /**
     * Apaga um cliente em específico da nossa API de teste
     * @param clienteApagar
     * @return
     */
    public ValidatableResponse apagaCliente (Cliente clienteApagar,String SERVICO_CLIENTE,String RECURSO_CLIENTE) {
        return  given()
                .contentType(ContentType.JSON)
                .when()
                .delete(SERVICO_CLIENTE + RECURSO_CLIENTE + "/" + clienteApagar.getId())
                .then();
    }

    /**
     * Pega todos os clientes cadastrados na API
     * @return lista com todos os clientes wrapped no tipo de resposta do restAssured
     */
    public ValidatableResponse pegaTodosClientes (String SERVICO_CLIENTE) {
        return  given()
                .contentType(ContentType.JSON)
                .when()
                .get(SERVICO_CLIENTE)
                .then();
    }
}
