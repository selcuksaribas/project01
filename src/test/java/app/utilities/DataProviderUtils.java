package app.utilities;
import org.testng.annotations.DataProvider;
public class DataProviderUtils {
    //    Data Provider Method to get the employee credentials
    @DataProvider
    public Object[][] employeeCredentialsProvider() {
        Object[][] employeeInfo = {
                {"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };
        return employeeInfo;
    }

    //    Data Provider to get the employee credentials from the EXCEL SHEET
    @DataProvider
    public Object[][] excelEmployeeData() {
        String excelPath = "./resources/data_sheet.xlsx";
        String sheetName = "employee_credentials";
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        Object[][] employeeInfo = excelUtils.getDataArrayWithoutFirstRow();
        return employeeInfo;
    }

    //    Data Provider to get the employee credentials from the EXCEL SHEET
    @DataProvider
    public Object[][] dataTablesData() {
        String excelPath = "./resources/data_sheet.xlsx";//user data is in this excel
        String sheetName = "user_data";//user data is in this sheet
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        Object[][] employeeInfo = excelUtils.getDataArrayWithoutFirstRow();
        return employeeInfo;
    }
    @DataProvider
    public Object[][] medunnaCredentials() {

//        return new String[][]{
//                {"john_doe100", "John.123", "Doe", "Doe", "ank@b.com", "1234567890"},
//                {"john_doe101", "John.123", "Tom", "Hanks", "asc@b.com", "1234567890"},
//                {"john_doe102", "John.123", "Mary", "Star", "a3c@b.com", "1234567890"},
//                {"john_doe103", "John.123", "Terry", "Hull", "ac4@b.com", "1234567890"},
//                {"john_doe104", "John.123", "Harry", "Terry", "a5c@b.com", "1234567890"}
//        };
        ExcelUtils excelUtils = new ExcelUtils("resources/medunna_credentials.xlsx","medunna_credentials");

        return excelUtils.getDataArrayWithoutFirstRow();
    }
}