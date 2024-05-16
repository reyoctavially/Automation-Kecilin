#Author: reynaldi.octavially@gmail.com

Feature: Update Profile
  Update Profile Kecilin

  @updateProfile
  Scenario: Update profile
    Given Saya menuju halaman profile dengan klik icon profile
    When Saya input name baru untuk update profile
    Then Saya memastikan profile sudah terupdate