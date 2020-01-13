Feature: Cotizar valor del seguro al potencial cliente
  
	Como vendedor de seguros de carro
	Deseo calcular el valor de la prima para el seguro de un carro de un potencial cliente
	Con la finalidad de cotizarle a mi potencial cliente el valor del seguro

  Scenario Outline: El potencial cliente presenta su información
    Given La edad del cliente es <edad>
    And Sus puntos son <puntos>
    When Pide que se calcule el valor de su seguro
    Then Se le dirá que su seguro es <resultado>

    Examples: 
      | edad  | puntos |             resultado  |
      |    17 |      5 |                     -1 |
      |    18 |     29 |                	 1350 |
      |    34 |     25 |    								900 |
      |    40 |     25 |                    400 |
      |    50 |     20 |                    400 |
      |    65 |     25 |    								550 |
      |    91 |      5 |                     -1 |