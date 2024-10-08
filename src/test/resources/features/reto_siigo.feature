Feature:Create customer on Siigo website


  @Test1
  Scenario Outline: Create customer on Siigo website

    Given that user starts the siigo website
    When user logs with the following credentials
      | user   | pass   |
      | <user> | <pass> |
    And user enters the form
    And user fill out form with the following data
      | slttipo   | slttipo_identificacion   | txtidentificacion   | txtcodigo_sucursal   | txtnombre   | txtapellido   | txtnombre_comercial   | txtciudad   | txtdireccion   | txttelefono   | txtcorreo_factura   | slttipo_regimen   | rbresponsabilidad_fiscal   | txtindicativo   | txttelefono1   | txtcodigo_postal   | txtnombre_contacto   | txtapellidos_contacto   | txtcorreo_contacto   | txtcargo_contacto   | txtindicativo_contacto   | txttelefono_contacto   |
      | <slttipo> | <slttipo_identificacion> | <txtidentificacion> | <txtcodigo_sucursal> | <txtnombre> | <txtapellido> | <txtnombre_comercial> | <txtciudad> | <txtdireccion> | <txttelefono> | <txtcorreo_factura> | <slttipo_regimen> | <rbresponsabilidad_fiscal> | <txtindicativo> | <txttelefono1> | <txtcodigo_postal> | <txtnombre_contacto> | <txtapellidos_contacto> | <txtcorreo_contacto> | <txtcargo_contacto> | <txtindicativo_contacto> | <txttelefono_contacto> |
    Then Validate customer create with text "Perfil del tercero"

    Examples:
      | user                        | pass       | slttipo    | slttipo_identificacion | txtidentificacion | txtcodigo_sucursal | txtnombre | txtapellido     | txtnombre_comercial | txtciudad | txtdireccion              | txttelefono | txtcorreo_factura      | slttipo_regimen       | rbresponsabilidad_fiscal      | txtindicativo | txttelefono1 | txtcodigo_postal | txtnombre_contacto | txtapellidos_contacto | txtcorreo_contacto        | txtcargo_contacto | txtindicativo_contacto | txttelefono_contacto |
      | admin@siigoautomationqa.com | (#T0Nu@QrO | Es persona | Cédula de ciudadanía   | 555555555         | 1111111            | Kevin     | CalimenoSecaida | kevincalimeno       | bello     | Avenida siempre viva 1111 | 1111111111  | kevincalimeno@test.com | No responsable de IVA | Régimen simple de tributación | 601           | 22222222     | 1111111          | Alexander          | Secaida               | alexandersecaida@test.com | Qa Automation     | 601                    | 3333333              |