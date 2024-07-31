@gestionarVeterinarios
Feature: Gestionar veterinarios

  @listarVeterinarios
  Scenario: Listar todos los veterinarios registrados
    Given el cliente abre el navegador
    When el cliente navega al menú encontrar veterinarios
    Then la página debe mostrar una lista de veterinarios válida

  @MostarDetallesDeLaListaDeVeterinarios
  Scenario Outline: Detalles de la lista de veterinarios
    Given el cliente abre el navegador
    When el cliente navega al menú encontrar veterinarios
    And la página debe mostrar una lista de veterinarios válida
    And el cliente tiene los siguientes datos de los veterinarios:
      | name   | specialty   | position   |
      | <name> | <specialty> | <position> |
    Then la página debe mostrar la información de los veterinarios
    Examples:
      | name              | specialty         | position |
      | James Carter      | none              |    0     |
      | Linda Douglas     | dentistry surgery |    1     |
      | Sharon Jenkins    | none              |    2     |
