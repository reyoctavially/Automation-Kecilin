#Author: reynaldi.octavially@gmail.com

Feature: Login
  Login Website Kecilin

  @loginTest
  Scenario: Login Test
    Given Saya membuka url kecilin
    When Saya input email dan password
    Then Saya klik tombol login
    And Saya memastikan bahwa login telah berhasil