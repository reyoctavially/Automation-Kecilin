package login
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



class Login {
	TestData login = findTestData('Data Files/Login')
	def email
	def password

	@Given("Saya membuka url kecilin")
	def openUrlKecilin() {
		RunConfiguration.setWebDriverPreferencesProperty("args", [
			"--window-size=1280,1024",
			"--incognito"
		])

		WebUI.enableSmartWait()
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.urlKecilin)
		WebUI.waitForElementPresent(new TestObject().addProperty('id', ConditionType.EQUALS, 'email'), 10)
	}

	@When("Saya input email dan password")
	def inputEmailPassword() {
		for (def index = 1 ; index<=login.getRowNumbers(); index++) {
			email = login.getValue('email', index)
			password = login.getValue('password', index)
		}

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS,'email'), email)
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS,'password'), password)
	}

	@Then("Saya klik tombol login")
	def clickBtnLogin() {
		WebUI.waitForPageLoad(15, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementClickable(new TestObject().addProperty('class', ConditionType.EQUALS, 'btn btn-main px-5 mb-3 w-100 rounded-m'),10)
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS,'btn btn-main px-5 mb-3 w-100 rounded-m'))
		WebUI.waitForPageLoad(15, FailureHandling.STOP_ON_FAILURE)
	}

	@And("Saya memastikan bahwa login telah berhasil")
	def verifyLogin() {
		WebUI.verifyElementVisible(new TestObject().addProperty('id', ConditionType.EQUALS, 'logo-bit'))
		WebUI.takeFullPageScreenshotAsCheckpoint('Login')
	}
}