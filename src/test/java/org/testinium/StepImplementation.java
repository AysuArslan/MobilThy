package org.testinium;
import com.thoughtworks.gauge.Step;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testinium.Base.BaseTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class StepImplementation extends BaseTest {

    public String excel(int satır,int sütun) throws IOException {
        FileInputStream fs = new FileInputStream("C:\\Users\\testinium\\IdeaProjects\\MobilTestThy\\Kitap.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(satır);
        Cell cell = row.getCell(satır);
        System.out.println(sheet.getRow(satır).getCell(sütun).toString());
        return sheet.getRow(satır).getCell(sütun).toString();
    }

    @Step("Uygulama Açılır")
    public void gotoGetStartedPage() throws InterruptedException, IOException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.turkishairlines.mobile:id/frPrivacy_btnAccept")));
        clickElementByID("com.turkishairlines.mobile:id/frPrivacy_btnAccept");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.turkishairlines.mobile:id/acMain_btnBooking")));
    }

       @Step("Uçuş Aranır")
        public void searchFlight() throws InterruptedException, IOException{
            clickElementByID("com.turkishairlines.mobile:id/acMain_btnBooking");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.turkishairlines.mobile:id/frDashboard_tvOneWay")));
        }

        @Step("Tek yön seçilir")
        public void selectFlightWay() throws InterruptedException, IOException{
            clickElementByID("com.turkishairlines.mobile:id/frDashboard_tvOneWay");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.turkishairlines.mobile:id/frDashboard_tvFromCode")));
        }


        @Step("Kalkış havalimanı seçilir")
        public void selectDepartureAirport() throws InterruptedException, IOException{
            clickElementByID("com.turkishairlines.mobile:id/frDashboard_tvFromCode");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.turkishairlines.mobile:id/frAirportSelection_etSearch")));
            setElementByID("com.turkishairlines.mobile:id/frAirportSelection_etSearch", "saw");
            clickByXpath("(//android.widget.TextView[@resource-id=\"com.turkishairlines.mobile:id/itemAirport_tvBottom\"])[1]");
        }

        @Step("Varış havalimanı seçilir")
        public void selectArrivalAirport() throws InterruptedException, IOException{
            clickElementByID("com.turkishairlines.mobile:id/frDashboard_tvToCode");
            setElementByID("com.turkishairlines.mobile:id/frAirportSelection_etSearch", "esb");
            clickByXpath("(//android.widget.TextView[@resource-id=\"com.turkishairlines.mobile:id/itemAirport_tvBottom\"])[1]");
            clickElementByID("com.turkishairlines.mobile:id/frDashboard_rlDeparture");
        }

        @Step("Tarih seçilir")
        public void selectDate() throws InterruptedException, IOException{
            clickByXpath("(//android.widget.ListView[@resource-id=\"com.turkishairlines.mobile:id/frDashboard_calendarPickerView\"]//android.widget.FrameLayout)[27]");
            clickElementByID("com.turkishairlines.mobile:id/frDashboard_btnDone");
            TimeUnit.SECONDS.sleep(2);
        }

        @Step("Yetişkin sayısı +1 ve search butonuna tıklanır")
        public void plusPassenger() throws InterruptedException, IOException{
            clickByXpath("(//android.widget.ImageView[@resource-id=\"com.turkishairlines.mobile:id/cvPassengerItem_imPlus\"])[1]");
            clickElementByID("com.turkishairlines.mobile:id/frDashboard_btnSearch");
            TimeUnit.SECONDS.sleep(2);
        }

        @Step("Bilet seçilir ve ekonomi sınıfına tıklanır")
        public void selectTicket() throws InterruptedException, IOException{
            clickByXpath("(//android.view.ViewGroup[@resource-id=\"com.turkishairlines.mobile:id/itemFlightSearchParent_clRoot\"])[1]");
            TimeUnit.SECONDS.sleep(2);
            clickByXpath("(//android.view.ViewGroup[@resource-id=\"com.turkishairlines.mobile:id/brandItem\"])[1]");
            TimeUnit.SECONDS.sleep(2);
            clickElementByID("com.turkishairlines.mobile:id/frFlightSearch_btnContinue");
            TimeUnit.SECONDS.sleep(2);
        }

        @Step("Yolcu bilgileri girilir")
        public void passengerInformation() throws InterruptedException, IOException{
            clickByXpath("//android.widget.RelativeLayout[@resource-id=\"com.turkishairlines.mobile:id/frPickPassengerlistitemadd_root\"]");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.turkishairlines.mobile:id/frAddNewPassenger_etAddName")));
        }

        @Step("1.yolcu bilgileri girilir")
        public void firstPassengerInformation()throws InterruptedException, IOException{
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddName", excel(0, 1));
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddLastName", excel(0, 2));
            clickByXpath("(//android.widget.CheckBox[@resource-id=\"com.turkishairlines.mobile:id/form_checkbox_right\"])[1]");
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddDateOfBirth", excel(0, 4));
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddEmail", excel(0, 5));
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddFlyerNumber", excel(0, 8));
            clickByXpath("(//android.widget.CheckBox[@resource-id=\"com.turkishairlines.mobile:id/form_checkbox_left\"])[2]");
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddTCKN", excel(0, 7));
            clickByXpath("(//android.widget.CheckBox[@resource-id=\"com.turkishairlines.mobile:id/form_checkbox_right\"])[3]");
            clickElementByID("com.turkishairlines.mobile:id/frAddNewPassenger_btnAddPassenger");
            TimeUnit.SECONDS.sleep(2);
        }

        @Step("2.yolcu bilgileri girilir")
        public void secondPassengerInformation()throws InterruptedException, IOException{
            clickByXpath("(//android.widget.ImageView[@resource-id=\"com.turkishairlines.mobile:id/frPickPassengerlistheader_imArrow\"])[2]");
            clickByXpath("(//android.widget.ImageView[@resource-id=\"com.turkishairlines.mobile:id/frPickPassengerListItemAdd_ivArrow\"])[2]");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.turkishairlines.mobile:id/frAddNewPassenger_etAddName")));
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddName", excel(1, 1));
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddLastName", excel(1, 2));
            clickByXpath("(//android.widget.CheckBox[@resource-id=\"com.turkishairlines.mobile:id/form_checkbox_left\"])[1]");
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddDateOfBirth", excel(1, 4));
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddEmail", excel(1, 5));
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddFlyerNumber", excel(1, 8));
            clickByXpath("(//android.widget.CheckBox[@resource-id=\"com.turkishairlines.mobile:id/form_checkbox_left\"])[2]");
            sendKeys("com.turkishairlines.mobile:id/frAddNewPassenger_etAddTCKN", excel(1, 7));
            clickByXpath("(//android.widget.CheckBox[@resource-id=\"com.turkishairlines.mobile:id/form_checkbox_right\"])[3]");
            clickElementByID("com.turkishairlines.mobile:id/frAddNewPassenger_btnAddPassenger");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.turkishairlines.mobile:id/frPickPassenger_btnContinue")));
        }

        @Step("Continue butonuna tıklanır ve iptal edilir")
        public void Cancel()throws InterruptedException, IOException{
            clickElementByID("com.turkishairlines.mobile:id/frPickPassenger_btnContinue");
            clickElementByID("com.turkishairlines.mobile:id/toolbarBase_tvCancel");
        }



    public void clickElementByID(String id) {
        webDriver.findElementById(id).click();
    }

    public void setElementByID(String id,String value) {
        WebElement element = new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.clear();
        element.sendKeys(value);
    }

    public void clickByXpath(String xpath){
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public void sendKeys(String id, String text){
        webDriver.findElementById(id).sendKeys(text);
    }







}
