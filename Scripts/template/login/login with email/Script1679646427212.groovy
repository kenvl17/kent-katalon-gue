import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*
Author:Kent Vanlim
Created Date : 24 Mar 2023
Update Date :-
Notes: Create login template with email
*/
'tap masuk'
Mobile.tap(findTestObject('Object Repository/global element/text_field_global', [('text') : 'MASUK']), 10)

'check if theres any button to already have account'
def visible = Mobile.verifyElementNotExist(findTestObject('Object Repository/login/btn_already_have_account'), 10, FailureHandling.CONTINUE_ON_FAILURE)

'click already have account'
if (!visible) {
    Mobile.tap(findTestObject('Object Repository/login/btn_already_have_account'), 10)
}

'input email to field email'
Mobile.setText(findTestObject('Object Repository/login/text_field_email'), email, 10)

'input email to field password'
Mobile.setText(findTestObject('Object Repository/login/text_field_password'), password, 10)

'tap login'
Mobile.tap(findTestObject('Object Repository/login/btn_submit_login'), 10)

'skip coachmark and tnc'

'check if theres any button to already have account'
def bannerVisible = Mobile.verifyElementExist(findTestObject('Object Repository/global element/text_field_global', [('text') : 'Selamat Datang di Teman Diabetes']), 
    10, FailureHandling.CONTINUE_ON_FAILURE)

if (bannerVisible) {
    Mobile.tap(findTestObject('Object Repository/login/checklist_tnc_welcome'), 10)

    Mobile.tap(findTestObject('Object Repository/global element/text_field_global', [('text') : 'LANJUT']), 10)
}

'click profile'
Mobile.tap(findTestObject('Object Repository/profile/btn_nav_profile'), 10)

'assert already login'
Mobile.verifyElementExist(findTestObject('Object Repository/profile/text_view_email', [('text') : email]), 10)