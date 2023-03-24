import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

/*
Author:Kent Vanlim
Created Date : 24 Mar 2023
Update Date :-
Notes: Create template blood sugar
*/
'click nav rekaman'
Mobile.tap(findTestObject('Object Repository/record/btn_nav_record'), 10)

'verify change date header'
Mobile.verifyElementExist(findTestObject('Object Repository/record/btn_header_top_change_date'), 10, FailureHandling.STOP_ON_FAILURE)

'click create nav rekaman'
Mobile.tap(findTestObject('Object Repository/record/btn_add_record'), 10)

'click type manual'
Mobile.tap(findTestObject('Object Repository/record/btn_choose_type_record_dynamic', [('text') : 'Manual']), 10)

'check input date visible'
Mobile.verifyElementExist(findTestObject('Object Repository/record/form input/field_input_date'), 10, FailureHandling.STOP_ON_FAILURE)

'tap type field'
Mobile.tap(findTestObject('Object Repository/record/form input/field_input_type'), 10)

'tap type record blood sugar'
Mobile.tap(findTestObject('Object Repository/record/form input/btn_input_type_record_dynamic', [('text') : 'Bangun Tidur']), 
    10)

'tap field time'
Mobile.tap(findTestObject('Object Repository/record/form input/field_input_time'), 10)

'tap confirm type'
Mobile.tap(findTestObject('Object Repository/record/form input/btn_submit_form'), 10)

'input blood sugar'
Mobile.setText(findTestObject('Object Repository/record/form input/field_input_blood_sugar'), bloodsugar, 10)

'input dinner '
Mobile.setText(findTestObject('Object Repository/record/form input/field_input_dinner'), dinner, 10)

'scroll to snack section'
Mobile.scrollToText('Apa Snack Malam anda sebelumnya')

'input snack '
Mobile.setText(findTestObject('Object Repository/record/form input/field_input_snack'), snack, 10)

'click button selesai'
Mobile.tap(findTestObject('Object Repository/record/form input/btn_finish_input_form'), 10)

'click button yes reconfirm form'
Mobile.tap(findTestObject('Object Repository/record/form input/btn_yes_reconfirm_form'), 10)