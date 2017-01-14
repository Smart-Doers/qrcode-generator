Feature: QrCode Generation Application

  Background: QrCode Application

  Scenario Outline: Base 64 Qr-Code Generation
    When I create PillarQrCodeInformation with pillar details <name> <capacity> and qr code details <width> <height>
    And I hit the webservice with above details
    Then Result should be <result>
    Examples:
      | name          | capacity | width | height | result  |
      | "Hello World" | 4        | 7     | 10     | "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACEAAAAhAQAAAAB/n//CAAAAlklEQVR42mP4DwQNDJjkB4ke9gaG79dyvzcwfAkOFQeSQUdBZEQvkPx+ay5Q/INoCFDN/+/7geq/X/Dsb2D4tOnW9AaGH1yJ8kB29qntQNnbndcbGL7+5dvfwPAtsAOo5ks+mzmQ7HUAkv8/PgeSH+RFgeT3O9eBur7EPbAHkvHWQJO/RPYCTft+25IfqEbIqBybO8EkAOJZatxEHuDYAAAAAElFTkSuQmCC"   |
      | "Test"        | 5        | 15    | 20     | "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAdAQAAAAB+6FqiAAAAbUlEQVR42mP4////DwY04oO0QwXD95v3Kxi+xAfCiGgg8f1afAXDB1Gg7P8f9T8Yvk1d/4Phc/72Coav3JUVDH/1DlUwfHYXBcp+A5ki+ekHUIcaUG/MjB8MX8Jeg4xKBppyfxbQFJE0DHtBBADIylThxbaMiwAAAABJRU5ErkJggg==" |