package app.pages;
import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ManageProductsPage {
    public ManageProductsPage(){PageFactory.initElements(Driver.getDriver(),this);
}
    @FindBy(xpath= "//i[@class=\"w-icon-account\"]")
    public WebElement accountButton;
    @FindBy(id= "menu-item-1079")
    public WebElement accountButton1;
    @FindBy(xpath= "//a[.=‘Store Manager’]")
    public WebElement storeManagerButton;
    @FindBy(xpath = "//div[@class=‘wcfm_menu_items wcfm_menu_wcfm-products’]")
    public WebElement productsButton;
    @FindBy(id = "add_new_product_dashboard")
    public WebElement addNewButton;
    @FindBy(id = "wcfm_products_manage_form_inventory_head")
    public WebElement inventoryButton;
    @FindBy(id = "wcfm_products_manage_form_shipping_head")
    public WebElement shippingButton;
    @FindBy(id = "wcfm_products_manage_form_attribute_head")
    public WebElement AttributesButton;
    @FindBy(id = "wcfm_products_manage_form_linked_head")
    public WebElement LinkedButton;
    @FindBy(id = "wcfm_products_manage_form_yoast_head")
    public WebElement seoButton;
    @FindBy(id = "wcfm_products_manage_form_advanced_head")
    public WebElement advancedButton;
    @FindBy(id = "sku")
    public WebElement sku_input;
    @FindBy(id = "manage_stock")
    public WebElement stockManage;
    @FindBy(name = "stock_qty")
    public WebElement stockQuantity;
    @FindBy(name = "backorders")
    public WebElement backordersSelect;
    @FindBy(id = "sold_individually")
    public WebElement soldIndButton;
    @FindBy(id = "weight")
    public WebElement weight_input;
    @FindBy(id = "length")
    public WebElement length_input;
    @FindBy(id = "width")
    public WebElement width_input;
    @FindBy(id = "__wp-uploader-id-1")
    public WebElement imageUpload;
    @FindBy(id = "height")
    public WebElement height_input;
    @FindBy(id = "shipping_class")
    public WebElement shippingClassButton;
    @FindBy(name = "_wcfmmp_processing_time")
    public WebElement processingTime;
    @FindBy(xpath = "//div[@class=‘multi_input_block wcfm_attributes_blocks wcfm_defined_attributes wcfm_attributes_block_pa_color ui-sortable-handle’]")
    public WebElement colorDropdown;
    @FindBy(id = "//span[@class=‘fields_collapser attributes_collapser wcfmfa fa-arrow-circle-down’][1]")
    public WebElement sizeDropdown;
    @FindBy(id = "product_type")
    public WebElement productTypeDropdown;
    @FindBy(id = "is_virtual")
    public WebElement virtualOption;
    @FindBy(id = "is_downloadable")
    public WebElement downloadableOption;
    @FindBy(id = "pro_title")
    public WebElement proTitle;
    @FindBy(id = "regular_price")
    public WebElement regPrice;
    @FindBy(id = "sale_price")
    public WebElement salePrice;
    @FindBy(name = "product_cats[]")
    public WebElement category;
    @FindBy(name = "product_custom_taxonomies[product_brand][]")
    public WebElement productBrands;
    @FindBy(id = "insert-media-button")
    public WebElement addShortMedia;
    @FindBy(id = "wp-description-media-buttons")
    public WebElement addMedia;
    @FindBy(id = "featured_img_display")
    public WebElement largeImageInput;
    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement smallImageInput;
    @FindBy(xpath = "//button[@class=‘browser button button-hero’]")
    public WebElement selectFilesButton;
    @FindBy(xpath = "//button[@id=‘__wp-uploader-id-4’]")
    public WebElement selectFilesButton2;
    @FindBy(xpath = "//button[@class=‘button media-button button-primary button-large media-button-select’]")
    public WebElement selectButton;
    @FindBy(xpath = "(//button[@type=‘button’])[85]")
    public WebElement uploadFilesButton;
    @FindBy(xpath = "(//button[@class=‘button media-button button-primary button-large media-button-select’])[2]")
    public WebElement addToGalleryButton;
    @FindBy(xpath = "//body[@data-id=‘excerpt’]")
    public WebElement shortDescriptionInput;
    @FindBy(xpath = "//body[@data-id=‘description’]")
    public WebElement descriptionInput;
    @FindBy(name = "submit-data")
    public WebElement submitButton;
    @FindBy(xpath= "//div[@class=‘wc-proceed-to-checkout’]")
    public WebElement addedToCard;
}