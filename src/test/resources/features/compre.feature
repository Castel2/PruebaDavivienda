Feature: Usuario se loguea a la aplicacion web

  Scenario Outline: Comprar objetos
    Given el usurio ingresa sus credenciales <username>, <password> con el tipo de logueo <tipo>
    When Seleccionar los productos con una cantidad total de <cantidad>
    And Se observan los productos en el carrido de compras
    And Se realiza el checkout con los siguientes datos <nombre>, <apellido>, <codigo>
    Then Se valida el total de la compra
    And Se cierra la sesion

    Examples:
      | username                | password     | tipo      | cantidad | nombre | apellido     | codigo |
      | standard_user           | secret_sauce | exitoso   | 3        | Yordan | Castelblanco | 15976  |
      | locked_out_user         | secret_sauce | bloqueado | 0        |        |              |        |
      | problem_user            | secret_sauce | problema  | 2        | Sandra | Zea          | 646    |
      | performance_glitch_user | secret_sauce | glitch    | 2        | Flor   | Castillo     | 546    |
