package profile
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration


class UpdateProfile {
	def name = 'Akun Testing'

	@Given("Saya menuju halaman profile dengan klik icon profile")
	def navigatePage() {
		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS,'navbarDropdown'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS,'//*[@id="navbarSupportedContent"]/ul[2]/li/ul/a'))
	}

	@When("Saya input name baru untuk update profile")
	def inputName() {
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS,'name'), name)
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS,'btn btn-main rounded-m'))
	}

	@Then("Saya memastikan profile sudah terupdate")
	def verifyUpdateName() {
		WebUI.waitForPageLoad(15, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(new TestObject().addProperty('class', ConditionType.EQUALS, 'profile-name'),
				name ,FailureHandling.STOP_ON_FAILURE)
		WebUI.takeFullPageScreenshotAsCheckpoint('ProfileUpdate')
	}
}